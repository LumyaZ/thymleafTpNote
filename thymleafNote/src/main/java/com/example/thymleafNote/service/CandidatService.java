package com.example.thymleafNote.service;

import java.util.List;

import com.example.thymleafNote.model.Candidat;

public interface CandidatService {

	List<Candidat> findAll();
		
	Candidat findById(Long id);
		
	Candidat save(Candidat candidat);
		
	void deleteById(Long id);
}
