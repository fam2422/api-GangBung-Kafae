package project.main.response.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.main.model.Menu;
import project.main.model.Recipe;
import project.main.response.recipe.RecipeRepository;

@Service
public class MenuService {
	@Autowired
	MenuRepository menuRepo;
	public List<Menu> getMenus(){
		List<Menu> menus = (List<Menu>) menuRepo.findAll();
		return menus;
	}
	
	public Menu getMenuById(Long id){
		return menuRepo.findById(id).orElseThrow(()->
		new MenuNotFoundException(id));
	}	 
	
	public void save(Menu m) {
		menuRepo.save(m);
	}
	
	@Autowired
	RecipeRepository recipeRepo; // ต้องสร้าง repo ของ Recipe ด้วย

	public Menu addMenu(Menu m) {
	    if (m.getRecipe() != null && m.getRecipe().getId() != null) {
	        Recipe recipeFromDb = recipeRepo.findById(m.getRecipe().getId())
	            .orElseThrow(() -> new RuntimeException("Recipe not found"));
	        m.setRecipe(recipeFromDb);
	    }
	    return menuRepo.save(m);
	}

	
	public void deleteById(Long id) {
		Menu menu = menuRepo.findById(id).orElseThrow(()->
		new MenuNotFoundException(id));
		
		menuRepo.delete(menu);
	}
	
	public Menu updateMenu(Long id,Menu m) {
		Menu existingMenu = menuRepo.findById(id).get();
		existingMenu.setName(m.getName());
		existingMenu.setPrice(m.getPrice());
		existingMenu.setRecipe(m.getRecipe());
		return menuRepo.save(existingMenu);
	}
}
