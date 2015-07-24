package de.akquinet.engineering.vaadinator.produkt.ui.std.presenter;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyMapOf;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import de.akquinet.engineering.vaadinator.produkt.model.Produkt;
import de.akquinet.engineering.vaadinator.produkt.service.ProduktService;
import de.akquinet.engineering.vaadinator.produkt.ui.std.view.ProduktListViewEx;

public class ProduktListPresenterImplExTest {

	ProduktListViewEx view;
	ProduktService service;
	ProduktListPresenterImplEx presenter;

	@Before
	public void setUp() {
		view = mock(ProduktListViewEx.class);
		service = mock(ProduktService.class);
		when(service.listAllProdukt(anyMapOf(String.class, Object.class))).thenReturn(
				Arrays.asList(new Produkt("test", "test-Beschreibung", 12.33, 19)));
	}

	@Test
	public void testStartPresentingKunde() {
		presenter = new ProduktListPresenterImplEx(new HashMap<String, Object>(), view, null, service, null, false);
		presenter.startPresenting();
		verify(view).initializeUi();
		verify(view).setUnlimitedView(false);
		verify(view, never()).setUnlimitedView(true);
		verify(view).setOrRefreshData(anyListOf(Produkt.class));
	}

	@Test
	public void testStartPresentingAdmin() {
		presenter = new ProduktListPresenterImplEx(new HashMap<String, Object>(), view, null, service, null, true);
		presenter.startPresenting();
		verify(view).initializeUi();
		verify(view).setUnlimitedView(true);
		verify(view).setOrRefreshData(anyListOf(Produkt.class));
	}

}
