package de.akquinet.engineering.vaadinator.produkt.ui.std.presenter;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import de.akquinet.engineering.vaadinator.produkt.model.Warenkorb;
import de.akquinet.engineering.vaadinator.produkt.ui.std.view.WarenkorbChangeViewEx;

public class WarenkorbChangePrsenterImplEx {

	WarenkorbChangeViewEx view;
	Warenkorb  nutzerWarenkorb;
	
	@Before
	public void setUp()
	{
		view = mock(WarenkorbChangeViewEx.class);
		nutzerWarenkorb = new Warenkorb();
	}
	
	@Test
	public void testLoadFromModul() {
		WarenkorbChangePresenterImplEx warenkorbChangePresenter = new WarenkorbChangePresenterImplEx
				(new HashMap<String, Object>(), view, null, null);
		warenkorbChangePresenter.loadFromModel();
		verify(view).setAnzahlItems(nutzerWarenkorb.getAnzahlItems());
		verify(view).setBruttoSumme(nutzerWarenkorb.getBruttoSumme());
		verify(view).setNettoSumme(nutzerWarenkorb.getNettoSumme());
		verify(view).setMwStSumme(nutzerWarenkorb.getMwStSumme());
		verify(view).setProduktListe(nutzerWarenkorb.getItems());
	}

}
