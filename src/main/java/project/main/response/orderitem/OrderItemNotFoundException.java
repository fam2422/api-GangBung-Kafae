package project.main.response.orderitem;

public class OrderItemNotFoundException extends RuntimeException{
	public OrderItemNotFoundException(Long id) {
		super("Cloud not find orderitem "+id);
	}

}
