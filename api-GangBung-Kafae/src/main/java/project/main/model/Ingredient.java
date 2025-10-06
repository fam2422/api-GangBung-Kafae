package project.main.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "ingredient")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ingredient {
	
	public enum Unit{
		PIECE,GRAM,KILOGRAM,ML,LITER,TBSP,TSP,SHOT
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    
    private Long stockQty;
    
    private Unit unit = Unit.PIECE; // default value 
    public Ingredient() { }

    public Ingredient(Long id, String name, Long stockQty) {
        this.id = id;
        this.name = name;
        this.stockQty = stockQty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStockQty() {
        return stockQty;
    }

    public void setStockQty(Long stockQty) {
        this.stockQty = stockQty;
    }
    
    public Unit getUnit() {
    	return unit;
    }
    
    public void setUnit(Unit unit) {
    	this.unit = unit;
    }

    @Override
    public String toString() {
        return "Ingredient{id=" + id + ", name='" + name + "', stockQty=" + stockQty + "}";
    }
}
