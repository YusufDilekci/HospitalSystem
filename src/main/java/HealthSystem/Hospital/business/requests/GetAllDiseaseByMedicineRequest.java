package HealthSystem.Hospital.business.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDiseaseByMedicineRequest {
	
	private String medicineName;
}
