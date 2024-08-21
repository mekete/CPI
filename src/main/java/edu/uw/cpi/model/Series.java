
package edu.uw.cpi.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import edu.uw.cpi.model.Book;

public class Series {

    @SerializedName("seriesID")
    @Expose
    private String seriesID;
    @SerializedName("data")
    @Expose
    private List<Datum> data;


    public List<Book> getBooks() {
        return (data == null || data.isEmpty())
                ? Collections.emptyList()
                : data.stream()
                .map(Datum::asBook)
                .collect(Collectors.toList());
    }

    public String getSeriesID() {
        return seriesID;
    }

    public void setSeriesID(String seriesID) {
        this.seriesID = seriesID;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}
