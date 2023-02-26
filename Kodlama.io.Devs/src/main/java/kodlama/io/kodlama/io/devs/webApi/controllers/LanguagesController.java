package kodlama.io.kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.kodlama.io.devs.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/getall")
	public List<Language> getAll() {

		return languageService.getAll();
	}

	@PostMapping("/add")
	public void add(Language language) {
		languageService.add(language);
	}

	@DeleteMapping("/delete")
	public void delete(Language language) {
		languageService.delete(language);
	}

	@GetMapping("/getbyid")
	public Language getbyid(int id) {
		return languageService.getById(id);
	}

	
}
