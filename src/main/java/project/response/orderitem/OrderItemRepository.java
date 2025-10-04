package project.response.orderitem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import project.model.OrderItem;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long>{

}
