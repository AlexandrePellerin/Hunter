package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OffresDto {
	final static Logger logger = LoggerFactory.getLogger(OffresDto.class);
	private int numero;
	private String mailRecru;
	private String poste;
	private String description;
	private int nbHeure;
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

}
