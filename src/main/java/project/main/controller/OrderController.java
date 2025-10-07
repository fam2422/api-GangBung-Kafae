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

import project.main.model.Order;
import project.main.response.order.OrderService;

@RestController
@RequestMapping("/api/gangbung")
public class OrderController {

	private final OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getOrder(){
		List<Order> orders = orderService.getOrders();
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("id") Long Id){
		Order orders = orderService.getOrderById(Id);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}
	
	@PostMapping("/order")
	public ResponseEntity<Order> addNewOrder(@RequestBody Order order) {
		System.out.println(order);
		Order saveOrder = orderService.addOrder(order);
		return new ResponseEntity<>(saveOrder, HttpStatus.CREATED);
	}
	
	@PutMapping("/order/{id}")
	public ResponseEntity<Order> updateOrder(@RequestBody Order newOrder, @PathVariable Long id) {
		Order updateOrder = orderService.updateOrder(id, newOrder);
		return ResponseEntity.ok(updateOrder);
	}

	@DeleteMapping("/order/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
		orderService.deleteById(id);
		return ResponseEntity.ok("Order deleted successfully");
	}
}