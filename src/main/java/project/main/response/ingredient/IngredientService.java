package project.main.response.ingredient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.main.model.Ingredient;
import project.main.response.location.LocationRepository;

@Service
public class IngredientService {
	@Autowired
	IngredientRepository ingredientRepo;
	@Autowired
	LocationRepository locationRepo;
	
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
	
	public Ingredient addIngredient(Ingredient ingredient) {
	    return ingredientRepo.save(ingredient);
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
		existingIngredient.setUnit(i.getUnit());
		return ingredientRepo.save(existingIngredient);
	}
}
