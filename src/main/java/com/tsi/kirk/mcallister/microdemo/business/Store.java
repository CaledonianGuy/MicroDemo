package com.tsi.kirk.mcallister.microdemo.business;

import jakarta.persistence.*;

@Entity
@Table(name = "store")
public class Store {

    //Attributes -------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int storeId;
    int managerStaffId;
    int addressId;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public Store() {}

    public Store(int managerId, int addressId) {
        this.managerStaffId = managerId;
        this.addressId = addressId;
    }
    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------
    public int getStoreId() {
        return storeId;
    }

    public Integer getManagerId() {
        return managerStaffId;
    }

    public void setManagerId(Integer managerId) {
        this.managerStaffId = managerId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    // -----------------------------------------------------------------------

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------
}
