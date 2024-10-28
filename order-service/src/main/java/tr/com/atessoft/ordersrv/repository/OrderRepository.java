package tr.com.atessoft.ordersrv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tr.com.atessoft.ordersrv.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
