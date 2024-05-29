package com.example.thymleafNote.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.thymleafNote.model.Candidat;
import com.example.thymleafNote.repository.CandidatRepository;
import com.example.thymleafNote.service.CandidatService;

@Service
public class CandidatServiceImpl implements CandidatService {

	@Autowired
	private CandidatRepository candidatRepo;

	@Override
	public List<Candidat> findAll() {
		return candidatRepo.findAll();
	}

	@Override
	public Candidat findById(Long id) {
		// TODO Auto-generated method stub
		return candidatRepo.findById(id).orElse(null);
	}

	@Override
	public Candidat save(Candidat candidat) {
		return candidatRepo.save(candidat);
	}

	@Override
	public void deleteById(Long id) {
		candidatRepo.deleteById(id);
	}
}
