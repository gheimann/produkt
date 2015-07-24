package de.akquinet.engineering.vaadinator.produkt.ui.std.presenter;

import java.util.Map;

import de.akquinet.engineering.vaadinator.produkt.model.Warenkorb;
import de.akquinet.engineering.vaadinator.produkt.ui.std.view.FirstPageViewEx;

public class FirstPagePresenterImplEx extends FirstPagePresenterImpl implements FirstPageViewEx.Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FirstPagePresenterImplEx(Map<String, Object> context, FirstPageViewEx view, PresenterFactoryEx presenterFactory,
			Warenkorb nutzerWarenkorb, boolean adminMode) {
		super(context, view, presenterFactory);
		this.view = view;
		this.presenterFactory = presenterFactory;
		this.nutzerWarenkorb = nutzerWarenkorb;
		this.adminMode = adminMode;
	}
	
	private FirstPageViewEx view;
	private PresenterFactoryEx presenterFactory;
	private Warenkorb nutzerWarenkorb;
	private boolean adminMode;

	@Override
	public void startPresenting() {
		super.startPresenting();
		view.setUnlimitedView(adminMode);
	}

	@Override
	public void onMeinWarenkorb() { // TODO: test
		WarenkorbChangePresenter cpres = presenterFactory.createWarenkorbChangePresenter(this);
		cpres.setWarenkorb(nutzerWarenkorb);
		view.openSubView(cpres.getView());
		cpres.startPresenting();
	}

}
