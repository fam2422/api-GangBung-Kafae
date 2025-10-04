package project.main.response.recipe;

public class RecipeNotFoundException extends RuntimeException{
	public RecipeNotFoundException(Long id) {
		super("Cloud not find recipe "+id);
	}
}
