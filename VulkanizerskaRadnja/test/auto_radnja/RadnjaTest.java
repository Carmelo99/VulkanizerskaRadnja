package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {

	protected Radnja radnja;
	
	
	@Test
	void testDodajGumu() {
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("renoClio");
		radnja.dodajGumu(a);
		assertEquals(1, radnja.vratiSveGume().size());
		assertEquals(a, radnja.vratiSveGume().get(0));
	}
	
	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class, ()->radnja.dodajGumu(null));
	}
	
	@Test
	void testDodajGumuDuplikat() {
		AutoGuma a1 = new AutoGuma();
		a1.setMarkaModel("renoMegan");
		a1.setPrecnik(20);
		a1.setSirina(200);
		a1.setVisina(50);
		AutoGuma a2 = new AutoGuma();
		a2.setMarkaModel("renoMegan");
		a2.setPrecnik(20);
		a2.setSirina(200);
		a2.setVisina(50);

		radnja.dodajGumu(a1);
		
		Exception e = assertThrows(java.lang.RuntimeException.class,
				() -> radnja.dodajGumu(a2));
		
		assertEquals("Guma vec postoji", e.getMessage());
	}
	
	@Test
	void testDodajGumuViseGuma() {
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("fiatPunto");
		a.setPrecnik(20);
		a.setSirina(200);
		a.setVisina(50);
		
		AutoGuma b = new AutoGuma();
		b.setMarkaModel("fiatPunto");
		b.setPrecnik(20);
		b.setSirina(201);
		b.setVisina(43);

		radnja.dodajGumu(a);
		radnja.dodajGumu(b);
		
		
		assertEquals(2, radnja.vratiSveGume().size());
		assertTrue(radnja.vratiSveGume().contains(a));
		assertTrue(radnja.vratiSveGume().contains(b));
	}

	
	@Test
	void testPronadjiGumu() {
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("fiatPunto");
		
		radnja.dodajGumu(a);
		
		List<AutoGuma> rezultat = radnja.pronadjiGumu("fiatPunto");
		
		assertEquals(1, rezultat.size());
		assertTrue(rezultat.contains(a));
	}
	
	@Test
	void testPronadjiGumuNull() {
		assertEquals(null, radnja.pronadjiGumu(null));
	}
	
	@Test
	void testPronadjiGumuNijePronadjeno() {
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("renoMegan");
		radnja.dodajGumu(a);
		List<AutoGuma> rezultat = radnja.pronadjiGumu("fiatPunto");
		assertEquals(0, rezultat.size());
		assertFalse(rezultat.contains(a));
	}
	
	@Test
	void testPronadjiGumuViseIstih() {
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("fiatPunto");
		a.setPrecnik(20);
		a.setSirina(200);
		a.setVisina(50);
		radnja.dodajGumu(a);
		
		AutoGuma b = new AutoGuma();
		b.setMarkaModel("fiatPunto");
		b.setPrecnik(19);
		b.setSirina(201);
		b.setVisina(51);
		radnja.dodajGumu(b);
		
		List<AutoGuma> rezultat = radnja.pronadjiGumu("fiatPunto");
		
		assertEquals(2, rezultat.size());
		assertTrue(rezultat.contains(a));
		assertTrue(rezultat.contains(b));
		
	}
	
	
	
	
	
	
	

	
	@Test
	void testVratiSveGume() {
		AutoGuma a = new AutoGuma();
		a.setMarkaModel("fiatPunto");

		radnja.dodajGumu(a);
		
		assertEquals(1, radnja.vratiSveGume().size());
		assertTrue(radnja.vratiSveGume().contains(a));
	}

}
