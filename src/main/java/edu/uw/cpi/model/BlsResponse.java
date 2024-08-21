package edu.uw.cpi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

public class BlsResponse implements Serializable {

    public Integer id;

    public String status;
    public int responseTime;
    public ArrayList<Object> message;
    @JsonProperty("Results")
    public Results results;
}


