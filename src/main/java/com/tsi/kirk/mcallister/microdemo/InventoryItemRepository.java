package com.tsi.kirk.mcallister.microdemo;

import org.springframework.data.repository.CrudRepository;

public interface InventoryItemRepository extends CrudRepository<InventoryItem, Integer> {

}
