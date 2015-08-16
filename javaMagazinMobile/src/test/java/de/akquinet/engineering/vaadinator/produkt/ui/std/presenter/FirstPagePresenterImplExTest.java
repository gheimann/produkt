package de.akquinet.engineering.vaadinator.produkt.ui.std.presenter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import de.akquinet.engineering.vaadinator.produkt.model.Warenkorb;
import de.akquinet.engineering.vaadinator.produkt.service.WarenkorbService;
import de.akquinet.engineering.vaadinator.produkt.ui.std.view.FirstPageViewEx;
import de.akquinet.engineering.vaadinator.produkt.ui.std.view.WarenkorbChangeViewEx;

public class FirstPagePresenterImplExTest {

	FirstPageViewEx view;
	Warenkorb nutzerWarenkorb;
	FirstPagePresenterImplEx presenter;
	PresenterFactoryEx presenterFactoryEx;
	WarenkorbChangePresenterImplEx warenkorbChangePresenter;
	
	@Before
	public void setUp() {
		view=mock(FirstPageViewEx.class);
		nutzerWarenkorb = new Warenkorb();
		presenterFactoryEx= mock(PresenterFactoryEx.class);
		warenkorbChangePresenter = mock(WarenkorbChangePresenterImplEx.class);
	}
	
	 @Test
	 public void testStartPresentingKunde(){
		 presenter = new FirstPagePresenterImplEx(new HashMap<String, Object>(), view, null, nutzerWarenkorb, false);
		 presenter.startPresenting();
		 verify(view).initializeUi();
		 verify(view).setUnlimitedView(false);
		 verify(view, never()).setUnlimitedView(true);
	 }
	
	 @Test
	 public void testStartPresentingAdmin(){
		 presenter = new FirstPagePresenterImplEx(new HashMap<String, Object>(), view, null, nutzerWarenkorb, true);
		 presenter.startPresenting();
		 verify(view).initializeUi();
		 verify(view).setUnlimitedView(true);
	 }
	
	 @Test
	 public void testonMyWarenkorb(){
		 presenter = new FirstPagePresenterImplEx(new HashMap<String, Object>(), view, presenterFactoryEx, nutzerWarenkorb, true);
		 when(presenterFactoryEx.createWarenkorbChangePresenter(presenter)).thenReturn(warenkorbChangePresenter);	 
		 presenter.onMeinWarenkorb();
		 verify(this.warenkorbChangePresenter).setWarenkorb(nutzerWarenkorb);
		 verify(view).openSubView(warenkorbChangePresenter.getView());
		 presenter.startPresenting();
	 }
}
