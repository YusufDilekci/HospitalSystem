package HealthSystem.Hospital.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import HealthSystem.Hospital.entities.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer>{
	
	Medicine findByName(String name);
}
