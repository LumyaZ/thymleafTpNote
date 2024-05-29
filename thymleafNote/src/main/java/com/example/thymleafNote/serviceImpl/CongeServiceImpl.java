package com.example.thymleafNote.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.thymleafNote.model.Conge;
import com.example.thymleafNote.model.Employe;
import com.example.thymleafNote.repository.CongeRepository;
import com.example.thymleafNote.service.CongeService;

@Service
public class CongeServiceImpl implements CongeService {

	@Autowired
	private CongeRepository congeRepo;
	
	@Override
	public List<Conge> findAll() {
		// TODO Auto-generated method stub
		return congeRepo.findAll();
	}

	@Override
	public Conge findById(Long id) {
		// TODO Auto-generated method stub
		return congeRepo.findById(id).orElse(null);
	}

	@Override
	public Conge save(Conge conge) {
		// TODO Auto-generated method stub
		return congeRepo.save(conge);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		congeRepo.deleteById(id);
	}

	@Override
	public List<Conge> findAllByEmployeId(Long employeId) {
		Employe employe = new Employe();
		employe.setId(employeId);
		Conge conge = new Conge();
		conge.setEmploye(employe);
		List<Conge> findAllConge = congeRepo.findAll(Example.of(conge));
		return findAllConge;
	}

}
