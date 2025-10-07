// RecipeRepository.java
package project.main.response.recipe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import project.main.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long>{
	
	// ถ้า Menu มี field ชื่อ recipe (One-to-One)
	@Query("SELECT m.recipe FROM Menu m WHERE m.id = :menuId")
	List<Recipe> findByMenuId(@Param("menuId") Long menuId);
	
}