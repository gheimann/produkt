package de.akquinet.engineering.vaadinator.produkt.ui.std.presenter;

import java.util.Map;

import de.akquinet.engineering.vaadinator.produkt.ui.std.view.FirstPageViewEx;

public class FirstPagePresenterImplEx extends FirstPagePresenterImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FirstPagePresenterImplEx(Map<String, Object> context, FirstPageViewEx view, PresenterFactory presenterFactory,
			boolean adminMode) {
		super(context, view, presenterFactory);
		this.view = view;
		this.adminMode = adminMode;
	}
	
	private FirstPageViewEx view;
	private boolean adminMode;

	@Override
	public void startPresenting() {
		super.startPresenting();
		view.setUnlimitedView(adminMode);
	}

}
