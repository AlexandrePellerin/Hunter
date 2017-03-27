package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.EtudiantDto;

public class Etudiant {
	final static Logger logger = LoggerFactory.getLogger(Etudiant.class);
	private String mail;
	private String password;
	private String birth;
	private String name;
	private String prenom;
	private String cv;
	private int rayon;
	private String formation;
	private String experience;
	private String dispo;
	private String photo;

	public Etudiant(String mail, String mdp, String name, String prenom, String birth, String cv, int rayon,
			String formation, String experience, String dispo, String photo) {
		this.birth = birth;
		this.mail = mail;
		this.password = mdp;
		this.name = name;
		this.prenom = prenom;
		this.cv = cv;
		this.rayon = rayon;
		this.formation = formation;
		this.experience = experience;
		this.dispo = dispo;
		this.photo = photo;
	}


	public Etudiant() {

	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getprenom() {
		return prenom;
	}

	public void setprenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public int getRayon() {
		return rayon;
	}

	public void setRayon(int rayon) {
		this.rayon = rayon;
	}

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getDispo() {
		return dispo;
	}

	public void setDispo(String dispo) {
		this.dispo = dispo;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void initFromDto(EtudiantDto dto) {

		this.setMail(dto.getMail());
		this.setPassword(dto.getPassword());
		this.setBirth(dto.getBirth());
		this.setCv(dto.getCv());
		this.setDispo(dto.getDispo());
		this.setExperience(dto.getExperience());
		this.setFormation(dto.getFormation());
		this.setname(dto.getname());
		this.setPhoto(dto.getPhoto());
		this.setprenom(dto.getprenom());
		this.setRayon(dto.getRayon());
	}

	public EtudiantDto convertToDto() {
		EtudiantDto dto = new EtudiantDto();

		dto.setMail(this.getMail());
		dto.setPassword(this.getPassword());
		dto.setBirth(this.getBirth());
		dto.setCv(this.getCv());
		dto.setDispo(this.getDispo());
		dto.setExperience(this.getExperience());
		dto.setFormation(this.getFormation());
		dto.setname(this.getname());
		dto.setPhoto(this.getPhoto());
		dto.setprenom(this.getprenom());
		dto.setRayon(this.getRayon());

		return dto;
	}
}
