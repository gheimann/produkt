package de.akquinet.engineering.vaadinator.produkt.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProduktTest {
	
	@Test
	public void testGetPreisNetto(){
		Produkt produkt = new Produkt("test", "test", 528.8, 19);
		assertEquals(444.37, produkt.getPreisNetto(), 0.01);
	}
	
	@Test
	public void testGetMwSt(){
		Produkt produkt = new Produkt("test", "test", 528.8, 19);
		assertEquals(84.43, produkt.getMwSt(), 0.01);
	}

}
