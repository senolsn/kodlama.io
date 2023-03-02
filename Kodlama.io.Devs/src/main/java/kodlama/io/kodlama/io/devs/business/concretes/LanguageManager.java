package kodlama.io.kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.kodlama.io.devs.business.core.utilities.mappers.ModelMapperService;
import kodlama.io.kodlama.io.devs.business.requests.CreateLanguageRequest;
import kodlama.io.kodlama.io.devs.business.requests.UpdateLanguageRequest;
import kodlama.io.kodlama.io.devs.business.responses.GetAllLanguageResponse;
import kodlama.io.kodlama.io.devs.business.responses.GetByIdLanguageResponse;
import kodlama.io.kodlama.io.devs.business.responses.GetByNameLanguageResponse;
import kodlama.io.kodlama.io.devs.dataAccess.abstracts.LanguageRepository;
import kodlama.io.kodlama.io.devs.entities.concretes.Language;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;
	private ModelMapperService modelMapperService;

	@Override
	public void add(CreateLanguageRequest languageRequest) throws Exception {
		if (checkIfProgrammingLanguageExists(languageRequest) == false) {

			throw new Exception("Hata ! Aynı isim zaten mevcut");
		} else if (languageRequest.getName().isEmpty()) {
			throw new Exception("Hata ! İsim Boş Bırakılamaz");
		} else {
			Language request = this.modelMapperService.forRequest().map(languageRequest, Language.class);
			languageRepository.save(request);
		}

	}

	@Override
	public void update(UpdateLanguageRequest languageRequest) {

		Language request = this.modelMapperService.forRequest().map(languageRequest, Language.class);
		this.languageRepository.save(request);

	}

	@Override
	public void delete(int id) {
		languageRepository.findById(id).orElseThrow();
		this.languageRepository.deleteById(id);

	}

	@Override
	public List<GetAllLanguageResponse> getAll() {

		List<Language> brands = this.languageRepository.findAll();
		List<GetAllLanguageResponse> response = brands.stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand, GetAllLanguageResponse.class)).toList();
		return response;

	}

	@Override
	public GetByIdLanguageResponse getById(int id) {
		Language language = languageRepository.findById(id).orElseThrow();
		GetByIdLanguageResponse response = this.modelMapperService.forResponse().map(language,
				GetByIdLanguageResponse.class);

		return response;
	}

	@Override
	public GetByNameLanguageResponse findByName(String name) {

		GetByNameLanguageResponse response = this.modelMapperService.forResponse()
				.map(languageRepository.findByName(name), GetByNameLanguageResponse.class);

		return response;
	}

	public boolean checkIfProgrammingLanguageExists(CreateLanguageRequest languageRequest) {

		for (Language lang : this.languageRepository.findAll()) {

			if (lang.getName().equals(languageRequest.getName()) || languageRequest.getName() == null) {
				return false;
			}
		}
		return true;
	}

}
