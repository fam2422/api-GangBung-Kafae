package project.main.response.menu;

public class MenuNotFoundException extends RuntimeException{
	public MenuNotFoundException(Long id) {
		super("Cloud not find menu "+id);
	}
}
