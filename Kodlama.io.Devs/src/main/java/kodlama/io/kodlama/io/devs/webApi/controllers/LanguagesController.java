package kodlama.io.kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.kodlama.io.devs.business.abstracts.LanguageService;
import kodlama.io.kodlama.io.devs.business.requests.CreateLanguageRequest;
import kodlama.io.kodlama.io.devs.business.requests.UpdateLanguageRequest;
import kodlama.io.kodlama.io.devs.business.responses.GetAllLanguageResponse;
import kodlama.io.kodlama.io.devs.business.responses.GetByIdLanguageResponse;
import kodlama.io.kodlama.io.devs.business.responses.GetByNameLanguageResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/languages")
@AllArgsConstructor
public class LanguagesController {

	private LanguageService languageService;

	@GetMapping("/getall")
	public List<GetAllLanguageResponse> getAll() {

		return languageService.getAll();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody CreateLanguageRequest languageRequest) throws Exception {
		languageService.add(languageRequest);
	}

	@GetMapping("/{id}")
	public GetByIdLanguageResponse getById(@PathVariable() int id) {
		return languageService.getById(id);
	}

	@GetMapping()
	public GetByNameLanguageResponse findByName(@RequestParam(value = "name") String name) {
		return languageService.findByName(name);
	}

	@PutMapping()
	public void update(@RequestBody UpdateLanguageRequest languageRequest) {
		languageService.update(languageRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		languageService.delete(id);
	}

}
