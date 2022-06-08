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

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }
    // -----------------------------------------------------------------------

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------
}
