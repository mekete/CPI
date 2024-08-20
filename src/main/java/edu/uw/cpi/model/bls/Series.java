
package edu.uw.cpi.model.bls;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import edu.uw.cpi.model.Cpi;

public class Series {

    @SerializedName("seriesID")
    @Expose
    private String seriesID;
    @SerializedName("data")
    @Expose
    private List<Datum> data;

    public String getSeriesID() {
        return seriesID;
    }

    public void setSeriesID(String seriesID) {
        this.seriesID = seriesID;
    }

    public List<Datum> getData() {
        return data;
    }

    public List<Cpi> getCpis() {
        return (data == null)
                ? Collections.emptyList()
                : data.stream()
                .map(Datum::asCpi)
                .collect(Collectors.toList());
    }


    public void setData(List<Datum> data) {
        this.data = data;
    }

}
