package gestore.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	private static final DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate oggi = LocalDate.now();
	// attributi

	private String titolo, data;

	private int nPostiPrenotati = 0;
	private int nPostiTot;
	LocalDate dataFromString;

	// costruttore con eccezioni
	public Evento(String titolo, String data, int nPostiTot) throws IllegalArgumentException, NullPointerException {
		boolean parametriValidi = true;
		String eMessage = "I dati inseriti non sono validi";

		try {
			hasValidNPostiTot(nPostiTot);
		} catch (Exception e) {
			parametriValidi = false;
			eMessage += "\n" + e.getMessage();
		}

		try {
			hasValidData(data);
		} catch (Exception e) {
			parametriValidi = false;
			eMessage += "\n" + e.getMessage();
		}

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

	public String getData() {
		return data;
	}

	public void setData(String data) throws IllegalArgumentException, NullPointerException {
		this.data = data;
	}

	public int getnPostiPrenotati() {
		return nPostiPrenotati;
	}

	public int getnPostiTot() {
		return nPostiTot;
	}

	// metodi

	private void hasValidNPostiTot(int nPostiTot) throws NullPointerException {

		if (nPostiTot <= 0)
			throw new NullPointerException("Il numero di persone non può avere un numero nullo o negativo");
	}

	private void hasValidData(String data) throws Exception {

		dataFromString = LocalDate.parse(data, dataFormatter);

		if (dataFromString.isAfter(LocalDate.now()))
			throw new Exception("La data dell'evento non può essere precedente alla data di oggi");
	}

	public void prenota(int nPosti) throws NullPointerException, IllegalArgumentException {
		try {
			hasValidData(this.data);
		} catch (Exception e) {
			throw new NullPointerException("Non è possibile prenotare posti per un evento già passato");
		}

		if ((nPostiPrenotati + nPosti) > nPostiTot) {
			throw new IllegalArgumentException("Non ci sono posti disponibili.");
		} else {
			nPostiPrenotati += nPosti;
			System.out.println("Il numero di posti richiesti è stato prenotato.");
		}

	}

	public void disdici(int nPosti) throws NullPointerException, IllegalArgumentException {
		try {
			hasValidData(this.data);
		} catch (Exception e) {
			throw new NullPointerException("Non è possibile disdire posti in un evento già passato");
		}

		if (nPostiPrenotati < nPosti) {
			throw new IllegalArgumentException("Non ci sono posti prenotati.");
		} else {
			nPostiPrenotati -= nPosti;
			System.out.println("I posti inseriti sono stati disdetti.");
		}

	}

	@Override
	public String toString() {
		return "L'evento " + titolo + " organizzato in data " + data;
	}

}
