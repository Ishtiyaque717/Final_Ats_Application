package com.ats.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Ats_Company")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class AtsCompany {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;
	@Column(name= "company_Name")
	private String companyName;
	@JoinColumn(name="ats_atsId")
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	public Ats ats;
	@JoinColumn(name="Company_ID")
	@OneToMany(cascade = CascadeType.ALL)
	List<AtsPackage> atsPackages;
	

}
