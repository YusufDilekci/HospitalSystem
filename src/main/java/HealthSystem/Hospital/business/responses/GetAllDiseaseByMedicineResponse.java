package HealthSystem.Hospital.business.responses;

import HealthSystem.Hospital.business.requests.CreatePatientRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDiseaseByMedicineResponse {
	private String diseaseName;
	private String diseaseBranch;
}
