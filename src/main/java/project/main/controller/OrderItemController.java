package project.main.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import project.main.model.OrderItem;
import project.main.response.orderitem.OrderItemService;

@RestController
@RequestMapping("/api/gangbung")
public class OrderItemController {

	private final OrderItemService orderItemService;
	
	public OrderItemController(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}
	
	@GetMapping("/orderitems")
	public ResponseEntity<List<OrderItem>> getOrderItem(){
		List<OrderItem> orderItems = orderItemService.getOrderItems();
		return new ResponseEntity<>(orderItems, HttpStatus.OK);
	}

	@GetMapping("/order-item/{id}")
	public ResponseEntity<OrderItem> getOrderItemById(@PathVariable("id") Long Id){
		OrderItem orderItems = orderItemService.getOrderItemById(Id);
		return new ResponseEntity<>(orderItems, HttpStatus.OK);
	}
	
	@PostMapping("/order-item")
	public ResponseEntity<OrderItem> addNewOrderItem(@RequestBody OrderItem orderItem) {
		System.out.println(orderItem);
		OrderItem saveOrderItem = orderItemService.addOrderItem(orderItem);
		return new ResponseEntity<>(saveOrderItem, HttpStatus.CREATED);
	}
	
	@PutMapping("/order-item/{id}")
	public ResponseEntity<OrderItem> updateOrderItem(@RequestBody OrderItem newOrderItem, @PathVariable Long id) {
		OrderItem updateOrderItem = orderItemService.updateOrderItem(id, newOrderItem);
		return ResponseEntity.ok(updateOrderItem);
	}

	@DeleteMapping("/order-item/{id}")
	public ResponseEntity<String> deleteOrderItem(@PathVariable Long id) {
		orderItemService.deleteById(id);
		return ResponseEntity.ok("OrderItem deleted successfully");
	}
}