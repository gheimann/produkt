package de.akquinet.engineering.vaadinator.produkt.ui.std.presenter;

import java.util.Map;

import de.akquinet.engineering.vaadinator.produkt.service.ProduktService;
import de.akquinet.engineering.vaadinator.produkt.ui.presenter.Presenter;
import de.akquinet.engineering.vaadinator.produkt.ui.presenter.SubviewCapablePresenter;
import de.akquinet.engineering.vaadinator.produkt.ui.std.view.ProduktChangeViewEx;

public class ProduktChangePresenterImplEx extends ProduktChangePresenterImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProduktChangePresenterImplEx(Map<String, Object> context, ProduktChangeViewEx view, Presenter returnPresenter,
			ProduktService service, boolean adminMode) {
		super(context, view, returnPresenter, service);
		this.view = view;
		this.adminMode = adminMode;
	}

	public ProduktChangePresenterImplEx(Map<String, Object> context, ProduktChangeViewEx view, Presenter returnPresenter,
			SubviewCapablePresenter capablePresenter, ProduktService service, boolean adminMode) {
		super(context, view, returnPresenter, capablePresenter, service);
		this.view = view;
		this.adminMode = adminMode;
	}
	
	private ProduktChangeViewEx view;
	private boolean adminMode;

	@Override
	public void startPresenting() {
		super.startPresenting();
		view.setUnlimitedView(adminMode);
	}

}
