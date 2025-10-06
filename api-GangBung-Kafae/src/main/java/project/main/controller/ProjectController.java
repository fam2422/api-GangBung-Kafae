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

import project.main.model.*;
import project.main.response.ingredient.IngredientService;
import project.main.response.menu.MenuService;
import project.main.response.order.OrderService;
import project.main.response.orderitem.OrderItemService;
import project.main.response.recipe.RecipeService;
import project.main.response.recipeingredient.RecipeIngredientService;

@RestController
@RequestMapping("/api/gangbung")
public class ProjectController {

	private final OrderService orderService;
	private final OrderItemService orderItemService;
	private final MenuService menuService;
	private final RecipeService recipeService;
	private final RecipeIngredientService recipeIngredientService;
	private final IngredientService ingredientService;
	
	public ProjectController(OrderService orderService,OrderItemService orderItemService,MenuService menuService
			,RecipeService recipeService,RecipeIngredientService recipeIngredientService,IngredientService ingredientService) {
		this.orderService = orderService;
		this.orderItemService = orderItemService;
		this.menuService = menuService;
		this.recipeService = recipeService;
		this.recipeIngredientService = recipeIngredientService;
		this.ingredientService = ingredientService;
	}
	
	//-------------------------------------- Order --------------------------------------
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getOrder(){
		List<Order> orders = orderService.getOrders();
		return new ResponseEntity<>(orders,HttpStatus.OK);
	}
	
	@GetMapping("/order/{id}")  //http://localhost:8080/api/gangbung/order/{id}
	public ResponseEntity<Order> getOrderById(@PathVariable("id")Long Id){
		Order orders = orderService.getOrderById(Id);
		return new ResponseEntity<>(orders,HttpStatus.OK);
	}
	
	@PostMapping("/order") // http://localhost:8080/api/gangbung/order/?order=
	public ResponseEntity<Order> addNewOrder(@RequestBody Order order) {
		System.out.println(order);
		Order saveOrder = orderService.addOrder(order);
		return new ResponseEntity<>(saveOrder, HttpStatus.CREATED);
	}
	
	@PutMapping("/order/{id}") //update http://localhost:8080/api/gangbung/order/1?order=
	ResponseEntity<Order> updateOrder(@RequestBody Order newOrder, @PathVariable Long id) {
		Order updateOrder = orderService.updateOrder(id, newOrder);
		return ResponseEntity.ok(updateOrder);
	}

