package com.example.thymleafNote.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thymleafNote.model.Employe;
import com.example.thymleafNote.repository.EmployeRepository;
import com.example.thymleafNote.service.EmployeService;

@Service
public class EmployeServiceImpl implements EmployeService {

	@Autowired
	private EmployeRepository employesRepo;
	
	@Override
	public List<Employe> findAll() {
		return employesRepo.findAll();
	}

	@Override
	public Employe findById(Long id) {
		// TODO Auto-generated method stub
		return employesRepo.findById(id).orElse(null);
	}

	@Override
	public Employe save(Employe employe) {
		// TODO Auto-generated method stub
		return employesRepo.save(employe);
	}

	@Override
	public void deleteById(Long id) {
		employesRepo.deleteById(id);
		
	}

}
