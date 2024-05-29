package com.example.thymleafNote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thymleafNote.model.Candidat;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Long>  {

}
