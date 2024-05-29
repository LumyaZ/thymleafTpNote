package com.example.thymleafNote.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Candidat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Nom is required")
	private String nom;
	
	@NotEmpty(message = "numeroidentite is required")
	private String numeroidentite;
	
	@NotNull(message = "datenaissance is required")
	private Date datenaissance;
	
	@NotEmpty(message = "adresse is required")
	private String adresse;
	
	@Email(message = "Un email valide" )
	@NotEmpty(message = "email is required")
	private String email;
	
	@NotEmpty(message = "telephone is required")
	private String telephone;
	
	@NotEmpty(message = "note is required")
	private String note;
	
	@NotEmpty(message = "domainetechnique is required")
	private String domainetechnique;
	
	@NotNull(message = "dateentretien is required")
	private Date dateentretien;
	
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

	public String getNumeroidentite() {
		return numeroidentite;
	}

	public void setNumeroidentite(String numeroidentite) {
		this.numeroidentite = numeroidentite;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getDomainetechnique() {
		return domainetechnique;
	}

	public void setDomainetechnique(String domainetechnique) {
		this.domainetechnique = domainetechnique;
	}

	public Date getDateentretien() {
		return dateentretien;
	}

	public void setDateentretien(Date dateentretien) {
		this.dateentretien = dateentretien;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Candidat(Long id, @NotEmpty(message = "Nom is required") String nom,
			@NotEmpty(message = "numeroIdentite is required") String numeroidentite,
			@NotEmpty(message = "dateNaissance is required") Date datenaissance,
			@NotEmpty(message = "adresse is required") String adresse,
			@Email(message = "Un email valide") @NotEmpty(message = "email is required") String email,
			@NotEmpty(message = "telephone is required") String telephone,
			@NotEmpty(message = "note is required") String note,
			@NotEmpty(message = "domaineTechnique is required") String domainetechnique,
			@NotEmpty(message = "dateEntretien is required") Date dateentretien,
			@NotEmpty(message = "description is required") String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.numeroidentite = numeroidentite;
		this.datenaissance = datenaissance;
		this.adresse = adresse;
		this.email = email;
		this.telephone = telephone;
		this.note = note;
		this.domainetechnique = domainetechnique;
		this.dateentretien = dateentretien;
		this.description = description;
	}

	public Candidat() {
		super();
	}
	
	
}
