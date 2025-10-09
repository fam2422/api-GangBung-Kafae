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

import project.main.model.Menu;
import project.main.model.Recipe;
import project.main.response.menu.MenuService;

@RestController
@RequestMapping("/api/gangbung")
public class MenuController {

	private final MenuService menuService;
	
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}
	
	@GetMapping("/menu")
	public ResponseEntity<List<Menu>> getMenu(){
		List<Menu> menu = menuService.getMenus();
		return new ResponseEntity<>(menu, HttpStatus.OK);
	}
	
	@GetMapping("/menu/{id}")
	public ResponseEntity<Menu> getMenuById(@PathVariable("id") Long Id){
		Menu menu = menuService.getMenuById(Id);
		return new ResponseEntity<>(menu, HttpStatus.OK);
	}
	
	@PostMapping("/menu")
	public ResponseEntity<Menu> addNewMenu(@RequestBody Menu menu) {
		System.out.println(menu);
		Menu saveMenu = menuService.addMenu(menu);
		return new ResponseEntity<>(saveMenu, HttpStatus.CREATED);
	}
	
	@PutMapping("/menu/{id}")
	public ResponseEntity<Menu> updateMenu(@RequestBody Menu newMenu, @PathVariable Long id) {
		Menu updateMenu = menuService.updateMenu(id, newMenu);
		return ResponseEntity.ok(updateMenu);
	}

	@DeleteMapping("/menu/{id}")
	public ResponseEntity<String> deleteMenu(@PathVariable Long id) {
		menuService.deleteById(id);
		return ResponseEntity.ok("Menu deleted successfully");
	}
	
	@GetMapping("/menu/{id}/recipes")
	public ResponseEntity<List<Recipe>> getRecipesByMenu(@PathVariable Long id) {
		Menu menu = menuService.getMenuById(id);
		List<Recipe> recipes = menu.getRecipe();
		return new ResponseEntity<>(recipes, HttpStatus.OK);
	}
}