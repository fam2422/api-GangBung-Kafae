package project.main.response.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.main.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
