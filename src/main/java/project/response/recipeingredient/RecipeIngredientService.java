package project.response.recipeingredient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.model.RecipeIngredient;

@Service
public class RecipeIngredientService {
	@Autowired
	RecipeIngredientRepository recipeIngredientRepo;
	public List<RecipeIngredient> getRecipeIngredients(){
		List<RecipeIngredient> recipeIngredients = (List<RecipeIngredient>) recipeIngredientRepo.findAll();
		return recipeIngredients;
	}
	
	public RecipeIngredient getRecipeIngredientById(Long id){
		return recipeIngredientRepo.findById(id).orElseThrow(()->
		new RecipeIngredientNotFoundException(id));
	}	 
	
	public void save(RecipeIngredient r) {
		recipeIngredientRepo.save(r);
	}
	
	public RecipeIngredient addRecipeIngredient(RecipeIngredient r) {
		recipeIngredientRepo.save(r);
		return r;
	}
	
	public void deleteById(Long id) {
		RecipeIngredient recipeIngredient = recipeIngredientRepo.findById(id).orElseThrow(()->
		new RecipeIngredientNotFoundException(id));
		
		recipeIngredientRepo.delete(recipeIngredient);
	}
	
	public RecipeIngredient updateRecipeIngredient(Long id,RecipeIngredient r) {
		RecipeIngredient existingRecipeIngredient = recipeIngredientRepo.findById(id).get();
		existingRecipeIngredient.setRecipeId(r.getRecipeId());
		existingRecipeIngredient.setIngredient(r.getIngredient());
		existingRecipeIngredient.setIngredientAmount(r.getIngredientAmount());
		return recipeIngredientRepo.save(existingRecipeIngredient);
	}
}
