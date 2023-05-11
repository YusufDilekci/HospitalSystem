package HealthSystem.Hospital.business.concretes;

import org.springframework.stereotype.Service;

import HealthSystem.Hospital.business.requests.CreateMedicineDiseaseRequest;
import HealthSystem.Hospital.dataAccess.MedicineDiseaseRepository;
import HealthSystem.Hospital.entities.MedicineDisease;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicineDiseaseService {
	private final MedicineDiseaseRepository medicineDiseaseRepository;
	private final DiseaseService diseaseService;
	private final MedicineService medicineService;
	
	public void add(CreateMedicineDiseaseRequest request) {
		var disease = diseaseService.getDiseaseByName(request.getDiseaseName());
		var medicine = medicineService.getMedicineByName(request.getMedicineName());
		
		var medicineDisease = MedicineDisease.builder()	
				.disease(disease)
				.medicine(medicine)
				.build();
		
		medicineDiseaseRepository.save(medicineDisease);
	}
	
	
}
