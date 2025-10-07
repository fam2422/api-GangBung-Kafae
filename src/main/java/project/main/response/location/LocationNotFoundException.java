package project.main.response.location;

public class LocationNotFoundException extends RuntimeException{
	public LocationNotFoundException(Long id) {
		super("Could not find ingredient "+id);
	}
}
