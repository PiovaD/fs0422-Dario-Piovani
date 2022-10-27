package m5w1d4es.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import m5w1d4es.model.order.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Integer>{

}
