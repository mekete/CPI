package edu.uw.cpi.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Datum implements Serializable {
    public String year;
    public String period;
    public String periodName;
    public String latest;
    public String value;
    public ArrayList<Footnote> footnotes;
}
