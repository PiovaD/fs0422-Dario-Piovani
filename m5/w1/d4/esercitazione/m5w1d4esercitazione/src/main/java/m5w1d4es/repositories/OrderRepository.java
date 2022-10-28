package m5w1d4es.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import m5w1d4es.model.order.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}