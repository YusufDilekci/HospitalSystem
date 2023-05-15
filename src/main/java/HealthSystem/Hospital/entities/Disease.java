package HealthSystem.Hospital.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="diseases")
public class Disease {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String diseaseName;
	
	@Column
	private String diseaseBranch;
	
	@OneToMany(mappedBy="disease")
	private Set<Patient> patients;
	
	@OneToMany(mappedBy="disease")
	private Set<MedicineDisease> medicineDiseases;
	
}
