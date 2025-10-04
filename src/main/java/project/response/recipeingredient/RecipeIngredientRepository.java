package project.response.recipeingredient;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import project.model.RecipeIngredient;

@Repository
public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient , Long>{

}
