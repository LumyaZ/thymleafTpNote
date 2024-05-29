package com.example.thymleafNote.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Absence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "date is required")
    private Date date;

	@ManyToOne
	@JoinColumn(name = "employe_id")
    private Employe employes;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Absence() {
		super();
	}
	
	public Employe getEmploye() {
        return employes;
    }

    public void setEmploye(Employe employes) {
        this.employes = employes;
    }

	public Absence(Long id, @NotNull(message = "date is required") Date date, Employe employes) {
		super();
		this.id = id;
		this.date = date;
		this.employes = employes;
	}
	
    
    
    
}
