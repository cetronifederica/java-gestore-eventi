package gestore.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	private static final DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	// attributi

	private String titolo;
	private LocalDate data;
	private int nPostiPrenotati = 0;
	private int nPostiTot;
	LocalDate oggi = LocalDate.now();

	// costruttore con eccezioni
	public Evento(String titolo, LocalDate data, int nPostiTot) throws NullPointerException, IllegalArgumentException {
		hasValidNPostiTot(nPostiTot);
		hasValidData(data);

		this.titolo = titolo;
		this.data = data;
		this.nPostiTot = nPostiTot;
	}

	// getter e setter

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) throws IllegalArgumentException, NullPointerException {
		this.data = data;
	}

	public int getnPostiPrenotati() {
		return nPostiPrenotati;
	}

	public int getnPostiTot() {
		return nPostiTot;
	}

	// metodi

	// controllo il numero di posti totali
	private void hasValidNPostiTot(int nPostiTot) throws IllegalArgumentException {

		if (nPostiTot <= 0) {
			throw new IllegalArgumentException("Il numero di persone non può avere un numero nullo o negativo");
		}
	}

	// controllo data
	private void hasValidData(LocalDate data) throws NullPointerException, IllegalArgumentException {

		if (data == null) {
			throw new NullPointerException("La data non può essere nulla");
		}
		if (oggi.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("La data dell'evento non può essere precedente alla data di oggi");
		}
	}

	public int prenota(int nPosti) throws Exception {
		try {
			hasValidData(this.data);
		} catch (Exception e) {
			throw new Exception("Non è possibile prenotare posti per un evento già passato");
		}

		if ((nPostiPrenotati + nPosti) > nPostiTot) {
			throw new IllegalArgumentException("Non ci sono posti disponibili.");
		} else if ((nPostiPrenotati += nPosti) < nPostiTot) {

			System.out.println("Il numero di posti richiesti è stato prenotato.");
		}
		return nPostiPrenotati++;

	}

	public int disdici(int nPosti) throws Exception {
		try {
			hasValidData(this.data);
		} catch (Exception e) {
			throw new Exception("Non è possibile disdire posti in un evento già passato");
		}

		if (nPostiPrenotati < nPosti) {
			throw new Exception("Non ci sono posti prenotati.");
		} else {
			System.out.println("I posti inseriti sono stati disdetti.");
		}
		return nPostiPrenotati--;

	}

	@Override
	public String toString() {
		return "L'evento " + titolo + " organizzato in data " + dataFormatter.format(data);
	}

}
