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
	public void setAddButtonVisible(boolean visible) {
		newProduktButton.setVisible(visible);
	}

}
