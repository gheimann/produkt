package de.akquinet.engineering.vaadinator.produkt.ui.std.view;

public interface ViewFactoryEx extends ViewFactory {

	@Override
	public ProduktChangeViewEx createProduktChangeView();

	@Override
	public ProduktListViewEx createProduktListView();

	@Override
	public FirstPageViewEx createFirstPageView();
	
}
