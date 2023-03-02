package kodlama.io.kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.kodlama.io.devs.business.requests.CreateLanguageRequest;
import kodlama.io.kodlama.io.devs.business.requests.UpdateLanguageRequest;
import kodlama.io.kodlama.io.devs.business.responses.GetAllLanguageResponse;
import kodlama.io.kodlama.io.devs.business.responses.GetByIdLanguageResponse;
import kodlama.io.kodlama.io.devs.business.responses.GetByNameLanguageResponse;

public interface LanguageService {

	void add(CreateLanguageRequest languageRequest) throws Exception;

	void update(UpdateLanguageRequest languageRequest);

	void delete(int id);

	List<GetAllLanguageResponse> getAll();

	GetByIdLanguageResponse getById(int id);
	
	GetByNameLanguageResponse findByName(String name);
}
