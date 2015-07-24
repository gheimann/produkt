package de.akquinet.engineering.vaadinator.produkt.ui.std.view;

import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickEvent;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickListener;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;

public class FirstPageViewImplEx extends FirstPageViewImpl implements FirstPageViewEx {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FirstPageViewImplEx() {
		super();
	}

	protected NavigationButton meinWarenkorbButton = new NavigationButton();

	private FirstPageViewEx.Observer observer;

	@Override
	public void initializeUi() {
		super.initializeUi();
		meinWarenkorbButton.addStyleName("styleid-FirstPageViewImplEx-meinWarenkorbButton");
		meinWarenkorbButton.setCaption(obtainBundle().getString("meinWarenkorb"));
		meinWarenkorbButton.addClickListener(new NavigationButtonClickListener() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(NavigationButtonClickEvent event) {
				observer.onMeinWarenkorb();
			}
		});
		((VerticalComponentGroup) listProduktButton.getParent()).addComponent(meinWarenkorbButton);
	}

	@Override
	public void setUnlimitedView(boolean unlimited) {
		newProduktButton.setVisible(unlimited);
	}

	@Override
	public void setObserver(FirstPageView.Observer observer) {
		super.setObserver(observer);
		this.observer = (FirstPageViewEx.Observer) observer;
	}

}
