package de.akquinet.engineering.vaadinator.produkt.ui.std.presenter;

import java.util.Map;

import de.akquinet.engineering.vaadinator.produkt.service.ProduktService;
import de.akquinet.engineering.vaadinator.produkt.ui.std.view.ViewFactoryEx;

public class PresenterFactoryEx extends PresenterFactory {

	private Map<String, Object> context;
	private ViewFactoryEx viewFactory;

	public PresenterFactoryEx(Map<String, Object> context,
			ViewFactoryEx viewFactory, ProduktService produktService) {
		super(context, viewFactory, produktService);
		this.context = context;
		this.viewFactory = viewFactory;
	}
	
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

}
