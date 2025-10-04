package project.response.order;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import project.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{

}
