package project.response.ingredient;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import project.model.Ingredient;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient , Long>{

}
