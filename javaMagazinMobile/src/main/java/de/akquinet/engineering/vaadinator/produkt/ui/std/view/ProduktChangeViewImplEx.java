package de.akquinet.engineering.vaadinator.produkt.ui.std.view;

import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class ProduktChangeViewImplEx extends ProduktChangeViewImpl implements ProduktChangeViewEx {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProduktChangeViewImplEx() {
		super();
	}
	
	protected Button inWarenkorb = new Button();
	
	private ProduktChangeViewEx.Observer observer;

	@Override
	public void initializeUi() {
		super.initializeUi();
		inWarenkorb.addStyleName("styleid-ProduktChangeViewImplEx-inWarenkorb");
		inWarenkorb.setCaption(obtainBundle().getString("inWarenkorb"));
		inWarenkorb.addClickListener(new ClickListener() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				observer.onInWarenkorb();
			}
		});
		layout.addComponent(inWarenkorb);
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

	@Override
	public void showInfoMessage(String message) {
		if (obtainBundle().containsKey(message)) {
			message = obtainBundle().getString(message);
		}
		Notification.show(message, Notification.Type.HUMANIZED_MESSAGE);
	}

	@Override
	public void setObserver(ProduktChangeView.Observer observer) {
		super.setObserver(observer);
		this.observer = (ProduktChangeViewEx.Observer) observer;		
	}

}
