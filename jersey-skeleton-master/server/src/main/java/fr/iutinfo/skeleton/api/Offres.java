package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.OffresDto;

public class Offres {
	
	final static Logger logger = LoggerFactory.getLogger(Recruteur.class);
	private int num;
	private String mailRecru;
	private String poste;
	private String description;
	private int nbHeure;
	
	public Offres(){}
	
	public Offres(int num, String mailRecru,String poste,String description,int nbHeure){
		this.num=num;
		this.mailRecru=mailRecru;
		this.poste=poste;
		this.description=description;
		this.nbHeure=nbHeure;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getMailRecru() {
		return mailRecru;
	}

	public void setMailRecru(String mailRecru) {
		this.mailRecru = mailRecru;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNbHeure() {
		return nbHeure;
	}

	public void setNbHeure(int nbHeure) {
		this.nbHeure = nbHeure;
	}

	public void initFromDto(OffresDto dto){
		this.setDescription(dto.getDescription());
		this.setMailRecru(dto.getMailRecru());
		this.setNbHeure(dto.getNbHeure());
		this.setNum(dto.getNum());
		this.setPoste(dto.getPoste());
	}
	
}
