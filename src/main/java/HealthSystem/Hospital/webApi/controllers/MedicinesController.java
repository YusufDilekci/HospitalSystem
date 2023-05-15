package HealthSystem.Hospital.webApi.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HealthSystem.Hospital.business.concretes.MedicineService;
import HealthSystem.Hospital.business.requests.CreateMedicineRequest;
import HealthSystem.Hospital.business.requests.GetAllMedicineByDiseaseRequest;
import HealthSystem.Hospital.business.requests.GetAllMedicineByPaginationRequest;
import HealthSystem.Hospital.business.responses.PaginationMedicineResponse;
import HealthSystem.Hospital.entities.Medicine;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/medicine")
@RequiredArgsConstructor
public class MedicinesController {
	private final MedicineService medicineService;
	
	@PostMapping("/addMedicine")
	public void add(CreateMedicineRequest request) {
		
		medicineService.add(request);
	}
	
	@GetMapping("/getAllMedicine")
	public ResponseEntity<?> getall(){
		return ResponseEntity.ok(medicineService.getAll());
	}
	
	
	@GetMapping("/getAllMedicineByDisease")
	public ResponseEntity<?> getAllMedicineByDisease(GetAllMedicineByDiseaseRequest request){
		
		return ResponseEntity.ok(medicineService.getAllMedicineByDisease(request));
	}
	
	@GetMapping("/getAllMedicineByPagination")
	public ResponseEntity<PaginationMedicineResponse> getAllMedicineByPagination(GetAllMedicineByPaginationRequest request){
		
		return ResponseEntity.ok(medicineService.getAllMedicinePagination(request));
	}
}
