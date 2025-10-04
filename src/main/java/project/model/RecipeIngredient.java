package project.model;

public class RecipeIngredient {
	private Long recipeId;
    private Long ingredientId;
    private Long ingredientAmount;
    private Ingredient ingredient;
    
    public RecipeIngredient(Long recipeId, Long ingredientId, Long ingredientAmount) {
        this.recipeId = recipeId;
        this.ingredientId = ingredientId;
        this.ingredientAmount = ingredientAmount;
    }

	public Long getRecipeId() {
		return recipeId;
	}

	public void setRecipeId(Long recipeId) {
		this.recipeId = recipeId;
	}

	public Long getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(Long ingredientId) {
		this.ingredientId = ingredientId;
	}

	public Long getIngredientAmount() {
		return ingredientAmount;
	}

	public void setIngredientAmount(Long ingredientAmount) {
		this.ingredientAmount = ingredientAmount;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	@Override
	public String toString() {
        return "RecipeIngredient{recipeId=" + recipeId + ", ingredientId=" + ingredientId +
                ", ingredientAmount=" + ingredientAmount + ", ingredient=" + ingredient + "}";
    }
    
}
