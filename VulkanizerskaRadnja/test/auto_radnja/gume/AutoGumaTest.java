package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {

	AutoGuma ag;
	
	@BeforeEach
	void setUp() throws Exception {
		ag = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		ag=null;
	}

	@Test
	void testAutoGuma() {
		ag = new AutoGuma();
		assertNotNull(ag);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		ag = new AutoGuma("skodaFabia",20,200,50);
		
		assertNotNull(ag);
		assertEquals("skodaFabia", ag.getMarkaModel());
		assertEquals(20, ag.getPrecnik());
		assertEquals(200, ag.getSirina());
		assertEquals(50, ag.getVisina());
	}
	

	@Test
	void testSetMarkaModel() {
		ag.setMarkaModel("skodaFabia");
		assertEquals("skodaFabia", ag.getMarkaModel());
	}
	
	@Test
	@DisplayName("Testira ako je uneto null umesto marke i modela")
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, ()->ag.setMarkaModel(null));
	}
	
	@Test
	void testSetMarkaModelKratko() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->ag.setMarkaModel("a"));
	}

	@ParameterizedTest
	@CsvSource ({
		"14",
		"19",
		"20",
	})
	void testSetPrecnik(int precnik) {
		ag.setPrecnik(precnik);
		assertEquals(precnik, ag.getPrecnik());
	}
	
	@Test
	void testSetPrecnikNedozvoljeno() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->ag.setPrecnik(30));
	}

	@ParameterizedTest
	@CsvSource ({
		"200",
		"150",
		"300",
	})
	void testSetSirina(int sirina) {
		ag.setSirina(sirina);
		assertEquals(sirina, ag.getSirina());
	}
	
	@Test
	void testSetSirinaNedozvoljeno() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->ag.setSirina(400));
	}

	@ParameterizedTest
	@CsvSource ({
		"30",
		"55",
		"68",
	})
	void testSetVisina(int visina) {
		ag.setVisina(visina);
		assertEquals(visina, ag.getVisina());
	}
	
	@Test
	void testSetVisinaNedozvoljeno() {
		assertThrows(java.lang.IllegalArgumentException.class, ()->ag.setVisina(100));
	}

	@Test
	void testToString() {
		ag.setMarkaModel("renoClio");
		ag.setPrecnik(20);
		ag.setSirina(200);
		ag.setVisina(50);
		String s = ag.toString();
		assertTrue(s.contains("renoClio"));
		assertTrue(s.contains("20"));
		assertTrue(s.contains("200"));
		assertTrue(s.contains("50"));
	}

	
	
	
	@ParameterizedTest
	@CsvSource({
		"renoClio,20,200,50,renoClio,20,200,50,true",
		"renoClio,20,200,50,renoMegan,20,200,50,false",
		"renoClio,20,200,50,renoClio,19,200,50,false",
		"renoClio,20,200,50,renoClio,20,205,50,false",
		"renoClio,20,200,50,renoClio,20,205,60,false",
		"renoClio,20,200,50,renoMegan,21,215,55,false",
	})
	void testEqualsObject(String markaModel1,int precnik1,int sirina1,int visina1,String markaModel2,int precnik2,int sirina2,int visina2,boolean e) {
		ag.setMarkaModel(markaModel1);
		ag.setPrecnik(precnik1);
		ag.setSirina(sirina1);
		ag.setVisina(visina1);
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel(markaModel2);
		ag2.setPrecnik(precnik2);
		ag2.setSirina(sirina2);
		ag2.setVisina(visina2);
		assertEquals(e, ag.equals(ag2));
	}

	
	
	
}
