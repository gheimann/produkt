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
	public void initializeUi() {
		super.initializeUi();
	}

	@Override
	public void setUnlimitedView(boolean unlimited) {
		save.setVisible(unlimited);
		mwstSatz.setVisible(unlimited);
		boolean limited = !unlimited;
		bezeichnung.setReadOnly(limited);
		beschreibung.setReadOnly(limited);
		preis.setReadOnly(limited);
		if (limited) {
			cancel.setCaption(obtainBundle().getString("close"));
		}
	}

}
