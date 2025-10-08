package project.main.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "ingredient")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ingredient {
	
	private String unit = "ml"; // default value
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private Long stockQty;
    
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Location location;
    
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
    
    public String getUnit() {
    	return unit;
    }
    
    public void setUnit(String unit) {
    	this.unit = unit;
    }
    
    public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
    public String toString() {
        return "Ingredient{id=" + id + ", name='" + name + "', stockQty=" + stockQty + "', location=" + location + "}";
    }
}
