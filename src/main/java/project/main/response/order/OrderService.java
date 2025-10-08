package project.main.response.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.main.model.Menu;
import project.main.model.Order;
import project.main.model.OrderItem;
import project.main.response.menu.MenuRepository;

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
	
	@Autowired
	MenuRepository menuRepo;

	public Order addOrder(Order o) {
	    for (OrderItem oi : o.getOrderItems()) {
	        if (oi.getMenu() != null && oi.getMenu().getId() != null) {
	            Menu menuFromDb = menuRepo.findById(oi.getMenu().getId())
	                .orElseThrow(() -> new RuntimeException("Menu not found"));
	            oi.setMenu(menuFromDb);
	            oi.setOrder(o); // important! set back reference
	        }
	    }
	    return orderRepo.save(o);
	}

	
	public void deleteById(Long id) {
		Order order = orderRepo.findById(id).orElseThrow(()->
		new OrderNotFoundException(id));
		
		orderRepo.delete(order);
	}
	
	public Order updateOrder(Long id,Order o) {
		Order existingOrder = orderRepo.findById(id).get();
		existingOrder.setOrderItems(o.getOrderItems());
		return orderRepo.save(existingOrder);
	}
	
	
	
}
