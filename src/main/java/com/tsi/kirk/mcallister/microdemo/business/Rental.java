package com.tsi.kirk.mcallister.microdemo.business;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "rental")
public class Rental {

    //Attributes -------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int rentalId;
    LocalDateTime rentalDate;
    int inventoryId;
    int customerId;
    LocalDateTime returnDate;
    int staffId;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public Rental() {}

    public Rental(LocalDateTime rentalDate, int inventoryId, int customerId, int staffId) {
        this.rentalDate = rentalDate;
        this.inventoryId  = inventoryId;
        this.customerId = customerId;
        this.staffId = staffId;
    }
    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------
    public int getRentalId() {
        return rentalId;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
    // -----------------------------------------------------------------------

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------
}
