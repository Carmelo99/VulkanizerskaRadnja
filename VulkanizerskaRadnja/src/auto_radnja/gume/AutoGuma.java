package auto_radnja.gume;

/**
 * Predstavlja automobilsku gumu sa svojim karakteristikama.
 * Ima osnovne operacije za postavljanje i vracanje karakteristika gume.
 * 
 * @author Antonije Dimitrijevic
 * @version 0.1
 */
public class AutoGuma {

	/**
	 * Marka i model gume kao String postavljen na null
	 */
	private String markaModel = null;
	
	/**
	 * Precnik gume kao integer postavljen na -1
	 */
	private int precnik = -1;
	
	/**
	 * Sirina gume kao integer postavljen na -1
	 */
	private int sirina = -1;
	
	/**
	 * Visina gume kao integer postavljen na -1
	 */
	private int visina = -1;
	
	/**
	 * Konstruktor koji inicijalizuje objekat
	 */
	public AutoGuma() {
		
	}
	
	/**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednosti za marku i model, precnik, visinu i sirinu gume
	 * 
	 * @param markaModel Marka i model gume kao String
	 * @param precnik Precnik gume kao integer
	 * @param sirina Sirina gume kao integer
	 * @param visina Visina gume kao integer
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
		}
	
	/**
	 * Vraca marku i model gume
	 * 
	 * @return marka i model gume kao String
	 */
	public String getMarkaModel() {
		return markaModel;
		}
	
	/**
	 * Postavlja marku i model gume na novu vrednost
	 * 
	 * @param markaModel marka i model gume kao String
	 * 
	 * @throws java.lang.NullPointerException ako su uneti marka i model null
	 * @throws java.lang.IllegalArgumentException ako uneti marka i model imaju manje od 3 karaktera 
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel==null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length()<3)
			throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
		}
	
	/**
	 * Vraca precnik gume
	 * 
	 * @return precnik gume kao integer
	 */
	public int getPrecnik() {
		return precnik;
		}
	
	/**
	 * Postavlja precnik gume na novu vrednost
	 * 
	 * @param precnik precnik gume kao integer
	 * 
	 * @throws java.lang.IllegalArgumentException ako je precnik manji od 13, ili veci od 22 znaka
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 && precnik > 22)
			throw new IllegalArgumentException("Precnik van opsega");
		this.precnik = precnik;
		}
	
	/**
	 * Vraca sirinu gume
	 * 
	 * @return sirina gume kao integer
	 */
	public int getSirina() {
		return sirina;
	}
	
	/**
	 * Postavlja sirinu gume na novu vrednost
	 * 
	 * @param sirina sirina gume kao integer
	 * 
	 * @throws java.lang.IllegalArgumentException ako je sirina manja od 135, ili veca od 355 znakova
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 && sirina > 355)
			throw new IllegalArgumentException("Sirina van opsega");
		this.sirina = sirina;
		}
	
	/**
	 * Vraca visinu gume
	 * 
	 * @return visina gume kao integer
	 */
	public int getVisina() {
		return visina;
		}
	
	/**
	 * Postavlja visinu gume na novu vrednost
	 * 
	 * @param visina visina gume kao integer
	 * 
	 * @throws java.lang.IllegalArgumentException ako je visina manja od 25, ili veca od 95 znakova
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new IllegalArgumentException("Visina van opsega");
		this.visina = visina;
		}
	
	/**
	 * 
	 * @return Vraca String sa svim podacima o gumi
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina=" + visina + "]";
		}
	
	/**
	 * Poredi dve gume i vraca true ako su iste, a false ako nisu
	 * Gume se porede po marki i modelu, precniku, sirini i visini
	 * 
	 * @return
	 * <ul>
	 * <li>true ako su oba objekta klase guma i imaju iste karakteristike</li>
	 * <li>false u svim ostalim slucajevima</li>
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
			} else if (!markaModel.equals(other.markaModel))
				return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
		}
	
	
	
}
