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

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getManagerId() {
        return managerStaffId;
    }

    public void setManagerId(int managerId) {
        this.managerStaffId = managerId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
    // -----------------------------------------------------------------------

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------
}
