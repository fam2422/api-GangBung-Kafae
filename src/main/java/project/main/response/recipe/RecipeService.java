// RecipeService.java
package project.main.response.recipe;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.main.model.Ingredient;
import project.main.model.Menu;
import project.main.model.Recipe;
import project.main.model.RecipeIngredient;
import project.main.response.ingredient.IngredientNotFoundException;
import project.main.response.ingredient.IngredientRepository;
import project.main.response.menu.MenuNotFoundException;
import project.main.response.menu.MenuRepository;

@Service
public class RecipeService {
	@Autowired
	RecipeRepository recipeRepo;
	
	@Autowired
	MenuRepository menuRepo;
	
	@Autowired
	IngredientRepository ingredientRepo;
	
	public List<Recipe> getRecipes(){
		List<Recipe> orders = (List<Recipe>) recipeRepo.findAll();
		return orders;
	}
	
	public Recipe getRecipeById(Long id){
		return recipeRepo.findById(id).orElseThrow(()->
		new RecipeNotFoundException(id));
	}	 
	
	public void save(Recipe r) {
		recipeRepo.save(r);
	}
	
	public Recipe addRecipe(Recipe recipe) {
	    if (recipe.getIngredients() != null) {
	        for (RecipeIngredient ri : recipe.getIngredients()) {
	            // fetch Ingredient จริงจาก DB
	            Ingredient ingredientFromDb = ingredientRepo.findById(ri.getIngredient().getId())
	                .orElseThrow(() -> new IngredientNotFoundException(ri.getIngredient().getId()));
	            ri.setIngredient(ingredientFromDb); // ใส่ Ingredient จริง
	            ri.setRecipe(recipe); // เชื่อมกลับไป Recipe
	        }
	    }
	    return recipeRepo.save(recipe);
	}
	
	public void deleteById(Long id) {
		Recipe recipe = recipeRepo.findById(id).orElseThrow(()->
		new RecipeNotFoundException(id));
		
		recipeRepo.delete(recipe);
	}
	
	public Recipe updateRecipe(Long id, Recipe r) {
	    Recipe existingRecipe = recipeRepo.findById(id)
	            .orElseThrow(() -> new RecipeNotFoundException(id));
	    
	    existingRecipe.setSweetness(r.getSweetness());
	    // เชื่อม RecipeIngredient กับ Recipe ก่อน save
	    if (r.getIngredients() != null) {
	        for (var ri : r.getIngredients()) {
	            ri.setRecipe(existingRecipe);
	        }
	    }
	    existingRecipe.setIngredients(r.getIngredients());
	    return recipeRepo.save(existingRecipe);
	}
	
	// เพิ่ม method ใหม่สำหรับดึง recipes ตาม menu id
	public List<Recipe> getRecipesByMenuId(Long menuId) {
	    Menu menu = menuRepo.findById(menuId)
	        .orElseThrow(() -> new MenuNotFoundException(menuId));
	    
	    // ถ้า Menu มี Recipe (One-to-One)
	    if (menu.getRecipe() != null) {
	        List<Recipe> recipes = new ArrayList<>();
	        recipes.add(menu.getRecipe());
	        return recipes;
	    }
	    
	    // ถ้าไม่มี recipe คืน empty list
	    return new ArrayList<>();
	}
}