package de.akquinet.engineering.vaadinator.produkt.ui.std.presenter;

import java.util.Map;

import de.akquinet.engineering.vaadinator.produkt.service.WarenkorbService;
import de.akquinet.engineering.vaadinator.produkt.ui.presenter.Presenter;
import de.akquinet.engineering.vaadinator.produkt.ui.std.view.WarenkorbChangeViewEx;

public class WarenkorbChangePresenterImplEx extends WarenkorbChangePresenterImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WarenkorbChangePresenterImplEx(Map<String, Object> context, WarenkorbChangeViewEx view,
			Presenter returnPresenter, WarenkorbService service) {
		super(context, view, returnPresenter, service);
		this.view = view;
	}
	
	private WarenkorbChangeViewEx view;

	@Override
	protected void loadFromModel() { // TODO: test
		super.loadFromModel();
		view.setProduktListe(getWarenkorb().getItems());
	}

}
