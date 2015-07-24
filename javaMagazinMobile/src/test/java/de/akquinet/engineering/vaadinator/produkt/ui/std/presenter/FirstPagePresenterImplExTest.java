package de.akquinet.engineering.vaadinator.produkt.ui.std.presenter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import de.akquinet.engineering.vaadinator.produkt.model.Warenkorb;
import de.akquinet.engineering.vaadinator.produkt.ui.std.view.FirstPageViewEx;

public class FirstPagePresenterImplExTest {

	FirstPageViewEx view;
	Warenkorb nutzerWarenkorb;
	FirstPagePresenterImplEx presenter;
	
	@Before
	public void setUp() {
		view=mock(FirstPageViewEx.class);
		nutzerWarenkorb = new Warenkorb();
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
	
}
