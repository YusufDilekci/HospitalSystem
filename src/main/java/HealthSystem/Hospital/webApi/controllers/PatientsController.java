package HealthSystem.Hospital.webApi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HealthSystem.Hospital.business.concretes.PatientService;
import HealthSystem.Hospital.business.requests.CreatePatientRequest;
import HealthSystem.Hospital.business.requests.DeletePatientRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/patient")
@RequiredArgsConstructor
public class PatientsController {
	private final PatientService patientService;
	
	@PostMapping("/addPatient")
	public void add(CreatePatientRequest request) {
		patientService.add(request);
	}
	
	@GetMapping("/deletePatient")
	public void delete(DeletePatientRequest request) {		
		patientService.delete(request);
	}
	
	@GetMapping("/getAllPatient")
	public ResponseEntity<?> getall(){
		
		return ResponseEntity.ok(patientService.getAll());
	}
}
