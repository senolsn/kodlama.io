package kodlama.io.kodlama.io.devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.kodlama.io.devs.business.requests.CreateLanguageRequest;
import kodlama.io.kodlama.io.devs.business.requests.DeleteLanguageRequest;
import kodlama.io.kodlama.io.devs.business.requests.UpdateLanguageRequest;
import kodlama.io.kodlama.io.devs.business.responses.GetAllLanguageResponse;
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
	public void add(CreateLanguageRequest languageRequest) {
		Language language = new Language();
		language.setName(languageRequest.getName());

		if (language.getName().isEmpty()) {
			System.out.println("İsim Boş Bırakılamaz !");
		} else if (checkLanguageName(languageRepository.findAll(), language) == false) {
			System.out.println("Eklemeye Çalıştığınız Dil Zaten Mevcut !");
		} else {
			languageRepository.save(language);
		}

	}

	@Override
	public void update(UpdateLanguageRequest languageRequest) {
		Language language = languageRepository.findById(languageRequest.getId());
		language.setId(languageRequest.getId());
		language.setName(languageRequest.getName());
		languageRepository.save(language);

	}

	@Override
	public void delete(DeleteLanguageRequest languageRequest) {
		Language language = languageRepository.findById(languageRequest.getId());
		language.setId(languageRequest.getId());
		languageRepository.delete(language);

	}

	@Override
	public List<GetAllLanguageResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguageResponse> languagesResponse = new ArrayList<>();

		for (Language language : languages) {
			GetAllLanguageResponse response = new GetAllLanguageResponse();
			response.setId(language.getId());
			response.setName(language.getName());
			languagesResponse.add(response);
		}

		return languagesResponse;
	}

	@Override
	public GetAllLanguageResponse findById(int id) {
		Language language = languageRepository.findById(id);
		GetAllLanguageResponse response = new GetAllLanguageResponse();

		response.setId(language.getId());
		response.setName(language.getName());
		return response;
	}

	@Override
	public GetAllLanguageResponse findByName(String name) {
		Language language = languageRepository.findByName(name);
		GetAllLanguageResponse response = new GetAllLanguageResponse();

		response.setId(language.getId());
		response.setName(language.getName());

		return response;
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
