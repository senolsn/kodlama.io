package kodlama.io.kodlama.io.devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.kodlama.io.devs.entities.concretes.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {
	
	
	Language findByName(String name);

}
