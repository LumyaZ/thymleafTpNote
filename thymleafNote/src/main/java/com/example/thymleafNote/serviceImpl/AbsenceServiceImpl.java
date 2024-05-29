package com.example.thymleafNote.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.thymleafNote.model.Absence;
import com.example.thymleafNote.model.Conge;
import com.example.thymleafNote.model.Employe;
import com.example.thymleafNote.repository.AbsenceRepository;
import com.example.thymleafNote.service.AbsenceService;

@Service
public class AbsenceServiceImpl implements AbsenceService {

	@Autowired
	private AbsenceRepository absenceRepo;

	@Override
	public List<Absence> findAll() {
		// TODO Auto-generated method stub
		return  absenceRepo.findAll();
	}

	@Override
	public Absence findById(Long id) {
		// TODO Auto-generated method stub
		return absenceRepo.findById(id).orElse(null);
	}

	@Override
	public Absence save(Absence absence) {
		// TODO Auto-generated method stub
		return absenceRepo.save(absence);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		absenceRepo.deleteById(id);
	}
	
	@Override
	public List<Absence> findAllByEmployeId(Long employeId) {
		Employe employe = new Employe();
		employe.setId(employeId);
		Absence absence = new Absence();
		absence.setEmploye(employe);
		List<Absence> findAllAbsence = absenceRepo.findAll(Example.of(absence));
		return findAllAbsence;
	}
}
