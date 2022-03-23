package auto_radnja;

import java.util.List;

import auto_radnja.gume.AutoGuma;

/**
 * Predstavlja radnju sa gumama
 * Ima osnovne operacije dodavanja, pronalazenja gume, kao i vracanja svih guma
 * 
 * @author Antony
 * @version 0.5
 */
public interface Radnja {

	/**
	 * Dodaje gumu na stanje
	 * Dodaje gumu na stanje samo ako guma nije null i ako ne postoji na stanju.
	 *
	 * 
	 * @param a guma koju treba dodati na stanje
	 * 
	 * @throws java.lang.NullPointerException ako je guma null
	 * @throws java.lang.RuntimeException ako guma vec postoji na stanju
	 * 
	 */
	void dodajGumu(AutoGuma a);
	
	/**
	 * Pronalazi i vraca listu sa svim gumama na stanju koji zadovoljavaju uslove pretrage.
	 * 
	 * Nije potrebno uneti sve parametre, pretraga se vrsi po marki i modelu gume koji su uneti
	 * i nije null. Mora se uneti tacna marka i model, jer inace pretraga nece pronaci zeljenu 
	 * gumu na stanju. Takodje, pretraga je osetljiva na velika i mala slova.
	 * 
	 * @param markaModel marka i model gume 
	 * @return Lista koja sadrzi gume koje odgovaraju uslovima pretrage
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);
	
	/**
	 * Vraca sve gume sa stanja
	 * 
	 * @return Lista sa svim gumama sa stanja
	 */
	List<AutoGuma> vratiSveGume();
	
	
	
	
}
