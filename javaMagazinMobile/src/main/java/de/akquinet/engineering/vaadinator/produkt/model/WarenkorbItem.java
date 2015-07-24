package de.akquinet.engineering.vaadinator.produkt.model;


public class WarenkorbItem {

	private Produkt produkt;

	public WarenkorbItem(Produkt produkt) {
		super();
		this.produkt = produkt;
	}

	public String getBezeichnung() {
		return produkt.getBezeichnung();
	}

	public double getPreis() {
		return produkt.getPreis();
	}

}