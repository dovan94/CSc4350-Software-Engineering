package com.ibooku.kickoff.service;

import org.springframework.data.repository.CrudRepository;

import com.ibooku.kickoff.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Long> {
  //Long removeByUser_id(String user_id);
}
