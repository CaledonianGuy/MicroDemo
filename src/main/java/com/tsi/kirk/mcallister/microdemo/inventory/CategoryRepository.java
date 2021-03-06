package com.tsi.kirk.mcallister.microdemo.inventory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

    Optional<Category> findByName(String catName);
}
