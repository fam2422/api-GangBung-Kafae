package project.main.model;

import jakarta.persistence.*;

@Entity
@Table(name = "location")
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String location;
	
	/*
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ingredient_id", referencedColumnName = "id")
	private Ingredient ingredient;
	*/
	
	public Location() {}
	
	public Location(String location) {
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	/*
	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	
	
	@Override
	public String toString() {
		return "Location [id=" + id + ", location=" + location + ", ingredient=" + ingredient + "]";
	}
	*/
	@Override
	public String toString() {
		return "Location [id=" + id + ", location=" + location + "]";
	}
	
}
