package de.akquinet.engineering.vaadinator.produkt.ui.std.presenter;

import java.util.Map;

import de.akquinet.engineering.vaadinator.produkt.service.ProduktService;
import de.akquinet.engineering.vaadinator.produkt.ui.presenter.SubviewCapablePresenter;
import de.akquinet.engineering.vaadinator.produkt.ui.std.view.ProduktListViewEx;

public class ProduktListPresenterImplEx extends ProduktListPresenterImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProduktListPresenterImplEx(Map<String, Object> context, ProduktListViewEx view,
			PresenterFactory presenterFactory, ProduktService service, SubviewCapablePresenter subviewCapablePresenter, boolean adminMode) {
		super(context, view, presenterFactory, service, subviewCapablePresenter);
		this.view = view;
		this.adminMode = adminMode;
	}
	
	private ProduktListViewEx view;
	private boolean adminMode;

	@Override
	public void startPresenting() {
		super.startPresenting();
		view.setAddButtonVisible(adminMode);
	}

}
