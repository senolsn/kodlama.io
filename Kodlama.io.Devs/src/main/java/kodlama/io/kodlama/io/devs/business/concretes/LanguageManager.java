package kodlama.io.kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.kodlama.io.devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public void add(Language language) {
		if (language.getName().isEmpty()) {
			System.out.println("İsim Boş Bırakılamaz !");
		} else if (checkLanguageName(languageRepository.getAll(), language) == false) {
			System.out.println("Eklemeye Çalıştığınız Dil Zaten Mevcut !");
		} else {
			languageRepository.add(language);
		}

	}

	@Override
	public void update(Language language, String name) {
		languageRepository.update(language, name);

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
	public Language getById(int id) {
		return languageRepository.getById(id);
	}

	public boolean checkLanguageName(List<Language> languages, Language language) {

		for (Language lang : languages) {

			if (lang.getName() == language.getName()) {
				return false;
			}
		}
		return true;
	}

}
