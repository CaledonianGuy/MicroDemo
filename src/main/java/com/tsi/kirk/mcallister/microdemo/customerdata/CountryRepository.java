package com.tsi.kirk.mcallister.microdemo.customerdata;

import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {
}
