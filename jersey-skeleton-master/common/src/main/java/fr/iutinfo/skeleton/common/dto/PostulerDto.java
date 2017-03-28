package fr.iutinfo.skeleton.common.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostulerDto {
	private int numero;
	private String emailEtu, statut;
	final static Logger logger = LoggerFactory.getLogger(PostulerDto.class);
	
	public PostulerDto() {
		// TODO Auto-generated constructor stub
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEmailEtu() {
		return emailEtu;
	}

	public void setEmailEtu(String emailEtu) {
		this.emailEtu = emailEtu;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	
}
