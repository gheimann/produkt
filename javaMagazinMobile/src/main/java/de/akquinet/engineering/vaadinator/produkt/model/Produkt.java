package de.akquinet.engineering.vaadinator.produkt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import de.akquinet.engineering.vaadinator.annotations.DisplayBean;
import de.akquinet.engineering.vaadinator.annotations.DisplayProperty;
import de.akquinet.engineering.vaadinator.annotations.DisplayPropertySetting;
import de.akquinet.engineering.vaadinator.annotations.FieldType;

@DisplayBean(captionText = "Produkt")
@Entity
public class Produkt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Produkt() {
		super();
	}

	public Produkt(String nummer, String beschreibung, double preis, int mwstSatz) {
		super();
		this.beschreibung = beschreibung;
		this.preis = preis;
		this.mwstSatz = mwstSatz;
		this.nummer = nummer;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@DisplayProperty(profileSettings = { @DisplayPropertySetting(required = true) })
	private String nummer;
	@DisplayProperty
	private String beschreibung;
	@DisplayProperty
	private double preis;
	@DisplayProperty(captionText="Mehrwertsteuersatz")
	private int mwstSatz;
	@Temporal(TemporalType.DATE)
	private Date aufgenommen;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNummer() {
		return nummer;
	}

	public void setNummer(String nummer) {
		this.nummer = nummer;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public int getMwstSatz() {
		return mwstSatz;
	}

	public void setMwstSatz(int mwstSatz) {
		this.mwstSatz = mwstSatz;
	}

	public Date getAufgenommen() {
		return aufgenommen;
	}

	public void setAufgenommen(Date aufgenommen) {
		this.aufgenommen = aufgenommen;
	}
	
	
}
