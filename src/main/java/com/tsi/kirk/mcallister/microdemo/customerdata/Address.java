package com.tsi.kirk.mcallister.microdemo.customerdata;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "address")
public class Address {

    //Attributes -------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    private int addressId;
    @Column(name = "address", nullable = false)
    private String address1;
    @Column(name = "address2")
    private String address2;
    @Column(name = "district", nullable = false)
    private String district;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "city_id", nullable = false)
    private Integer cityId;
    @Column(name = "postal_code")
    private String postCode;
    @Column(name = "phone", nullable = false)
    private String phone;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public Address() {}

    public Address(String address1, String district, Integer cityId, String phone) {
        this.address1 = address1;
        this.district = district;
        this.cityId = cityId;
        this.phone = phone;
    }
    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address) {
        this.address1 = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    // -----------------------------------------------------------------------

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------
}
