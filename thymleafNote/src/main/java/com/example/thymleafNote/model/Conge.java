package com.example.thymleafNote.model;

import java.util.Date;

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
public class Conge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "datedebut is required")
    private Date datedebut;

	@NotNull(message = "datefin is required")
    private Date datefin;
	
	@ManyToOne
	@JoinColumn(name = "employe_id")
    private Employe employes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatedebut() {
		return datedebut;
	}

	public void setDatedebut(Date datedebut) {
		this.datedebut = datedebut;
	}

	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	
	public Employe getEmploye() {
        return employes;
    }

    public void setEmploye(Employe employes) {
        this.employes = employes;
    }

	public Conge(Long id, @NotNull(message = "dateDebut is required") Date datedebut,
			@NotNull(message = "dateFin is required") Date datefin, Employe employes) {
		super();
		this.id = id;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.employes = employes;
	}

	public Conge() {
		super();
	}



	

    
}
