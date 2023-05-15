package HealthSystem.Hospital.business.requests;

import HealthSystem.Hospital.business.responses.GetAllMedicineByPatientTcResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetDiseaseByPatientIdRequest {
	
	private int patientId;
}
