package com.example.thymleafNote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thymleafNote.model.Conge;

@Repository
public interface CongeRepository extends JpaRepository<Conge, Long> {

}
