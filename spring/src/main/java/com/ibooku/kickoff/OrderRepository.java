package com.ibooku.kickoff;

import org.springframework.data.repository.CrudRepository;
import com.ibooku.kickoff.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

}
