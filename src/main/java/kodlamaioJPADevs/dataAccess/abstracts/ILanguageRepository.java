package kodlamaioJPADevs.dataAccess.abstracts;

import kodlamaioJPADevs.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILanguageRepository extends JpaRepository<Language, Integer> {
    boolean existsLanguageByName(String name);
}
