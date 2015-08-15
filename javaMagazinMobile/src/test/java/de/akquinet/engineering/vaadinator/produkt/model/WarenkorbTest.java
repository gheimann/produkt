package de.akquinet.engineering.vaadinator.produkt.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class WarenkorbTest {
	
	private Warenkorb warenkorb;

	@Before
	public void setUp()
	{
		warenkorb = new Warenkorb();
		Produkt produkt = new Produkt("test", "test", 528.80, 19);
		warenkorb.addItem(new WarenkorbItem(produkt));
		produkt = new Produkt("test", "test", 31.65, 7);
		warenkorb.addItem(new WarenkorbItem(produkt));
	}
	
	@Test
	public void testGetNettoSumme()
	{
		assertEquals(473.94, warenkorb.getNettoSumme(), 0.01);
	}
	
	@Test
	public void testGetBruttoSumme()
	{
		assertEquals(560.45, warenkorb.getBruttoSumme(), 0.01);
	}
	
	@Test
	public void testGetMwstSumme()
	{
		assertEquals(86.51, warenkorb.getMwStSumme(), 0.01);
	}

}
