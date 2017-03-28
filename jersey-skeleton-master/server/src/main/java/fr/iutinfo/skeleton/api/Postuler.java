package fr.iutinfo.skeleton.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Postuler {
	
	private int numero;
	private String emailEtu, statut;
	final static Logger logger = LoggerFactory.getLogger(Postuler.class);
	
	public Postuler(){
		
	}
	
	public Postuler(int numero, String emailEtu, String statut){
		this.statut = statut;
		this.numero=numero;
		this.emailEtu = emailEtu;
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
