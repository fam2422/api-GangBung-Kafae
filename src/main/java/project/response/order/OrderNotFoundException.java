package project.response.order;

public class OrderNotFoundException extends RuntimeException{
	public OrderNotFoundException(Long id) {
		super("Cloud not find order "+id);
	}
}
