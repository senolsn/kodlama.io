package kodlama.io.kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.kodlama.io.devs.business.requests.CreateLanguageRequest;
import kodlama.io.kodlama.io.devs.business.requests.DeleteLanguageRequest;
import kodlama.io.kodlama.io.devs.business.requests.UpdateLanguageRequest;
import kodlama.io.kodlama.io.devs.business.responses.GetAllLanguageResponse;

public interface LanguageService {

	void add(CreateLanguageRequest languageRequest);

	void update(UpdateLanguageRequest languageRequest);

	void delete(DeleteLanguageRequest languageRequest);

	List<GetAllLanguageResponse> getAll();

	GetAllLanguageResponse findById(int id);
	
	GetAllLanguageResponse findByName(String name);
}
