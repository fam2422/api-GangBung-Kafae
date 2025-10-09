package project.main.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.main.model.Location;
import project.main.response.location.LocationService;

@RestController
@RequestMapping("/api/gangbung")
public class LocationController {

	private final LocationService locationService;
	
	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}
	
	@GetMapping("/locations")
	public ResponseEntity<List<Location>> getIngredients() {
		List<Location> ingredients = locationService.getLocations();
		return new ResponseEntity<>(ingredients, HttpStatus.OK);
	}

	@GetMapping("/location/{id}")
	public ResponseEntity<Location> getIngredientById(@PathVariable("id") Long Id) {
		Location ingredient = locationService.getLocationById(Id);
		return new ResponseEntity<>(ingredient, HttpStatus.OK);
	}

	@PostMapping("/location")
	public ResponseEntity<Location> addNewLocation(@RequestBody Location location) {
		System.out.println(location);
		Location saveLocation = locationService.addLocation(location);
		return new ResponseEntity<>(saveLocation, HttpStatus.CREATED);
	}

	@PutMapping("/location/{id}")
	public ResponseEntity<Location> updateIngredient(@RequestBody Location newLocation, @PathVariable Long id) {
		Location updateLocation = locationService.updateLocation(id, newLocation);
		return ResponseEntity.ok(updateLocation);
	}

	@DeleteMapping("/location/{id}")
	public ResponseEntity<String> deleteIngredient(@PathVariable Long id) {
		locationService.deleteById(id);
		return ResponseEntity.ok("Location deleted successfully");
	}
}
