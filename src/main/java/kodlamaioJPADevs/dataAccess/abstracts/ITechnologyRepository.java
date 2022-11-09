package kodlamaioJPADevs.dataAccess.abstracts;

import kodlamaioJPADevs.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITechnologyRepository extends JpaRepository<Technology, Integer> {

}
