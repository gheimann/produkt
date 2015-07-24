package de.akquinet.engineering.vaadinator.produkt.ui.std.view;

public class ProduktListViewImplEx extends ProduktListViewImpl implements ProduktListViewEx {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProduktListViewImplEx() {
		super();
	}

	@Override
	public void setAddButtonVisible(boolean visible) {
		addProdukt.setVisible(visible);
	}

}
