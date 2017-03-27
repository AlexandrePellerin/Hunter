package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecruteurDto {

	final static Logger logger = LoggerFactory.getLogger(RecruteurDto.class);
	private String mail;
	private String nom;
	private String passwd;
	private String prenom;
	private String societe;
	private String address;
	private String siret;
	
	public RecruteurDto(){
		
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

	

}
