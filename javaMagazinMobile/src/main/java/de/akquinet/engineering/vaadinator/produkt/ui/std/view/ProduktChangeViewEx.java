package de.akquinet.engineering.vaadinator.produkt.ui.std.view;

public interface ProduktChangeViewEx extends ProduktChangeView {

	public void setUnlimitedView(boolean unlimited);
	
	public void showInfoMessage(String message);
	
	public static interface Observer extends ProduktChangeView.Observer {
		
		public void onInWarenkorb();
	
	}

}
