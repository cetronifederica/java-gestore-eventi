package gestore.eventi;

import java.time.LocalDate;

public class Conferenza extends Evento {

	// attributi
	private String argomento;
	private Oratore oratore;

	public Conferenza(String titolo, LocalDate data, int nPostiTot, String argomento, Oratore nuovoOratore)
			throws NullPointerException, IllegalArgumentException {
		super(titolo, data, nPostiTot);
		this.argomento = argomento;
		this.oratore = oratore;

	}

	// getter e setter
	public String getArgomento() {
		return argomento;
	}

	public void setArgomento(String argomento) {
		this.argomento = argomento;
	}

	public String getOratore() {
		return getOratore();
	}

	public void setOratore(Oratore oratore) {
		this.oratore = oratore;
	}

	@Override
	public String toString() {
		return super.toString() + "\nArgomento: " + argomento + "\n" + oratore.toString();
	}

}
