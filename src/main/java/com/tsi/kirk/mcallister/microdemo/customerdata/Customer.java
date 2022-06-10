package com.tsi.kirk.mcallister.microdemo.customerdata;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Table(name = "customer")
public class Customer {

    //Attributes -------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int customerId;
    int storeId;
    String firstName;
    String lastName;
    String email;
    int addressId;
    Boolean active;
    LocalDateTime createDate;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public Customer() {}

    public Customer(int storeId,
                    String firstName,
                    String lastName,
                    int addressId,
                    Boolean active,
                    LocalDateTime createDate) {
        this.storeId = storeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressId = addressId;
        this.active = active;
        this.createDate = createDate;
    }
    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------
    public int getCustomerId() {
        return customerId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    // -----------------------------------------------------------------------

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------
}
