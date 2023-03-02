package kodlama.io.kodlama.io.devs.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdSubTechnology {

	private int id;
	private String name;
	private String languageName;
}
