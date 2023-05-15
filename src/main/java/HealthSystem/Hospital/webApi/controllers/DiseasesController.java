package HealthSystem.Hospital.webApi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import HealthSystem.Hospital.business.concretes.DiseaseService;
import HealthSystem.Hospital.business.requests.CreateDiseaseRequest;
import HealthSystem.Hospital.business.responses.GetAllDiseaseResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/disease")
@RequiredArgsConstructor
public class DiseasesController {
	private final DiseaseService diseaseService;
	
	@PostMapping("/addDisease")
	public void add(CreateDiseaseRequest request) {
		diseaseService.add(request);
	}
	
	@GetMapping("/getAllDisease")
	public ResponseEntity<List<GetAllDiseaseResponse>> getAll(){
		
		return ResponseEntity.ok(diseaseService.getAllDisease());
	}
	
}
