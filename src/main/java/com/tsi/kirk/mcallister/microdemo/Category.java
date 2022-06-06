package com.tsi.kirk.mcallister.microdemo;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "category")
public class Category {

    //Attributes -------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int categoryId;
    String name;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public Category() {}

    public Category(String name) {
        this.name = name;
    }
    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // -----------------------------------------------------------------------

    //Methods ----------------------------------------------------------------

    // -----------------------------------------------------------------------
}
