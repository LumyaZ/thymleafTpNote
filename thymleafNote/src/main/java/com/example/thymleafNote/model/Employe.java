package com.example.thymleafNote.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Employe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Nom is required")
	private String nom;
	
	@NotEmpty(message = "occupation is required")
	private String occupation;
	
	@NotEmpty(message = "salaire is required")
	private String salaire;
	
	@NotNull(message = "dateDebut is required")
	private Date datedebut;
	
	@NotNull(message = "dateFin is required")
	private Date datefin;
	
	@NotEmpty(message = "numeroIdentifiant is required")
	private String numeroidentifiant;
	
	@NotNull(message = "dateNaissance is required")
	private Date datenaissance;
	
	@NotEmpty(message = "adresse is required")
	private String adresse;
	
	@Email(message = "Un email valide" )
	@NotEmpty(message = "email is required")
	private String email;
	
	@NotEmpty(message = "telephone is required")
	private String telephone;
	
	@NotEmpty(message = "description is required")
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getSalaire() {
		return salaire;
	}

	public void setSalaire(String salaire) {
		this.salaire = salaire;
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

	public String getNumeroidentifiant() {
		return numeroidentifiant;
	}

	public void setNumeroidentifiant(String numeroidentifiant) {
		this.numeroidentifiant = numeroidentifiant;
	}

	public Date getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Employe(Long id, @NotEmpty(message = "Nom is required") String nom,
			@NotEmpty(message = "occupation is required") String occupation,
			@NotEmpty(message = "salaire is required") String salaire,
			@NotNull(message = "dateDebut is required") Date datedebut,
			@NotNull(message = "dateFin is required") Date datefin,
			@NotEmpty(message = "numeroIdentifiant is required") String numeroidentifiant,
			@NotNull(message = "dateNaissance is required") Date datenaissance,
			@NotEmpty(message = "adresse is required") String adresse,
			@Email(message = "Un email valide") @NotEmpty(message = "email is required") String email,
			@NotEmpty(message = "telephone is required") String telephone,
			@NotEmpty(message = "description is required") String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.occupation = occupation;
		this.salaire = salaire;
		this.datedebut = datedebut;
		this.datefin = datefin;
		this.numeroidentifiant = numeroidentifiant;
		this.datenaissance = datenaissance;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
		this.description = description;
	}

	public Employe() {
		super();
	}
	
	
    
    
}
