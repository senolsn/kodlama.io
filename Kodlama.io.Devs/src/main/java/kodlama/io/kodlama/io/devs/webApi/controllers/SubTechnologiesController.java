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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.kodlama.io.devs.business.abstracts.SubTechnologyService;
import kodlama.io.kodlama.io.devs.business.requests.CreateSubTechnologyRequest;
import kodlama.io.kodlama.io.devs.business.requests.UpdateSubTechnologyRequest;
import kodlama.io.kodlama.io.devs.business.responses.GetAllSubTechnologyResponse;
import kodlama.io.kodlama.io.devs.business.responses.GetByIdSubTechnology;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/subtechnologies")
@AllArgsConstructor
public class SubTechnologiesController {

	private SubTechnologyService subTechnologyService;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody CreateSubTechnologyRequest createSubTechnologyRequest) {
		this.subTechnologyService.add(createSubTechnologyRequest);
	}

	@GetMapping("/getall")
	public List<GetAllSubTechnologyResponse> getAll() {
		return this.subTechnologyService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdSubTechnology getById(@PathVariable int id) {
		return this.subTechnologyService.getById(id);
	}
	
	@PutMapping
	public void update(@RequestBody UpdateSubTechnologyRequest updateSubTechnologyRequest) {
		this.subTechnologyService.update(updateSubTechnologyRequest);
	}
	
	@DeleteMapping
	public void delete(int id) {
		this.subTechnologyService.delete(id);
	}

}
