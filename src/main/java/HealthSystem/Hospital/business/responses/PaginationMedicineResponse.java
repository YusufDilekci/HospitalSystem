package HealthSystem.Hospital.business.responses;

import java.util.List;

import HealthSystem.Hospital.entities.Medicine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaginationMedicineResponse {
	
	private List<Medicine> medicines;
	private int numberOfTotalPages;
}
