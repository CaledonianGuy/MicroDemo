package com.tsi.kirk.mcallister.microdemo;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "inventory")
public class InventoryItem {

    //Attributes -------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int inventoryId;
    int filmId;
    int storeId;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public InventoryItem() {}

    public InventoryItem(int filmId, int storeId) {
        this.filmId = filmId;
        this.storeId = storeId;
    }
    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------
    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
    // -----------------------------------------------------------------------

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------


    //Attributes -------------------------------------------------------------

    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------

    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------

    // -----------------------------------------------------------------------

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------
}
