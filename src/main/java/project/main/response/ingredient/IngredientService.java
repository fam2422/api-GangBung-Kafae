package project.main.response.ingredient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.main.model.Ingredient;

@Service
public class IngredientService {
	@Autowired
	IngredientRepository ingredientRepo;
	
	public List<Ingredient> getIngredients(){
		List<Ingredient> ingredients = (List<Ingredient>) ingredientRepo.findAll();
		return ingredients;
	}
	
	public Ingredient getIngredientById(Long id){
		return ingredientRepo.findById(id).orElseThrow(()->
		new IngredientNotFoundException(id));
	}	 
	
	public void save(Ingredient i) {
		ingredientRepo.save(i);
	}
	
	public Ingredient addIngredient(Ingredient i) {
		ingredientRepo.save(i);
		return i;
	}
	
	public void deleteById(Long id) {
		Ingredient ingredient = ingredientRepo.findById(id).orElseThrow(()->
		new IngredientNotFoundException(id));
		
		ingredientRepo.delete(ingredient);
	}
	
	public Ingredient updateIngredient(Long id,Ingredient i) {
		Ingredient existingIngredient = ingredientRepo.findById(id).get();
		existingIngredient.setName(i.getName());
		existingIngredient.setStockQty(i.getStockQty());
		existingIngredient.setUnit(i.getUnit() != null ? i.getUnit() : existingIngredient.getUnit());
		return ingredientRepo.save(existingIngredient);
	}
}
