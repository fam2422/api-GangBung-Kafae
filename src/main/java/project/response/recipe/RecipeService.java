package project.response.recipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.model.Recipe;

@Service
public class RecipeService {
	@Autowired
	RecipeRepository recipeRepo;
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
	
	public Recipe addRecipe(Recipe r) {
		recipeRepo.save(r);
		return r;
	}
	
	public void deleteById(Long id) {
		Recipe recipe = recipeRepo.findById(id).orElseThrow(()->
		new RecipeNotFoundException(id));
		
		recipeRepo.delete(recipe);
	}
	
	public Recipe updateRecipe(Long id,Recipe r) {
		Recipe existingRecipe = recipeRepo.findById(id).get();
		existingRecipe.setIngredients(r.getIngredients());
		existingRecipe.setMenuId(r.getMenuId());
		existingRecipe.setSweetness(r.getSweetness());
		return recipeRepo.save(existingRecipe);
	}
}
