package com.ibooku.kickoff.service;

import org.springframework.data.repository.CrudRepository;

import com.ibooku.kickoff.model.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

  
}
