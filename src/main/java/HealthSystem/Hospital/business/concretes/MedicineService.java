package HealthSystem.Hospital.business.concretes;

import org.springframework.stereotype.Service;

import HealthSystem.Hospital.dataAccess.MedicineRepository;
import HealthSystem.Hospital.entities.Medicine;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicineService {
	private final MedicineRepository medicineRepository;
	
	public Medicine getMedicineByName(String name) {
		return medicineRepository.findByName(name);
	}
	
}
