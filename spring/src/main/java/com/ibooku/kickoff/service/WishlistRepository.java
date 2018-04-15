package com.ibooku.kickoff.service;

import org.springframework.data.repository.CrudRepository;

import com.ibooku.kickoff.model.Wishlist;

public interface WishlistRepository extends CrudRepository<Wishlist, Long> {
}
