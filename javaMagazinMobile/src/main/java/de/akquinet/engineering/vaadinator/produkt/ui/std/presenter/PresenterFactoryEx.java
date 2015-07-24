package de.akquinet.engineering.vaadinator.produkt.ui.std.presenter;

import java.util.Map;

import de.akquinet.engineering.vaadinator.produkt.model.Warenkorb;
import de.akquinet.engineering.vaadinator.produkt.service.ProduktService;
import de.akquinet.engineering.vaadinator.produkt.service.WarenkorbService;
import de.akquinet.engineering.vaadinator.produkt.ui.presenter.Presenter;
import de.akquinet.engineering.vaadinator.produkt.ui.presenter.SubviewCapablePresenter;
import de.akquinet.engineering.vaadinator.produkt.ui.std.view.ViewFactoryEx;

public class PresenterFactoryEx extends PresenterFactory {

	private Map<String, Object> context;
	private ViewFactoryEx viewFactory;

	public PresenterFactoryEx(Map<String, Object> context, ViewFactoryEx viewFactory, ProduktService produktService,
			WarenkorbService warenkorbService, Warenkorb nutzerWarenkorb) {
		super(context, viewFactory, produktService, warenkorbService);
		this.context = context;
		this.viewFactory = viewFactory;
		this.produktService = produktService;
		this.nutzerWarenkorb = nutzerWarenkorb;
	}

	private ProduktService produktService;
	private Warenkorb nutzerWarenkorb;
	private boolean adminMode = false;

	public boolean isAdminMode() {
		return adminMode;
	}

	public void setAdminMode(boolean adminMode) {
		this.adminMode = adminMode;
	}

	@Override
	public FirstPagePresenter createFirstPagePresenter() {
		return new FirstPagePresenterImplEx(context, viewFactory.createFirstPageView(), this, adminMode);
	}

	@Override
	public ProduktChangePresenterImplEx createProduktChangePresenter(Presenter returnPresenter) {
		return new ProduktChangePresenterImplEx(context, viewFactory.createProduktChangeView(), returnPresenter,
				produktService, nutzerWarenkorb, adminMode);
	}

	@Override
	public ProduktListPresenterImplEx createProduktListPresenter(Presenter returnPresenter,
			SubviewCapablePresenter subviewCapablePresenter) {
		return new ProduktListPresenterImplEx(context, viewFactory.createProduktListView(), this, produktService,
				subviewCapablePresenter, adminMode);
	}

}
