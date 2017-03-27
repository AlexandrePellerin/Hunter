package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.RecruteurDto;

public class Recruteur {
	final static Logger logger = LoggerFactory.getLogger(Recruteur.class);

	private String mail;
	private String nom;
	
	public Recruteur(){}
	
	public Recruteur(String mail,String nom){
		this.mail=mail;
		this.nom=nom;
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

	
	
	public void initFromDto(RecruteurDto dto){
		this.setMail(dto.getMail());
		this.setNom(dto.getNom());
	}
	
	public RecruteurDto convertToDto(){
		RecruteurDto dto = new RecruteurDto();
		dto.setMail(this.getMail());
		dto.setNom(this.getNom());
		
		return dto;
	}
}
