package com.ats.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Ats_Package")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class AtsPackage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int packageId;
	int noOfEducation;
	int noOfEmployement;
	int noOfDrugTest;


	
}
