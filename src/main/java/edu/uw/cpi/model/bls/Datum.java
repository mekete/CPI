
package edu.uw.cpi.model.bls;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import edu.uw.cpi.model.Cpi;

public class Datum {

    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("period")
    @Expose
    private String period;
    @SerializedName("periodName")
    @Expose
    private String periodName;
    @SerializedName("latest")
    @Expose
    private String latest;
    @SerializedName("value")
    @Expose
    private String value="";
    @SerializedName("footnotes")
    @Expose
    private List<Footnote> footnotes;


    public Cpi asCpi() {
        String text=period;
        if(footnotes!=null && !footnotes.isEmpty()){
            for (Footnote footnote : footnotes) {
                text=text+footnote.getText();
            }
        }else{}
        return new Cpi(periodName, Integer.valueOf( year), value, text);
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    public String getLatest() {
        return latest;
    }

    public void setLatest(String latest) {
        this.latest = latest;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Footnote> getFootnotes() {
        return footnotes;
    }

    public void setFootnotes(List<Footnote> footnotes) {
        this.footnotes = footnotes;
    }

}
