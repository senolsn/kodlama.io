package kodlama.io.kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.kodlama.io.devs.business.abstracts.SubTechnologyService;
import kodlama.io.kodlama.io.devs.business.core.utilities.mappers.ModelMapperService;
import kodlama.io.kodlama.io.devs.business.requests.CreateSubTechnologyRequest;
import kodlama.io.kodlama.io.devs.business.requests.UpdateSubTechnologyRequest;
import kodlama.io.kodlama.io.devs.business.responses.GetAllSubTechnologyResponse;
import kodlama.io.kodlama.io.devs.business.responses.GetByIdSubTechnology;
import kodlama.io.kodlama.io.devs.dataAccess.abstracts.SubTechnologyRepository;
import kodlama.io.kodlama.io.devs.entities.concretes.SubTechnology;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubTechnologyManager implements SubTechnologyService {

	private SubTechnologyRepository subTechnologyRepository;
	private ModelMapperService modelMapperService;

	@Override
	public void add(CreateSubTechnologyRequest createSubTechnologyRequest) {
		SubTechnology subTechnology = this.modelMapperService.forRequest().map(createSubTechnologyRequest,
				SubTechnology.class);
		subTechnologyRepository.save(subTechnology);

	}

	@Override
	public void update(UpdateSubTechnologyRequest updateSubTechnologyRequest) {
		SubTechnology subTechnology = this.modelMapperService.forRequest().map(updateSubTechnologyRequest,
				SubTechnology.class);
		this.subTechnologyRepository.save(subTechnology);

	}

	@Override
	public void delete(int id) {

		this.subTechnologyRepository.deleteById(id);

	}

	@Override
	public List<GetAllSubTechnologyResponse> getAll() {
		List<SubTechnology> subTechnologies = this.subTechnologyRepository.findAll();
		List<GetAllSubTechnologyResponse> response = subTechnologies.stream()
				.map(subtechnology -> this.modelMapperService.forResponse().map(subtechnology,
						GetAllSubTechnologyResponse.class))
				.toList();

		return response;
	}

	@Override
	public GetByIdSubTechnology getById(int id) {
		SubTechnology subTechnology = this.subTechnologyRepository.findById(id).orElseThrow();
		GetByIdSubTechnology response = this.modelMapperService.forResponse().map(subTechnology,
				GetByIdSubTechnology.class);
		return response;
	}

}
