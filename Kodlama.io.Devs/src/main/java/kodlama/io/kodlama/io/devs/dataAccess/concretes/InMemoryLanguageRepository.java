package kodlama.io.kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kodlama.io.kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.kodlama.io.devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

	List<Language> languages;

	@Autowired
	public InMemoryLanguageRepository() {
		languages = new ArrayList<>();
		languages.add(new Language(1, "React"));
		languages.add(new Language(21, "Java"));
		languages.add(new Language(33, "Assembly"));
	}

	@Override
	public void add(Language language) {
		languages.add(language);

	}

	@Override
	public void update(Language language, String name) {
		language.setName(name);

	}

	@Override
	public void delete(Language language) {
		languages.remove(language);

	}

	@Override
	public List<Language> getAll() {
		// TODO Auto-generated method stub
		return languages;
	}

	@Override
	public Language getById(int id) {
		for (Language language : languages) {
			if (language.getId() == id) {
				return language;
			}
		}
		return null;
	}

}
