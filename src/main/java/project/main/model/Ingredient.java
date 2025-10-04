package project.main.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Long stockQty;

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

    @Override
    public String toString() {
        return "Ingredient{id=" + id + ", name='" + name + "', stockQty=" + stockQty + "}";
    }
}
