package com.tsi.kirk.mcallister.microdemo.inventory;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "Language")
public class Language {

    //Attributes -------------------------------------------------------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int languageId;
    String name;
    // -----------------------------------------------------------------------

    //Constructors -----------------------------------------------------------
    public Language() {}

    public Language(String name) {
        this.name = name;
    }
    // -----------------------------------------------------------------------

    //Getters & Setters ------------------------------------------------------
    public int getLanguageId() {
        return languageId;
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
