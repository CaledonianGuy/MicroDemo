package com.tsi.kirk.mcallister.microdemo.business;

import jakarta.persistence.*;

@Entity
@Table(name = "store")
public class Store {

    //Attributes -------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id", nullable = false)
    private int storeId;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_staff_id", referencedColumnName = "staff_id", nullable = false)
    private int managerStaffId;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
    private int addressId;
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

    public int getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(int managerStaffId) {
        this.managerStaffId = managerStaffId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
    // -----------------------------------------------------------------------

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------
}
