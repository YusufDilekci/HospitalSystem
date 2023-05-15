package HealthSystem.Hospital.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import HealthSystem.Hospital.entities.Disease;

public interface DiseaseRepository extends JpaRepository<Disease,Integer>{
	Disease findByDiseaseName(String name);
	
	@Query("SELECT d FROM Disease d JOIN d.medicineDiseases md JOIN md.medicine m WHERE m.medicineName = :medicineName")
	List<Disease> findDiseaseByMedicine(@Param("medicineName") String medicineName);
	
	@Query("SELECT d FROM Disease d JOIN d.patients p WHERE p.id = :patientId")
	Disease findDiseaseByPatientId(@Param("patientId") int patientId);
}
