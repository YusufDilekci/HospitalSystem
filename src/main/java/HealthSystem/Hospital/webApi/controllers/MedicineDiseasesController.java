package HealthSystem.Hospital.webApi.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HealthSystem.Hospital.business.concretes.MedicineDiseaseService;
import HealthSystem.Hospital.business.requests.CreateMedicineDiseaseRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/medicine_disease")
@RequiredArgsConstructor
public class MedicineDiseasesController {
	private final MedicineDiseaseService medicineDiseaseService;
	
	@PostMapping("/addMedicineDisease")
	public void add(CreateMedicineDiseaseRequest request) {
		medicineDiseaseService.add(request);
	}
}
