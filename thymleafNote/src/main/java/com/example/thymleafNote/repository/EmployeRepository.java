package com.example.thymleafNote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.thymleafNote.model.Employe;


@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {

}
