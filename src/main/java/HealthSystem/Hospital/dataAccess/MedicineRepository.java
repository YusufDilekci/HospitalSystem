package HealthSystem.Hospital.dataAccess;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import HealthSystem.Hospital.entities.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Integer>, PagingAndSortingRepository<Medicine, Integer> {
	
	Medicine findByMedicineName(String name);
	
	Page<Medicine> findAll(Pageable pageable);
	
	//Hastalığa göre verilen ilaçlar
	@Query("Select m FROM Medicine m JOIN m.medicineDiseases md JOIN md.disease d WHERE d.diseaseName = :diseaseName")
	List<Medicine> findMedicineByDisease(@Param("diseaseName") String diseaseName);
	
	//Patient TC nosuna göre hastalığı belirlenip verilen ilaçlar
	@Query("Select m FROM Medicine m JOIN m.medicineDiseases md JOIN md.disease d JOIN d.patients p WHERE p.tcNo = :tcNo")
	List<Medicine> findMedicineByPatientTc(@Param("tcNo") String tcNo);
}
