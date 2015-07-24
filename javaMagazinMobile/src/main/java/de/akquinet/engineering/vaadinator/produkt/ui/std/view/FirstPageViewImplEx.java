package de.akquinet.engineering.vaadinator.produkt.ui.std.view;

public class FirstPageViewImplEx extends FirstPageViewImpl implements FirstPageViewEx {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FirstPageViewImplEx() {
		super();
	}

	@Override
	public void setUnlimitedView(boolean unlimited) {
		newProduktButton.setVisible(unlimited);
	}

}
