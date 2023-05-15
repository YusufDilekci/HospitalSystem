package HealthSystem.Hospital.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import HealthSystem.Hospital.business.requests.CreateDiseaseRequest;
import HealthSystem.Hospital.business.requests.GetAllDiseaseByMedicineRequest;
import HealthSystem.Hospital.business.requests.GetDiseaseByPatientIdRequest;
import HealthSystem.Hospital.business.responses.GetAllDiseaseByMedicineResponse;
import HealthSystem.Hospital.business.responses.GetAllDiseaseResponse;
import HealthSystem.Hospital.business.responses.GetDiseaseByPatientIdResponse;
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
	
	public List<GetAllDiseaseResponse> getAllDisease(){
		List<Disease> diseases = diseaseRepository.findAll();
		
		var diseasesResponse = new ArrayList<GetAllDiseaseResponse>();
		for(var d:diseases) {
			var disease = GetAllDiseaseResponse.builder()
					.name(d.getDiseaseName())
					.branch(d.getDiseaseBranch())
					.build();
			
			diseasesResponse.add(disease);
		}
		
		return diseasesResponse;
		
	}
	public Disease getDiseaseByName(String name) {
		
		return diseaseRepository.findByDiseaseName(name);
	}
	
	//Verilen ilaçın hangi hastalıklara iyi geleceğini göster
	
	public List<GetAllDiseaseByMedicineResponse> getAllDiseaseByMedicine(GetAllDiseaseByMedicineRequest request){
		List<Disease> diseases = diseaseRepository.findDiseaseByMedicine(request.getMedicineName());
		
		var diseasesResponse = new ArrayList<GetAllDiseaseByMedicineResponse>();
		
		for(var d:diseases) {
			var disease = GetAllDiseaseByMedicineResponse.builder()
					.diseaseName(d.getDiseaseName())
					.diseaseBranch(d.getDiseaseBranch())
					.build();
			
			diseasesResponse.add(disease);
		}
		
		return diseasesResponse;
	}
	//Hastanın sahip olduğu hastalık
	
	public GetDiseaseByPatientIdResponse getDiseaseByPatientId(GetDiseaseByPatientIdRequest request) {
		Disease disease = diseaseRepository.findDiseaseByPatientId(request.getPatientId());
		
		return GetDiseaseByPatientIdResponse.builder()
				.name(disease.getDiseaseName())
				.branch(disease.getDiseaseBranch())
				.build();
	}
}
