package project.main.response.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.main.model.Location;

@Service
public class LocationService {
	@Autowired
	LocationRepository locationRepo;
	
	public List<Location> getLocations(){
		List<Location> locations = (List<Location>) locationRepo.findAll();
		return locations;
	}
	
	public Location getLocationById(Long id){
		return locationRepo.findById(id).orElseThrow(()->
		new LocationNotFoundException(id));
	}	 
	
	public void save(Location loc) {
		locationRepo.save(loc);
	}
	
	public Location addLocation(Location loc) {
		locationRepo.save(loc);
		return loc;
	}
	
	public void deleteById(Long id) {
		Location ingredient = locationRepo.findById(id).orElseThrow(()->
		new LocationNotFoundException(id));
		
		locationRepo.delete(ingredient);
	}
	
	public Location updateLocation(Long id,Location loc) {
		Location existingLocation = locationRepo.findById(id).get();
		//existingLocation.setIngredient(loc.getIngredient());
		existingLocation.setLocation(loc.getLocation());
		return locationRepo.save(existingLocation);
	}
}
