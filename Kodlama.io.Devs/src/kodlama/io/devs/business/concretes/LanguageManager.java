package kodlama.io.devs.business.concretes;

import java.util.List;

import kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.devs.entities.concretes.Language;

public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;

	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public void add(Language language) {

		if (language.getName().isEmpty()) {
			System.out.println("Programlama Dili İsmi Boş Bırakılamaz ! ");
		} else if (checkIfCourseName(languageRepository.getAll(), language) == false) {
			System.out.println("Hata ! Bu Dil Zaten Mevcut.");
		} else {
			System.out.println(language.getName()+ " " +"Başarıyla Eklendi !");
			languageRepository.add(language);
		}
	}

	@Override
	public void update(Language language , String name) {
		languageRepository.update(language,name);

	}

	@Override
	public void delete(Language language) {
		languageRepository.delete(language);

	}

	@Override
	public List<Language> getAll() {
		
		return languageRepository.getAll();
	}

	@Override
	public Language getbyId(int id) {
		// TODO Auto-generated method stub
		return languageRepository.getbyId(id);
	}

	public boolean checkIfCourseName(List<Language> languages, Language lang) {

		for (Language language : languages) {

			if (language.getName() == lang.getName()) {

				return false;
			}
		}
		return true;
	}

}
