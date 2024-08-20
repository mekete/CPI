package edu.uw.cpi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Cpis")
public class Cpi {
    @Id
    @GeneratedValue()
    private Long id;

    @Column(name = "cpi_month")
    private String month;

    @Column(name = "cpi_year")
    private int year;


    @Column(name = "cpi_value")
    private String value;


    @Column(name = "cpi_text")
    private String text;
    public Cpi() {
    }

    public Cpi(Long id, String month, int year) {
        this.id = id;
        this.month = month;
        this.year = year;
    }
    public Cpi( String month, int year, String value, String text ) {
        this.id = id;
        this.month = month;
        this.year = year;
    }

    public Cpi(String month, int year) {
        this.month = month;
        this.year = year;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
