package HealthSystem.Hospital.business.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetDiseaseByPatientIdResponse {
	private String name;
	private String branch;
}
