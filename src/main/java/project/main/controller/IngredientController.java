package project.main.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import project.main.model.Ingredient;
import project.main.response.ingredient.IngredientService;

@RestController
@RequestMapping("/api/gangbung")
public class IngredientController {

	private final IngredientService ingredientService;
	
	public IngredientController(IngredientService ingredientService) {
		this.ingredientService = ingredientService;
	}
	
	@GetMapping("/ingredients")
	public ResponseEntity<List<Ingredient>> getIngredients() {
		List<Ingredient> ingredients = ingredientService.getIngredients();
		return new ResponseEntity<>(ingredients, HttpStatus.OK);
	}

	@GetMapping("/ingredient/{id}")
	public ResponseEntity<Ingredient> getIngredientById(@PathVariable("id") Long Id) {
		Ingredient ingredient = ingredientService.getIngredientById(Id);
		return new ResponseEntity<>(ingredient, HttpStatus.OK);
	}

	@PostMapping("/ingredient")
	public ResponseEntity<Ingredient> addNewIngredient(@RequestBody Ingredient ingredient) {
		System.out.println(ingredient);
		Ingredient saveIngredient = ingredientService.addIngredient(ingredient);
		return new ResponseEntity<>(saveIngredient, HttpStatus.CREATED);
	}

	@PutMapping("/ingredient/{id}")
	public ResponseEntity<Ingredient> updateIngredient(@RequestBody Ingredient newIngredient, @PathVariable Long id) {
		Ingredient updateIngredient = ingredientService.updateIngredient(id, newIngredient);
		return ResponseEntity.ok(updateIngredient);
	}

	@DeleteMapping("/ingredient/{id}")
	public ResponseEntity<String> deleteIngredient(@PathVariable Long id) {
		ingredientService.deleteById(id);
		return ResponseEntity.ok("Ingredient deleted successfully");
	}
}