package com.tsi.kirk.mcallister.microdemo.inventory;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "inventory")
public class Inventory {

    //Attributes -------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int inventoryId;
    Integer filmId;
    Integer storeId;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public Inventory() {}

    public Inventory(Integer filmId, Integer storeId) {
        this.filmId = filmId;
        this.storeId = storeId;
    }
    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------
    public int getInventoryId() {
        return inventoryId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
    // -----------------------------------------------------------------------

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------
}
