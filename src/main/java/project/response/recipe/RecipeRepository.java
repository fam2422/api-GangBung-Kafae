package project.response.recipe;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import project.model.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}
