package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecruteurDto {

	final static Logger logger = LoggerFactory.getLogger(RecruteurDto.class);
	private String mail;
	private String nom;
	
	public RecruteurDto(){
		
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
