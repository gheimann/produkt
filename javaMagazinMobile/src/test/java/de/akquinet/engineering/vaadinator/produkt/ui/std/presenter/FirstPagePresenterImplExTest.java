package de.akquinet.engineering.vaadinator.produkt.ui.std.presenter;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import de.akquinet.engineering.vaadinator.produkt.ui.std.view.FirstPageViewEx;

public class FirstPagePresenterImplExTest {

	FirstPageViewEx view;
	FirstPagePresenterImplEx presenter;
	
	@Before
	public void setUp() {
		view=mock(FirstPageViewEx.class);
	}
	
	 @Test
	 public void testStartPresentingKunde(){
		 presenter = new FirstPagePresenterImplEx(new HashMap<String, Object>(), view, null, false);
		 presenter.startPresenting();
		 verify(view).initializeUi();
		 verify(view).setAddButtonVisible(false);
		 verify(view, never()).setAddButtonVisible(true);
	 }
	
	 @Test
	 public void testStartPresentingAdmin(){
		 presenter = new FirstPagePresenterImplEx(new HashMap<String, Object>(), view, null, true);
		 presenter.startPresenting();
		 verify(view).initializeUi();
		 verify(view).setAddButtonVisible(true);
	 }
	
}
