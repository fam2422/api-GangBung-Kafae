package project.main.response.location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.main.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location , Long>{

}
