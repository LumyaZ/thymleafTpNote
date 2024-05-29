package com.example.thymleafNote.service;

import java.util.List;

import com.example.thymleafNote.model.Conge;

public interface CongeService {
	List<Conge> findAll();
	
	Conge findById(Long id);
		
	Conge save(Conge conge);
		
	void deleteById(Long id);
	
	List<Conge> findAllByEmployeId(Long employeId);
}
