package kodlama.io.kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.kodlama.io.devs.entities.concretes.Language;

public interface LanguageService {

	void add(Language language);

	void update(Language language, String name);

	void delete(Language language);

	List<Language> getAll();

	Language getById(int id);
}
