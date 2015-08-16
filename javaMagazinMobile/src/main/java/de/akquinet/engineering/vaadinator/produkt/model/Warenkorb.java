package de.akquinet.engineering.vaadinator.produkt.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.akquinet.engineering.vaadinator.annotations.DisplayBean;
import de.akquinet.engineering.vaadinator.annotations.DisplayBeanSetting;
import de.akquinet.engineering.vaadinator.annotations.DisplayProperty;
import de.akquinet.engineering.vaadinator.annotations.DisplayPropertySetting;
import de.akquinet.engineering.vaadinator.annotations.FieldType;

@DisplayBean(profiles = @DisplayBeanSetting(profileName = "std", showOnFirstPage = false))
public class Warenkorb implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Warenkorb() {
		super();
	}

	private List<WarenkorbItem> items = new ArrayList<WarenkorbItem>();

	public List<WarenkorbItem> getItems() {
		return items;
	}

	public void setItems(List<WarenkorbItem> items) {
		this.items = items;
	}

	public void addItem(WarenkorbItem item) {
		items.add(item);
	}

	@DisplayProperty(captionText = "Anzahl Produkte", profileSettings = @DisplayPropertySetting(readOnly = true, fieldType = FieldType.LABEL))
	public int getAnzahlItems() {
		return getItems().size();
	}

	@DisplayProperty(captionText = "Summe in €", profileSettings = @DisplayPropertySetting(readOnly = true, fieldType = FieldType.LABEL))
	public double getBruttoSumme() {
		double res = 0.0;
		for (WarenkorbItem item : getItems()) {
			res += item.getPreis();
		}
		return res;
	}

	@DisplayProperty(captionText = "Summe netto in €", profileSettings = @DisplayPropertySetting(readOnly = true, fieldType = FieldType.LABEL))
	public double getNettoSumme() {
		double res = 0.0;
		for (WarenkorbItem item : getItems()) {
			res += item.getPreisNetto();
		}
		return res;
	}

	@DisplayProperty(captionText = "Summe MwSt in €", profileSettings = @DisplayPropertySetting(readOnly = true, fieldType = FieldType.LABEL))
	public double getMwStSumme() {
		double res = 0.0;
		for (WarenkorbItem item : getItems()) {
			res += item.getMwSt();
		}
		return res;
	}

}
