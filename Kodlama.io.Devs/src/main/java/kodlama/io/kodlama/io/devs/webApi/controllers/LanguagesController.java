package kodlama.io.kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.kodlama.io.devs.business.requests.CreateLanguageRequest;
import kodlama.io.kodlama.io.devs.business.requests.DeleteLanguageRequest;
import kodlama.io.kodlama.io.devs.business.requests.UpdateLanguageRequest;
import kodlama.io.kodlama.io.devs.business.responses.GetAllLanguageResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/getall")
	public List<GetAllLanguageResponse> getAll() {

		return languageService.getAll();
	}

	@PostMapping("/add")
	public void add(CreateLanguageRequest languageRequest) {
		languageService.add(languageRequest);
	}

	@DeleteMapping("/delete")
	public void delete(DeleteLanguageRequest languageRequest) {
		languageService.delete(languageRequest);
	}

	@GetMapping("/findById")
	public GetAllLanguageResponse findById(int id) {
		return languageService.findById(id);
	}
	
	@GetMapping("/findByName")
	public GetAllLanguageResponse findByName(String name) {
		return languageService.findByName(name);
	}

	@PutMapping("/update")
	public void update(UpdateLanguageRequest languageRequest) {
		languageService.update(languageRequest);
	}
	
}
