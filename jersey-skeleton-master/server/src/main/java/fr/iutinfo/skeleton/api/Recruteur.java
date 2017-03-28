package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.RecruteurDto;

public class Recruteur {
	final static Logger logger = LoggerFactory.getLogger(Recruteur.class);

	private String mail;
	private String nom;
	private String passwd;
	private String prenom;
	private String societe;
	private String address;
	private String siret;
	
	public Recruteur(){}
	
	public Recruteur(String mail,String nom, String passwd, String prenom,String societe,String address, String siret){
		this.mail=mail;
		this.nom=nom;
		this.passwd=passwd;
		this.prenom=prenom;
		this.societe=societe;
		this.address=address;
		this.siret=siret;
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
	
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public void initFromDto(RecruteurDto dto){
		this.setMail(dto.getMail());
		this.setNom(dto.getNom());
		this.setPasswd(dto.getPasswd());
		this.setAddress(dto.getAddress());
		this.setPrenom(dto.getPrenom());
		this.setSiret(dto.getSiret());
		this.setSociete(dto.getSociete());
	}
	
	public RecruteurDto convertToDto(){
		RecruteurDto dto = new RecruteurDto();
		dto.setMail(this.getMail());
		dto.setNom(this.getNom());
		dto.setPasswd(this.getPasswd());
		dto.setAddress(this.getAddress());
		dto.setPrenom(this.getPrenom());
		dto.setSiret(this.getSiret());
		dto.setSociete(this.getSociete());
		return dto;
	}
}
