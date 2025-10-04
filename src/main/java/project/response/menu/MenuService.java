package project.response.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.model.Menu;

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
	
	public Menu addMenu(Menu m) {
		menuRepo.save(m);
		return m;
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
		existingMenu.setRecipeId(m.getRecipeId());
		return menuRepo.save(existingMenu);
	}
}
