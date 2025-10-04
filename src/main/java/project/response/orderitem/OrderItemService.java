package project.response.orderitem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.model.OrderItem;

@Service
public class OrderItemService {
	@Autowired
	OrderItemRepository orderItemRepo;
	public List<OrderItem> getOrderItems(){
		List<OrderItem> orderitemss = (List<OrderItem>) orderItemRepo.findAll();
		return orderitemss;
	}
	
	public OrderItem getOrderItemById(Long id){
		return orderItemRepo.findById(id).orElseThrow(()->
		new OrderItemNotFoundException(id));
	}	 
	
	public void save(OrderItem o) {
		orderItemRepo.save(o);
	}
	
	public OrderItem addOrderItem(OrderItem o) {
		orderItemRepo.save(o);
		return o;
	}
	
	public void deleteById(Long id) {
		OrderItem orderItem = orderItemRepo.findById(id).orElseThrow(()->
		new OrderItemNotFoundException(id));
		
		orderItemRepo.delete(orderItem);
	}
	
	public OrderItem updateOrderItem(Long id,OrderItem oi) {
		OrderItem existingOrderItem = orderItemRepo.findById(id).get();
		existingOrderItem.setMenuId(oi.getMenuId());
		existingOrderItem.setOrderId(oi.getOrderId());
		existingOrderItem.setQty(oi.getQty());
		return orderItemRepo.save(existingOrderItem);
	}
}
