package HealthSystem.Hospital.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import HealthSystem.Hospital.entities.MedicineDisease;

public interface MedicineDiseaseRepository extends JpaRepository<MedicineDisease, Integer>{
	
}
