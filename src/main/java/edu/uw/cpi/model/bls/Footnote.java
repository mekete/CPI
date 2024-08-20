
package edu.uw.cpi.model.bls;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Footnote {

    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("text")
    @Expose
    private String text;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
