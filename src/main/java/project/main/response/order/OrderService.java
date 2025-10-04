package project.main.response.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.main.model.Order;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepo;
	public List<Order> getOrders(){
		List<Order> orders = (List<Order>) orderRepo.findAll();
		return orders;
	}
	
	public Order getOrderById(Long id){
		return orderRepo.findById(id).orElseThrow(()->
		new OrderNotFoundException(id));
	}	 
	
	public void save(Order o) {
		orderRepo.save(o);
	}
	
	public Order addOrder(Order o) {
		orderRepo.save(o);
		return o;
	}
	
	public void deleteById(Long id) {
		Order order = orderRepo.findById(id).orElseThrow(()->
		new OrderNotFoundException(id));
		
		orderRepo.delete(order);
	}
	
	public Order updateOrder(Long id,Order o) {
		Order existingOrder = orderRepo.findById(id).get();
		existingOrder.setOrderItems(o.getOrderItems());
		existingOrder.setStatus(o.getStatus());
		return orderRepo.save(existingOrder);
	}
	
	
	
}
