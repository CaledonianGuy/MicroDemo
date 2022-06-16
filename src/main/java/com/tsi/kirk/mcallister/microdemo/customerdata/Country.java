package com.tsi.kirk.mcallister.microdemo.customerdata;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "country")
public class Country {

    //Attributes -------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    private int countryId;
    @Column(name = "county", nullable = false)
    private String countryName;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public Country() {}

    public Country(String country) {
        this.countryName = country;
    }
    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    // -----------------------------------------------------------------------

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------
}
