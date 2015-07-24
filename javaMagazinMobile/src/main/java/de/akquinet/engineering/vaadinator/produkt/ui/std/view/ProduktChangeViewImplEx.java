package de.akquinet.engineering.vaadinator.produkt.ui.std.view;

public class ProduktChangeViewImplEx extends ProduktChangeViewImpl implements ProduktChangeViewEx {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProduktChangeViewImplEx() {
		super();
	}

	@Override
	public void setSaveButtonVisible(boolean visible) {
		save.setVisible(visible);
	}

}