	@DeleteMapping("/order/{id}") // http://localhost:8080/api/gangbung/order/{id}
	public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
		orderService.deleteById(id);
		return ResponseEntity.ok("Order deleted successfully");
	}
	
	//-------------------------------------- OrderItem --------------------------------------
	@GetMapping("/orderitems")
	public ResponseEntity<List<OrderItem>> getOrderItem(){
		List<OrderItem> orderItems = orderItemService.getOrderItems();
		return new ResponseEntity<>(orderItems,HttpStatus.OK);
	}

	@GetMapping("/order-item/{id}")  //http://localhost:8080/api/gangbung/order-item/{id}
	public ResponseEntity<OrderItem> getOrderItemById(@PathVariable("id")Long Id){
		OrderItem orderItems = orderItemService.getOrderItemById(Id);
		return new ResponseEntity<>(orderItems,HttpStatus.OK);
	}
	
	@PostMapping("/order-item") // http://localhost:8080/api/gangbung/order-item/?orderitem=
	public ResponseEntity<OrderItem> addNewOrderItem(@RequestBody OrderItem orderItem) {
		System.out.println(orderItem);
		OrderItem saveOrderItem = orderItemService.addOrderItem(orderItem);
		return new ResponseEntity<>(saveOrderItem,HttpStatus.CREATED);
	}
	
	@PutMapping("/order-item/{id}") //update http://localhost:8080/api/gangbung/order-item/1?orderitem=
	ResponseEntity<OrderItem> updateOrderItem(@RequestBody OrderItem newOrderItem, @PathVariable Long id) {
		OrderItem updateOrderItem = orderItemService.updateOrderItem(id, newOrderItem);
		return ResponseEntity.ok(updateOrderItem);
	}

	@DeleteMapping("/order-item/{id}") // http://localhost:8080/api/gangbung/order-item/{id}
	public ResponseEntity<String> deleteOrderItem(@PathVariable Long id) {
		orderItemService.deleteById(id);
		return ResponseEntity.ok("OrderItem deleted successfully");
	}
	
	//-------------------------------------- Menu --------------------------------------
	@GetMapping("/menu")
	public ResponseEntity<List<Menu>> getMenu(){
		List<Menu> menu = menuService.getMenus();
		return new ResponseEntity<>(menu,HttpStatus.OK);
	}
	
	@GetMapping("/menu/{id}") //http://localhost:8080/api/gangbung/menu/{id}
	public ResponseEntity<Menu> getMenuById(@PathVariable("id")Long Id){
		Menu menu = menuService.getMenuById(Id);
		return new ResponseEntity<>(menu,HttpStatus.OK);
	}
	
	@PostMapping("/menu") // http://localhost:8080/api/gangbung/menu/?menu=
	public ResponseEntity<Menu> addNewMenu(@RequestBody Menu menu) {
		System.out.println(menu);
		Menu saveMenu = menuService.addMenu(menu);
		return new ResponseEntity<>(saveMenu,HttpStatus.CREATED);
	}
	
	@PutMapping("/menu/{id}") //update http://localhost:8080/api/gangbung/menu/1?menu=
	ResponseEntity<Menu> updateMenu(@RequestBody Menu newMenu, @PathVariable Long id) {
		Menu updateMenu = menuService.updateMenu(id, newMenu);
		return ResponseEntity.ok(updateMenu);
	}

	@DeleteMapping("/menu/{id}") // http://localhost:8080/api/gangbung/menu/{id}
	public ResponseEntity<String> deleteMenu(@PathVariable Long id) {
		menuService.deleteById(id);
		return ResponseEntity.ok("Menu deleted successfully");
	}
	
	//-------------------------------------- Recipe --------------------------------------
	@GetMapping("/recipes")
	public ResponseEntity<List<Recipe>> getRecipes() {
	    List<Recipe> recipes = recipeService.getRecipes();
	    return new ResponseEntity<>(recipes, HttpStatus.OK);
	}

	@GetMapping("/recipe/{id}") // http://localhost:8080/api/gangbung/recipe/{id}
	public ResponseEntity<Recipe> getRecipeById(@PathVariable("id") Long Id) {
	    Recipe recipe = recipeService.getRecipeById(Id);
	    return new ResponseEntity<>(recipe, HttpStatus.OK);
	}

	@PostMapping("/recipe") // http://localhost:8080/api/gangbung/recipe/?recipe=
	public ResponseEntity<Recipe> addNewRecipe(@RequestBody Recipe recipe) {
	    System.out.println(recipe);
	    Recipe saveRecipe = recipeService.addRecipe(recipe);
	    return new ResponseEntity<>(saveRecipe, HttpStatus.CREATED);
	}

	@PutMapping("/recipe/{id}") // update http://localhost:8080/api/gangbung/recipe/1?recipe=
	public ResponseEntity<Recipe> updateRecipe(@RequestBody Recipe newRecipe, @PathVariable Long id) {
	    Recipe updateRecipe = recipeService.updateRecipe(id, newRecipe);
	    return ResponseEntity.ok(updateRecipe);
	}

	@DeleteMapping("/recipe/{id}") // http://localhost:8080/api/gangbung/recipe/{id}
	public ResponseEntity<String> deleteRecipe(@PathVariable Long id) {
	    recipeService.deleteById(id);
	    return ResponseEntity.ok("Recipe deleted successfully");
	}

	//-------------------------------------- RecipeIngredient --------------------------------------
	@GetMapping("/recipe-ingredients")
	public ResponseEntity<List<RecipeIngredient>> getRecipeIngredients() {
	    List<RecipeIngredient> recipeIngredients = recipeIngredientService.getRecipeIngredients();
	    return new ResponseEntity<>(recipeIngredients, HttpStatus.OK);
	}

	@GetMapping("/recipe-ingredient/{id}") // http://localhost:8080/api/gangbung/recipe-ingredient/{id}
	public ResponseEntity<RecipeIngredient> getRecipeIngredientById(@PathVariable("id") Long Id) {
	    RecipeIngredient recipeIngredient = recipeIngredientService.getRecipeIngredientById(Id);
	    return new ResponseEntity<>(recipeIngredient, HttpStatus.OK);
	}

	@PostMapping("/recipe-ingredient") // http://localhost:8080/api/gangbung/recipe-ingredient/?recipeIngredient=
	public ResponseEntity<RecipeIngredient> addNewRecipeIngredient(@RequestBody RecipeIngredient recipeIngredient) {
	    System.out.println(recipeIngredient);
	    RecipeIngredient saveRecipeIngredient = recipeIngredientService.addRecipeIngredient(recipeIngredient);
	    return new ResponseEntity<>(saveRecipeIngredient, HttpStatus.CREATED);
	}

	@PutMapping("/recipe-ingredient/{id}") // update http://localhost:8080/api/gangbung/recipe-ingredient/1?recipeIngredient=
	public ResponseEntity<RecipeIngredient> updateRecipeIngredient(@RequestBody RecipeIngredient newRecipeIngredient, @PathVariable Long id) {
	    RecipeIngredient updateRecipeIngredient = recipeIngredientService.updateRecipeIngredient(id, newRecipeIngredient);
	    return ResponseEntity.ok(updateRecipeIngredient);
	}

	@DeleteMapping("/recipe-ingredient/{id}") // http://localhost:8080/api/gangbung/recipe-ingredient/{id}
	public ResponseEntity<String> deleteRecipeIngredient(@PathVariable Long id) {
	    recipeIngredientService.deleteById(id);
	    return ResponseEntity.ok("RecipeIngredient deleted successfully");
	}

	//-------------------------------------- Ingredient --------------------------------------
	@GetMapping("/ingredients")
	public ResponseEntity<List<Ingredient>> getIngredients() {
	    List<Ingredient> ingredients = ingredientService.getIngredients();
	    return new ResponseEntity<>(ingredients, HttpStatus.OK);
	}

	@GetMapping("/ingredient/{id}") // http://localhost:8080/api/gangbung/ingredient/{id}
	public ResponseEntity<Ingredient> getIngredientById(@PathVariable("id") Long Id) {
	    Ingredient ingredient = ingredientService.getIngredientById(Id);
	    return new ResponseEntity<>(ingredient, HttpStatus.OK);
	}

	@PostMapping("/ingredient") // http://localhost:8080/api/gangbung/ingredient/?ingredient=
	public ResponseEntity<Ingredient> addNewIngredient(@RequestBody Ingredient ingredient) {
	    System.out.println(ingredient);
	    Ingredient saveIngredient = ingredientService.addIngredient(ingredient);
	    return new ResponseEntity<>(saveIngredient, HttpStatus.CREATED);
	}

	@PutMapping("/ingredient/{id}") // update http://localhost:8080/api/gangbung/ingredient/1?ingredient=
	public ResponseEntity<Ingredient> updateIngredient(@RequestBody Ingredient newIngredient, @PathVariable Long id) {
	    Ingredient updateIngredient = ingredientService.updateIngredient(id, newIngredient);
	    return ResponseEntity.ok(updateIngredient);
	}

	@DeleteMapping("/ingredient/{id}") // http://localhost:8080/api/gangbung/ingredient/{id}
	public ResponseEntity<String> deleteIngredient(@PathVariable Long id) {
	    ingredientService.deleteById(id);
	    return ResponseEntity.ok("Ingredient deleted successfully");
	}
	
}
