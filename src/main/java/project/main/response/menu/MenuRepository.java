package project.main.response.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.main.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>{

}
