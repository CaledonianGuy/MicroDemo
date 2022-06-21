package com.tsi.kirk.mcallister.microdemo.business;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "rental")
public class Rental {

    //Attributes -------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id", nullable = false)
    private int rentalId;
    @Column(name = "rental_date", nullable = false)
    private LocalDateTime rentalDate;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id", nullable = false)
    private Integer inventoryId;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private Integer customerId;
    @Column(name = "return_date")
    private LocalDateTime returnDate;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id", nullable = false)
    private Integer staffId;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public Rental() {}

    public Rental(LocalDateTime rentalDate, Integer inventoryId, Integer customerId, Integer staffId) {
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
