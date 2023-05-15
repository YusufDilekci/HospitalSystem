package HealthSystem.Hospital.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import HealthSystem.Hospital.business.requests.CreatePatientRequest;
import HealthSystem.Hospital.business.requests.DeletePatientRequest;
import HealthSystem.Hospital.business.requests.UpdatePatientRequest;
import HealthSystem.Hospital.dataAccess.PatientRepository;
import HealthSystem.Hospital.entities.Patient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {
	private final PatientRepository patientRepository;
	private final DiseaseService diseaseService;
	
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
	
	public void update(UpdatePatientRequest updatePatientRequest) {
		Patient patient = patientRepository.findById(updatePatientRequest.getId()).get();
		var disease = diseaseService.getDiseaseByName(updatePatientRequest.getDiseaseName());
		
		patient.setPatientName(updatePatientRequest.getPatientName());
		patient.setTcNo(updatePatientRequest.getTcNo());
		patient.setDisease(disease);
	
	}
	
	public List<Patient> getAll(){
		
		return patientRepository.findAll();
	}
}
