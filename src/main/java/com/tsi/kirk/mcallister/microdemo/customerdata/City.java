package com.tsi.kirk.mcallister.microdemo.customerdata;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "city")
public class City {

    //Attributes -------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id", nullable = false)
    private int cityId;
    @Column(name = "city", nullable = false)
    private String cityName;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
    private Integer countryId;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public City() {}

    public City(String city, Integer countryId) {
        this.cityName = city;
        this.countryId = countryId;
    }
    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }
    // -----------------------------------------------------------------------

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------
}
