package HealthSystem.Hospital.business.concretes;

import org.springframework.stereotype.Service;

import HealthSystem.Hospital.business.requests.CreatePatientRequest;
import HealthSystem.Hospital.business.requests.DeletePatientRequest;
import HealthSystem.Hospital.dataAccess.PatientRepository;
import HealthSystem.Hospital.entities.Patient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {
	private final PatientRepository patientRepository;
	private DiseaseService diseaseService;
	
	public void add(CreatePatientRequest createPatientRequest) {
		var disease = diseaseService.getDiseaseByName(createPatientRequest.getDiseaseName());
		
		Patient patient = Patient.builder()
				.patientName(createPatientRequest.getName())
				.tcNo(createPatientRequest.getTcNo())
				.disease(disease)
				.build();
		
		patientRepository.save(patient);
	}
	
	public void delete(DeletePatientRequest deletePatientRequest) {
		
		patientRepository.deleteById(deletePatientRequest.getPatientId());
	}
}
