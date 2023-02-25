package kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.Language;

public class InMemoryLanguageRepository implements LanguageRepository {
	
	List<Language> languages;
	
	
	

	public InMemoryLanguageRepository() {
		languages = new ArrayList<>();
		languages.add(new Language(1, "Javascript"));
		languages.add(new Language(1, "Java"));
		languages.add(new Language(1, "React"));
		languages.add(new Language(1, "Angular"));
		
	}

	@Override
	public void add(Language language) {
		languages.add(language);
		
	}

	@Override
	public void update(Language language , String name) {
		language.setName(name);
		System.out.println("Güncelleme Başarılı!");
		
		
	}

	@Override
	public void delete(Language language) {
		System.out.println("Silme Simülasyonu Başarılı");
		languages.remove(language);
	}

	@Override
	public List<Language> getAll() {
		// TODO Auto-generated method stub
		return languages;
	}

	@Override
	public Language getbyId(int id) {
		// TODO Auto-generated method stub
		return languages.get(id);
	}

}
