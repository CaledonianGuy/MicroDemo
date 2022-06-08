package com.tsi.kirk.mcallister.microdemo.business;

import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {

}
