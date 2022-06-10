package com.tsi.kirk.mcallister.microdemo.inventory;

import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {

}
