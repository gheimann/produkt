package de.akquinet.engineering.vaadinator.produkt.ui.std.presenter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import de.akquinet.engineering.vaadinator.produkt.ui.std.view.ProduktChangeViewEx;

public class ProduktChangePresenterImplExTest {

	ProduktChangeViewEx view;
	ProduktChangePresenterImplEx presenter;

	@Before
	public void setUp() {
		view = mock(ProduktChangeViewEx.class);
	}

	@Test
	public void testStartPresentingKunde() {
		presenter = new ProduktChangePresenterImplEx(new HashMap<String, Object>(), view, null, null, false);
		presenter.startPresenting();
		verify(view).initializeUi();
		verify(view).setSaveButtonVisible(false);
		verify(view, never()).setSaveButtonVisible(true);
	}

	@Test
	public void testStartPresentingAdmin() {
		presenter = new ProduktChangePresenterImplEx(new HashMap<String, Object>(), view, null, null, true);
		presenter.startPresenting();
		verify(view).initializeUi();
		verify(view).setSaveButtonVisible(true);
	}

}
