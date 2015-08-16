package de.akquinet.engineering.vaadinator.produkt.ui.std.view;

import java.util.List;

import de.akquinet.engineering.vaadinator.produkt.model.WarenkorbItem;


public interface WarenkorbChangeViewEx extends WarenkorbChangeView {

	public void setProduktListe(List<WarenkorbItem> produktListe);

}
