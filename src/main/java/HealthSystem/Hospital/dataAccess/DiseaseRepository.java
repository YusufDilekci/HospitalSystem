package HealthSystem.Hospital.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import HealthSystem.Hospital.entities.Disease;

public interface DiseaseRepository extends JpaRepository<Disease,Integer>{
	Disease findByName(String name);
}
