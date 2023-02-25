package kodlama.io.devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.devs.entities.concretes.Language;

public interface LanguageRepository {
	
	void add(Language language);
	
	void update(Language language,String name);
	
	void delete(Language language);
	
	List<Language> getAll();
	
	Language getbyId(int id);

}
