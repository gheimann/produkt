/*
 * Copyright 2014 akquinet engineering GmbH
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
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atMost;
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
import de.akquinet.engineering.vaadinator.produkt.ui.std.view.ProduktChangeView;

public class ProduktChangePresenterImplTest {

	ProduktChangeView view;
	Presenter returnPres;
	ProduktService service;
	ProduktChangePresenterImpl pres;
	private String bezeichnung;
	private String beschreibung;
	private double preis;
	private int mwstSatz;
	private String bezeichnungNeu;
	private String beschreibungNeu;
	private double preisNeu;
	private int mwstSatzNeu;

	@Before
	public void setUp() {
		view = mock(ProduktChangeView.class);
		when(view.getBezeichnung()).thenReturn("bezeichnung");
		when(view.getBeschreibung()).thenReturn("beschreibung");
		when(view.getMwstSatz()).thenReturn(0);
		when(view.getPreis()).thenReturn(0.0);
		returnPres = mock(Presenter.class);
		service = mock(ProduktService.class);
		pres = new ProduktChangePresenterImpl(new HashMap<String, Object>(), view, returnPres, service);
		bezeichnung = "Kaffeemaschine";
		beschreibung = "leckerster Kaffee";
		preis = 21.5;
		mwstSatz = 7;
		bezeichnungNeu = "Kaffeeautomat";
		beschreibungNeu = "bester Kaffee";
		preisNeu = 55.5;
		mwstSatzNeu = 7;
	}

	@Test
	public void testStartPresenting() {
		pres.setProdukt(new Produkt(bezeichnung, beschreibung,preis, mwstSatz));
		pres.startPresenting();
		verify(view).setObserver(pres);
		verify(view).initializeUi();
		verify(view).setBezeichnung(bezeichnung);
		verify(view).setBeschreibung(beschreibung);
		verify(view).setMwstSatz(mwstSatz);
		verify(view).setPreis(preis);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testOnSave() {
		bezeichnungNeu = "Kaffeeautomat";
		beschreibungNeu = "bester Kaffee";
		preisNeu = 55.5;
		mwstSatzNeu = 7;
		pres.setProdukt(new Produkt(bezeichnung, beschreibung,preis, mwstSatz));
		pres.startPresenting();
		konfiguriertesReturnVerhalten();
		when(view.getBezeichnung()).thenReturn(bezeichnungNeu);
		when(view.getBeschreibung()).thenReturn(beschreibungNeu);
		when(view.getPreis()).thenReturn(preisNeu);
		when(view.getMwstSatz()).thenReturn(mwstSatzNeu);
		when(view.checkAllFieldsValid()).thenReturn(true);
		pres.onSave();
		assertEquals(bezeichnungNeu, pres.getProdukt().getBezeichnung());
		assertEquals(beschreibungNeu, pres.getProdukt().getBeschreibung());
		assertEquals(preisNeu, pres.getProdukt().getPreis());
		assertEquals(mwstSatzNeu, pres.getProdukt().getMwstSatz());
		verify(service).updateExistingProdukt(eq(pres.getProdukt()), anyMap());
		verify(returnPres).returnToThisPresener((Presenter) any());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testOnSaveInvalid() {
		pres.setProdukt(new Produkt(bezeichnung, beschreibung,preis, mwstSatz));
		pres.startPresenting();
		konfiguriertesReturnVerhalten();
		when(view.getBezeichnung()).thenReturn(bezeichnungNeu);
		when(view.getBeschreibung()).thenReturn(beschreibungNeu);
		when(view.getPreis()).thenReturn(33.33);
		when(view.getMwstSatz()).thenReturn(mwstSatzNeu);
		when(view.checkAllFieldsValid()).thenReturn(false);
		pres.onSave();
		assertEquals(bezeichnung, pres.getProdukt().getBezeichnung());
		assertEquals(beschreibung, pres.getProdukt().getBeschreibung());
		assertEquals(preis, pres.getProdukt().getPreis());
		assertEquals(mwstSatz, pres.getProdukt().getMwstSatz());
		verify(service, never()).updateExistingProdukt(eq(pres.getProdukt()), anyMap());
		verify(returnPres, never()).returnToThisPresener((Presenter) any());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testOnCancel() {
		pres.setProdukt(new Produkt(bezeichnung, beschreibung,preis, mwstSatz));
		pres.startPresenting();
		konfiguriertesReturnVerhalten();
		when(view.getBezeichnung()).thenReturn(bezeichnungNeu);
		when(view.getBeschreibung()).thenReturn(beschreibungNeu);
		when(view.getPreis()).thenReturn(33.33);
		when(view.getMwstSatz()).thenReturn(mwstSatzNeu);
		when(view.checkAllFieldsValid()).thenReturn(false);
		pres.onCancel();
		konfiguriertesReturnVerhalten();
		verify(service, never()).updateExistingProdukt(eq(pres.getProdukt()), anyMap());
		verify(returnPres).returnToThisPresener((Presenter) any());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testOnRemove() {
		pres.setProdukt(new Produkt(bezeichnung, beschreibung,preis, mwstSatz));
		pres.startPresenting();
		konfiguriertesReturnVerhalten();
		when(view.getBezeichnung()).thenReturn(bezeichnungNeu);
		when(view.getBeschreibung()).thenReturn(beschreibungNeu);
		when(view.getPreis()).thenReturn(33.33);
		when(view.getMwstSatz()).thenReturn(mwstSatzNeu);
		when(view.checkAllFieldsValid()).thenReturn(false);
		pres.onRemove();
		verify(service, atMost(1)).removeExistingProdukt(eq(pres.getProdukt()), anyMap());
		verify(returnPres).returnToThisPresener((Presenter) any());
	}
	
	private void konfiguriertesReturnVerhalten() {
		when(view.getBezeichnung()).thenReturn(bezeichnung);
		when(view.getBeschreibung()).thenReturn(beschreibung);
		when(view.getMwstSatz()).thenReturn(mwstSatz);
		when(view.getPreis()).thenReturn(preis);
	}

}
