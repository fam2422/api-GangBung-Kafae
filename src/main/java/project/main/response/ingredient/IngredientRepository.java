package project.main.response.ingredient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.main.model.Ingredient;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient , Long>{

}
