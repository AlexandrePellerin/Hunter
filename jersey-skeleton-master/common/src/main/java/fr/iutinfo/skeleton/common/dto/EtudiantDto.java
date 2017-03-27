package fr.iutinfo.skeleton.common.dto;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EtudiantDto {
	final static Logger logger = LoggerFactory.getLogger(EtudiantDto.class);
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
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
	/*public String getFormation() {
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
	}*/
	
	
	
}
