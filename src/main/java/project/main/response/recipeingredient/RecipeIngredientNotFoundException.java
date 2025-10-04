package project.main.response.recipeingredient;

public class RecipeIngredientNotFoundException extends RuntimeException{
	public RecipeIngredientNotFoundException(Long id) {
		super("Cloud not find recipe ingredient "+id);
	}
}