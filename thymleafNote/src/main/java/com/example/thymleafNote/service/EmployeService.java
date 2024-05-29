package com.example.thymleafNote.service;

import java.util.List;

import com.example.thymleafNote.model.Employe;

public interface EmployeService {

	List<Employe> findAll();
	
	Employe findById(Long id);
	
	Employe save(Employe employe);
	
	void deleteById(Long id);
	
	
}
