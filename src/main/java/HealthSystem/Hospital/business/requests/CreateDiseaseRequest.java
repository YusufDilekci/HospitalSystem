package HealthSystem.Hospital.business.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateDiseaseRequest {
	
	private String name;
	private String branch;
	
}
