package kodlama.io.kodlama.io.devs.business.abstracts;

import java.util.List;

import kodlama.io.kodlama.io.devs.business.requests.CreateSubTechnologyRequest;
import kodlama.io.kodlama.io.devs.business.requests.UpdateSubTechnologyRequest;
import kodlama.io.kodlama.io.devs.business.responses.GetAllSubTechnologyResponse;
import kodlama.io.kodlama.io.devs.business.responses.GetByIdSubTechnology;



public interface SubTechnologyService {
	
	void add(CreateSubTechnologyRequest createSubTechnologyRequest);

	void update(UpdateSubTechnologyRequest subTechnologyRequest);

	void delete(int id);

	List<GetAllSubTechnologyResponse> getAll();
	
	GetByIdSubTechnology getById(int id);

}
