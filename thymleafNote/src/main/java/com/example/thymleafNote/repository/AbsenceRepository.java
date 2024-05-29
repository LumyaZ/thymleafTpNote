package com.example.thymleafNote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thymleafNote.model.Absence;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {

}
