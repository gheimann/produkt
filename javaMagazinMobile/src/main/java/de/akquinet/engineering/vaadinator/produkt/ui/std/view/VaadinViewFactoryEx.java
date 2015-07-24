package de.akquinet.engineering.vaadinator.produkt.ui.std.view;

public class VaadinViewFactoryEx extends VaadinViewFactory implements ViewFactoryEx {

	public VaadinViewFactoryEx() {
		super();
	}

	@Override
	public ProduktChangeViewEx createProduktChangeView() {
		return new ProduktChangeViewImplEx();
	}

	@Override
	public ProduktListViewEx createProduktListView() {
		return new ProduktListViewImplEx();
	}

	@Override
	public FirstPageViewEx createFirstPageView() {
		return new FirstPageViewImplEx();
	}

}
