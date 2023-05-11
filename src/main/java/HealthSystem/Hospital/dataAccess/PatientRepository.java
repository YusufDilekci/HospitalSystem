package HealthSystem.Hospital.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import HealthSystem.Hospital.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
