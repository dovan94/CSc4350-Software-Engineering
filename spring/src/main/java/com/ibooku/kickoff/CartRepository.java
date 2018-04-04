package com.ibooku.kickoff;

import org.springframework.data.repository.CrudRepository;
import com.ibooku.kickoff.Cart;

public interface CartRepository extends CrudRepository<Cart, Long> {

}
