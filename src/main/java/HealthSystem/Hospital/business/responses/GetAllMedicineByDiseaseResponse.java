package HealthSystem.Hospital.business.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllMedicineByDiseaseResponse {
	private String medicineName;
	private String serialNo;
}
