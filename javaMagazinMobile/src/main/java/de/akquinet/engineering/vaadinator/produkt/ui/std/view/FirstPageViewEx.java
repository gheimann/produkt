package de.akquinet.engineering.vaadinator.produkt.ui.std.view;

public interface FirstPageViewEx extends FirstPageView {

	public void setUnlimitedView(boolean unlimited);
	
	public static interface Observer {
		
		public void onMeinWarenkorb();
		
	}

}
