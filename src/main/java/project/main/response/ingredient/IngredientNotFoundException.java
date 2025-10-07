package project.main.response.ingredient;

public class IngredientNotFoundException extends RuntimeException{
	public IngredientNotFoundException(Long id) {
		super("Cloud not find ingredient "+id);
	}
}
