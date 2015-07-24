/*
 * Copyright 2015 akquinet engineering GmbH
 *  
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package de.akquinet.engineering.vaadinator.produkt.ui.std.presenter;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import de.akquinet.engineering.vaadinator.produkt.model.Produkt;
import de.akquinet.engineering.vaadinator.produkt.service.ProduktService;
import de.akquinet.engineering.vaadinator.produkt.ui.presenter.Presenter;
import de.akquinet.engineering.vaadinator.produkt.ui.std.view.ProduktAddView;

public class ProduktAddPresenterImplTest {

	ProduktAddView view;
	Presenter returnPres;
	ProduktService service;
	ProduktAddPresenterImpl pres;
	
	private String bezeichnung;
	private String beschreibung;
	private double preis;
	private int mwstSatz;

	@Before
	public void setUp() {
		view = mock(ProduktAddView.class);
		returnPres = mock(Presenter.class);
		service = mock(ProduktService.class);
		pres = new ProduktAddPresenterImpl(new HashMap<String, Object>(), view, returnPres, service);
		bezeichnung = "Kaffeemaschine";
		beschreibung = "leckerster Kaffee";
		preis = 21.5;
		mwstSatz = 7;
		when(view.getBezeichnung()).thenReturn(bezeichnung);
		when(view.getBeschreibung()).thenReturn(beschreibung);
		when(view.getMwstSatz()).thenReturn(mwstSatz);
		when(view.getPreis()).thenReturn(preis);
	}

	@Test
	public void testStartPresenting() {
		pres.setProdukt(new Produkt(bezeichnung, beschreibung,preis, mwstSatz));
		pres.startPresenting();
		verify(view).setObserver(pres);
		verify(view).initializeUi();
		verify(view).setBezeichnung(null);
		verify(view).setBeschreibung("");
		verify(view).setMwstSatz(0);
		verify(view).setPreis(0);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testOnSave() {
		pres.startPresenting();
		assertNullPruefung();
		when(view.checkAllFieldsValid()).thenReturn(true);
		pres.onSave();
		assertEquals(bezeichnung, pres.getProdukt().getBezeichnung());
		assertEquals(beschreibung, pres.getProdukt().getBeschreibung());
		assertEquals(mwstSatz, pres.getProdukt().getMwstSatz());
		assertEquals(preis, pres.getProdukt().getPreis());
		verify(service).addNewProdukt(eq(pres.getProdukt()), anyMap());
		verify(returnPres).returnToThisPresener((Presenter) any());
	}


	@SuppressWarnings("unchecked")
	@Test
	public void testOnSaveInvalid() {
		pres.startPresenting();
		assertNullPruefung();
		when(view.checkAllFieldsValid()).thenReturn(false);
		pres.onSave();
		assertNullPruefung();
		verify(service, never()).addNewProdukt(eq(pres.getProdukt()), anyMap());
		verify(returnPres, never()).returnToThisPresener((Presenter) any());
	}


	@SuppressWarnings("unchecked")
	@Test
	public void testOnCancel() {
		pres.startPresenting();
		assertNullPruefung();
		when(view.checkAllFieldsValid()).thenReturn(true);
		pres.onCancel();
		assertNullPruefung();
		verify(service, never()).addNewProdukt(eq(pres.getProdukt()), anyMap());
		verify(returnPres).returnToThisPresener((Presenter) any());
	}

	private void assertNullPruefung() {
		assertNull(pres.getProdukt().getBezeichnung());
		assertEquals("", pres.getProdukt().getBeschreibung());
		assertEquals(0, pres.getProdukt().getMwstSatz());
		assertEquals(0.0, pres.getProdukt().getPreis());
	}
}
