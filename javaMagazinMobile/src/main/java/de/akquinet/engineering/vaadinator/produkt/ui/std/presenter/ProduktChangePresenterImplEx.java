package de.akquinet.engineering.vaadinator.produkt.ui.std.presenter;

import java.util.Map;

import de.akquinet.engineering.vaadinator.produkt.model.Warenkorb;
import de.akquinet.engineering.vaadinator.produkt.service.ProduktService;
import de.akquinet.engineering.vaadinator.produkt.ui.presenter.Presenter;
import de.akquinet.engineering.vaadinator.produkt.ui.std.view.ProduktChangeViewEx;

public class ProduktChangePresenterImplEx extends ProduktChangePresenterImpl implements ProduktChangeViewEx.Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProduktChangePresenterImplEx(Map<String, Object> context, ProduktChangeViewEx view, Presenter returnPresenter,
			ProduktService service, Warenkorb nutzerWarenkorb, boolean adminMode) {
		super(context, view, returnPresenter, service);
		this.view = view;
		this.returnPresenter = returnPresenter;
		this.nutzerWarenkorb = nutzerWarenkorb;
		this.adminMode = adminMode;
	}

	private ProduktChangeViewEx view;
	private Presenter returnPresenter;
	private Warenkorb nutzerWarenkorb;
	private boolean adminMode;

	@Override
	public void startPresenting() {
		super.startPresenting();
		view.setUnlimitedView(adminMode);
	}

	@Override
	public void onInWarenkorb() {
		nutzerWarenkorb.addProdukt(getProdukt());
		view.showInfoMessage("istInWarenkorb", getProdukt().getBezeichnung(),
				String.valueOf(nutzerWarenkorb.getProdukte().size()));
		// analog speichern / abbrechen
		if (returnPresenter != null) {
			returnPresenter.returnToThisPresener(this);
		}
	}

}
