package de.akquinet.engineering.vaadinator.produkt.ui.std.presenter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import de.akquinet.engineering.vaadinator.produkt.model.Produkt;
import de.akquinet.engineering.vaadinator.produkt.model.Warenkorb;
import de.akquinet.engineering.vaadinator.produkt.ui.presenter.Presenter;
import de.akquinet.engineering.vaadinator.produkt.ui.std.view.ProduktChangeViewEx;

public class ProduktChangePresenterImplExTest {

	ProduktChangeViewEx view;
	Presenter returnPresenter;
	Warenkorb nutzerWarenkorb;
	ProduktChangePresenterImplEx presenter;

	@Before
	public void setUp() {
		view = mock(ProduktChangeViewEx.class);
		returnPresenter = mock(Presenter.class);
		nutzerWarenkorb = new Warenkorb();
	}

	@Test
	public void testStartPresentingKunde() {
		presenter = new ProduktChangePresenterImplEx(new HashMap<String, Object>(), view, null, null, nutzerWarenkorb,
				false);
		presenter.startPresenting();
		verify(view).initializeUi();
		verify(view).setUnlimitedView(false);
		verify(view, never()).setUnlimitedView(true);
	}

	@Test
	public void testStartPresentingAdmin() {
		presenter = new ProduktChangePresenterImplEx(new HashMap<String, Object>(), view, null, null, nutzerWarenkorb,
				true);
		presenter.startPresenting();
		verify(view).initializeUi();
		verify(view).setUnlimitedView(true);
	}

	@Test
	public void testOnInWarenkorb() {
		Produkt produkt = new Produkt("test", "test-Beschreibung", 12.33, 19);
		presenter = new ProduktChangePresenterImplEx(new HashMap<String, Object>(), view, returnPresenter, null,
				nutzerWarenkorb, false);
		presenter.setProdukt(produkt);
		assertEquals(0, nutzerWarenkorb.getItems().size());
		presenter.onInWarenkorb();
		assertEquals(1, nutzerWarenkorb.getItems().size());
		assertEquals("test", nutzerWarenkorb.getItems().get(0).getBezeichnung());
		verify(view).showInfoMessage("istInWarenkorb", "test", "1");
		verify(returnPresenter).returnToThisPresener(presenter);
	}

}
