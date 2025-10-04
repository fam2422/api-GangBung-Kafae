package project.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="recipe")
public class Recipe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
    private Long menuId;
    private int sweetness;
    private List<RecipeIngredient> ingredients = new ArrayList<>();

    public Recipe(Long id, Long menuId, int sweetness) {
        this.id = id;
        this.menuId = menuId;
        this.sweetness = sweetness;
    }
    
    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(RecipeIngredient ingredient) {
        this.ingredients.add(ingredient);
    }
    
    public void removeIngredient(RecipeIngredient ingredient) {
    	this.ingredients.remove(ingredient);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public int getSweetness() {
		return sweetness;
	}

	public void setSweetness(int sweetness) {
		this.sweetness = sweetness;
	}

	public void setIngredients(List<RecipeIngredient> ingredients) {
		this.ingredients = ingredients;
	}
    
    
}
