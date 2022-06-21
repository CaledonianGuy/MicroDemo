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
    private Integer managerStaffId;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
    private Integer addressId;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public Store() {}

    public Store(Integer managerId, Integer addressId) {
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

    public Integer getManagerStaffId() {
        return managerStaffId;
    }

    public void setManagerStaffId(Integer managerStaffId) {
        this.managerStaffId = managerStaffId;
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
