package project.main.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.*;

import jakarta.persistence.*;

@Entity
@Table(name = "recipe")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sweetLevel;
    
    @ManyToOne
    @JoinColumn(name = "menu_id")
    @JsonBackReference("menu-recipes") // <-- ต้องตรงกับ Menu
    private Menu menu;
    
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("recipe-ingredients")
    private List<RecipeIngredient> ingredients = new ArrayList<>();

    public Recipe() { }

    public Recipe(Long id, String sweetLevel,List<RecipeIngredient> ingredients) {
        this.id = id;
        this.sweetLevel = sweetLevel;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSweetLevel() {
        return this.sweetLevel;
    }

    public void setSweetLevel(String sweetLevel) {
        this.sweetLevel = sweetLevel;
    }
    
    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
    public List<RecipeIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredient> ingredients) {
        this.ingredients = ingredients;
        for (RecipeIngredient ri : ingredients) {
            ri.setRecipe(this);
        }
    }
    
    
    @Override
    public String toString() {
        return "Recipe{id=" + id + ", SweetLevel=" + sweetLevel + ", ingredients=" + ingredients + "}";
    }
}
