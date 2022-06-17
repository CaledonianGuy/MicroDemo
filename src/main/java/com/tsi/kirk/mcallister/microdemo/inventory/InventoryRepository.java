package com.tsi.kirk.mcallister.microdemo.inventory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Integer> {

}
