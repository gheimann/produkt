package de.akquinet.engineering.vaadinator.produkt.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.akquinet.engineering.vaadinator.annotations.DisplayBean;
import de.akquinet.engineering.vaadinator.annotations.DisplayBeanSetting;

@DisplayBean(profiles = @DisplayBeanSetting(profileName = "std", showOnFirstPage = false))
public class Warenkorb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Warenkorb() {
		super();
	}

	private List<Produkt> produkte = new ArrayList<Produkt>();

	public List<Produkt> getProdukte() {
		return produkte;
	}

	public void setProdukte(List<Produkt> produkte) {
		this.produkte = produkte;
	}

	public void addProdukt(Produkt produkt) {
		produkte.add(produkt);
	}

}
