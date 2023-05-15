package HealthSystem.Hospital.business.concretes;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import HealthSystem.Hospital.business.requests.CreateMedicineRequest;
import HealthSystem.Hospital.business.requests.GetAllMedicineByDiseaseRequest;
import HealthSystem.Hospital.business.requests.GetAllMedicineByPaginationRequest;
import HealthSystem.Hospital.business.requests.GetAllMedicineByPatientTcRequest;
import HealthSystem.Hospital.business.responses.GetAllMedicineByDiseaseResponse;
import HealthSystem.Hospital.business.responses.GetAllMedicineByPatientTcResponse;
import HealthSystem.Hospital.business.responses.PaginationMedicineResponse;
import HealthSystem.Hospital.dataAccess.MedicineRepository;
import HealthSystem.Hospital.entities.Medicine;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicineService {
	private final MedicineRepository medicineRepository;

	
	public void add(CreateMedicineRequest request) {
		var medicine = Medicine.builder()
			.medicineName(request.getName())
			.serialNo(request.getSerialNo())
			.madeIn(request.getMadeIn())
			.build();
		
		medicineRepository.save(medicine);
	}
	
	public List<Medicine> getAll(){
		return medicineRepository.findAll();
	}
	
	public Medicine getMedicineByName(String name) {
		return medicineRepository.findByMedicineName(name);
	}
	
	public List<GetAllMedicineByDiseaseResponse> getAllMedicineByDisease(GetAllMedicineByDiseaseRequest request){
		 
		 List<Medicine> medicines = medicineRepository.findMedicineByDisease(request.getDiseaseName());
		 
		 List<GetAllMedicineByDiseaseResponse> medicinesResponse = new ArrayList<GetAllMedicineByDiseaseResponse>();
		 
		 for(Medicine m:medicines) {	 
			 var medicine = GetAllMedicineByDiseaseResponse.builder()
					 .medicineName(m.getMedicineName())
					 .serialNo(m.getSerialNo())
					 .build();
			 
			 medicinesResponse.add(medicine);			 
		 }
		 return medicinesResponse;
	}
	 
	public List<GetAllMedicineByPatientTcResponse> getAllMedicineByPatientTc(GetAllMedicineByPatientTcRequest request){
		List<Medicine> medicines = medicineRepository.findMedicineByPatientTc(request.getTcNo());
		
		List<GetAllMedicineByPatientTcResponse> medicinesResponse = new ArrayList<GetAllMedicineByPatientTcResponse>();
		 
		for(Medicine m:medicines) {	 
			var medicine = GetAllMedicineByPatientTcResponse.builder()
				 .medicineName(m.getMedicineName())
				 .serialNo(m.getSerialNo())
				 .madeIn(m.getMadeIn())
				 .build();
		 
			medicinesResponse.add(medicine);			 
		}
		return medicinesResponse;
	} 
	
	public PaginationMedicineResponse getAllMedicinePagination(GetAllMedicineByPaginationRequest request){
		Pageable paging = PageRequest.of(request.getPageNo() - 1, request.getPageSize(), Sort.by(request.getSortBy()).ascending()); 
		
		Page<Medicine> pageableMedicines = medicineRepository.findAll(paging);
		
		
		return PaginationMedicineResponse.builder()
				.medicines(pageableMedicines.getContent())
				.numberOfTotalPages(pageableMedicines.getTotalPages())
				.build();
	}
	 
}