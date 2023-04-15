package com.ats.reposatory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.entity.AtsCompany;
@Repository
public interface AtsCompanyRepo extends JpaRepository<AtsCompany, Integer>{
	AtsCompany findByCompanyName(String args);
	
	
}
