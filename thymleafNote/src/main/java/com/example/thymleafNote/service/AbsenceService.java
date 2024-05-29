package com.example.thymleafNote.service;

import java.util.List;

import com.example.thymleafNote.model.Absence;
import com.example.thymleafNote.model.Conge;

public interface AbsenceService {

	List<Absence> findAll();
	
	Absence findById(Long id);
		
	Absence save(Absence absence);
		
	void deleteById(Long id);
	
	List<Absence> findAllByEmployeId(Long employeId);
}
