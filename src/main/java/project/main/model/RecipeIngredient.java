package project.main.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "recipe_ingredient")
public class RecipeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    @JsonBackReference("recipe-ingredients")
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    private Long ingredientAmount;

    public RecipeIngredient() { }

    public RecipeIngredient(Recipe recipe, Ingredient ingredient, Long ingredientAmount) {
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.ingredientAmount = ingredientAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Long getIngredientAmount() {
        return ingredientAmount;
    }

    public void setIngredientAmount(Long ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }

    @Override
    public String toString() {
        return "RecipeIngredient{id=" + id + ", recipe=" + (recipe != null ? recipe.getId() : null) +
               ", ingredient=" + (ingredient != null ? ingredient.getId() : null) +
               ", ingredientAmount=" + ingredientAmount + "}";
    }
}
