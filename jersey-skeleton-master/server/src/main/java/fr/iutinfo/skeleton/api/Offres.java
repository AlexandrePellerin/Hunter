package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.iutinfo.skeleton.common.dto.OffresDto;

public class Offres {
	
	final static Logger logger = LoggerFactory.getLogger(Recruteur.class);
	private int numero;
	private String mailRecru;
	private String poste;
	private String description;
	private int nbHeure;
	
	public Offres(){}
	
	public Offres(int numero, String mailRecru,String poste,String description,int nbHeure){
		this.numero=numero;
		this.mailRecru=mailRecru;
		this.poste=poste;
		this.description=description;
		this.nbHeure=nbHeure;
	}

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

	public void initFromDto(OffresDto dto){
		this.setDescription(dto.getDescription());
		this.setMailRecru(dto.getMailRecru());
		this.setNbHeure(dto.getNbHeure());
		this.setNumero(dto.getNumero());
		this.setPoste(dto.getPoste());
	}
	
	public OffresDto convertToDto(){
		OffresDto dto = new OffresDto();
	
		dto.setDescription(this.getDescription());
		dto.setMailRecru(this.getMailRecru());
		dto.setNbHeure(this.getNbHeure());
		dto.setNumero(this.getNumero());
		dto.setPoste(this.getPoste());
		
		return dto;
	}
	
}
