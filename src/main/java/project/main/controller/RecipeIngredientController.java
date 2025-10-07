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

import project.main.model.RecipeIngredient;
import project.main.response.recipeingredient.RecipeIngredientService;

@RestController
@RequestMapping("/api/gangbung")
public class RecipeIngredientController {

	private final RecipeIngredientService recipeIngredientService;
	
	public RecipeIngredientController(RecipeIngredientService recipeIngredientService) {
		this.recipeIngredientService = recipeIngredientService;
	}
	
	@GetMapping("/recipe-ingredients")
	public ResponseEntity<List<RecipeIngredient>> getRecipeIngredients() {
		List<RecipeIngredient> recipeIngredients = recipeIngredientService.getRecipeIngredients();
		return new ResponseEntity<>(recipeIngredients, HttpStatus.OK);
	}

	@GetMapping("/recipe-ingredient/{id}")
	public ResponseEntity<RecipeIngredient> getRecipeIngredientById(@PathVariable("id") Long Id) {
		RecipeIngredient recipeIngredient = recipeIngredientService.getRecipeIngredientById(Id);
		return new ResponseEntity<>(recipeIngredient, HttpStatus.OK);
	}

	@PostMapping("/recipe-ingredient")
	public ResponseEntity<RecipeIngredient> addNewRecipeIngredient(@RequestBody RecipeIngredient recipeIngredient) {
		System.out.println(recipeIngredient);
		RecipeIngredient saveRecipeIngredient = recipeIngredientService.addRecipeIngredient(recipeIngredient);
		return new ResponseEntity<>(saveRecipeIngredient, HttpStatus.CREATED);
	}

	@PutMapping("/recipe-ingredient/{id}")
	public ResponseEntity<RecipeIngredient> updateRecipeIngredient(@RequestBody RecipeIngredient newRecipeIngredient, @PathVariable Long id) {
		RecipeIngredient updateRecipeIngredient = recipeIngredientService.updateRecipeIngredient(id, newRecipeIngredient);
		return ResponseEntity.ok(updateRecipeIngredient);
	}

	@DeleteMapping("/recipe-ingredient/{id}")
	public ResponseEntity<String> deleteRecipeIngredient(@PathVariable Long id) {
		recipeIngredientService.deleteById(id);
		return ResponseEntity.ok("RecipeIngredient deleted successfully");
	}
}