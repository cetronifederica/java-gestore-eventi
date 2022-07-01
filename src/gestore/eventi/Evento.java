package gestore.eventi;

import java.time.LocalDate;

public class Evento {

	LocalDate oggi = LocalDate.now();
	// attributi

	private String titolo;
	private LocalDate data;
	private int nPostiPrenotati, nPostiTot;

	// costruttore con eccezioni
	public Evento(String titolo, LocalDate data, int nPostiTot, int nPostiPrenotati)
			throws IllegalArgumentException, NullPointerException {
		if (oggi.isAfter(data)) {
			throw new IllegalArgumentException("Ci dispiace ma la data dell'evento è già passata");
		}
		if (nPostiTot <= 0) {
			throw new NullPointerException("I posti totali del suo evento devono essere numeri positivi");
		}

		this.titolo = titolo;
		this.data = data;
		this.nPostiTot = nPostiTot;
		this.nPostiPrenotati = 0;
	}
}
