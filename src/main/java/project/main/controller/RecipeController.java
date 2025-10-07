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

import project.main.model.Recipe;
import project.main.response.recipe.RecipeService;

@RestController
@RequestMapping("/api/gangbung")
public class RecipeController {

	private final RecipeService recipeService;
	
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	@GetMapping("/recipes")
	public ResponseEntity<List<Recipe>> getRecipes() {
		List<Recipe> recipes = recipeService.getRecipes();
		return new ResponseEntity<>(recipes, HttpStatus.OK);
	}

	@GetMapping("/recipe/{id}")
	public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") Long Id) {
		Recipe recipe = recipeService.getRecipeById(Id);
		return new ResponseEntity<>(recipe, HttpStatus.OK);
	}

	@PostMapping("/recipe")
	public ResponseEntity<Recipe> addNewRecipe(@RequestBody Recipe recipe) {
		System.out.println(recipe);
		Recipe saveRecipe = recipeService.addRecipe(recipe);
		return new ResponseEntity<>(saveRecipe, HttpStatus.CREATED);
	}

	@PutMapping("/recipe/{id}")
	public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe newRecipe, @PathVariable Long id) {
		Recipe updateRecipe = recipeService.updateRecipe(id, newRecipe);
		return ResponseEntity.ok(updateRecipe);
	}

	@DeleteMapping("/recipe/{id}")
	public ResponseEntity<String> deleteRecipe(@PathVariable Long id) {
		recipeService.deleteById(id);
		return ResponseEntity.ok("Recipe deleted successfully");
	}
}