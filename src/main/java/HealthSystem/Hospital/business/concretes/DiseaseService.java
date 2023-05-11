package HealthSystem.Hospital.business.concretes;

import org.springframework.stereotype.Service;

import HealthSystem.Hospital.business.requests.CreateDiseaseRequest;
import HealthSystem.Hospital.dataAccess.DiseaseRepository;
import HealthSystem.Hospital.entities.Disease;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiseaseService {
	private final DiseaseRepository diseaseRepository;
	
	public void add(CreateDiseaseRequest createDiseaseRequest) {
		var disease = Disease.builder()
				.diseaseName(createDiseaseRequest.getName())
				.diseaseBranch(createDiseaseRequest.getBranch())
				.build();
		
		diseaseRepository.save(disease);
	}
	
	public Disease getDiseaseByName(String name) {
		
		return diseaseRepository.findByName(name);
	}
}
