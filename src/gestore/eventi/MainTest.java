package gestore.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Evento nuovoEvento = null;
		boolean continua = true;
		System.out.println("Inserisci un nuovo evento");

		do {
			System.out.println("Inserisci il nome dell'evento: ");
			String nomeEvento = scan.nextLine();
			System.out.println("Inserisci la data dell'evento: ");
			System.out.println("Giorno: ");
			int giornoEvento = scan.nextInt();
			System.out.println("Mese: ");
			int meseEvento = scan.nextInt();
			System.out.println("Anno: ");
			int annoEvento = scan.nextInt();

			LocalDate dataEvento = LocalDate.of(annoEvento, meseEvento, giornoEvento);

			System.out.print("Inserisci il numero di posti totali: ");
			int nPostiTotInput = scan.nextInt();

			try {
				nuovoEvento = new Evento(nomeEvento, dataEvento, nPostiTotInput);
				continua = false;

			} catch (NullPointerException npe) {
				System.out.println("Errore nella creazione dell'evento: " + npe.getMessage());

			} catch (IllegalArgumentException iae) {
				System.out.println("Errore nella creazione dell'evento: " + iae.getMessage());
			} catch (Exception e) {
				System.out.println("Errore: " + e.getMessage());
			}
		} while (continua);

		do {
			System.out.println("Vuoi prenotare o disdire dei posti per questo evento?");
			System.out.println("Digita 1 se vuoi prenotare, 2 se vuoi disdire, 0 (zero) se vuoi uscire");
			String sceltaUtente = scan.nextLine();

			try {
				switch (sceltaUtente) {
				case "1":
					System.out.println("Quanti posti vuoi prenotare?");
					int nPostiDaPrenot = Integer.parseInt(scan.nextLine());

					nuovoEvento.prenota(nPostiDaPrenot);

					System.out.println("Hai effettuato " + nPostiDaPrenot + " prenotazioni");
					System.out.println("Il totale di posti prenotati é ora a: " + nuovoEvento.getnPostiPrenotati());

					continua = true;

					break;

				case "2":
					System.out.println("Quanti posti vuoi disdire?");
					int nPostiDaDisdire = Integer.parseInt(scan.nextLine());

					nuovoEvento.disdici(nPostiDaDisdire);

					System.out.println("Hai effettuato " + nPostiDaDisdire + " disdette");
					System.out.println("Il totale di posti prenotati é ora a: " + nuovoEvento.getnPostiPrenotati());

					continua = true;

					break;

				case "0":
					continua = false;
					break;

				default:
					continua = true;

				}
			} catch (IllegalArgumentException iae) {
				System.out.println("Errore: " + iae.getMessage());
			} catch (Exception e) {
				System.out.println("Errore, riprovare!");
			}

		} while (continua);

		System.out.println("I posti prenotati sono: " + nuovoEvento.getnPostiPrenotati());
		int postiDisponibili = nuovoEvento.getnPostiTot() - nuovoEvento.getnPostiPrenotati();
		System.out.println("I posti disponinbili sono: " + postiDisponibili);

		scan.close();
	}

}
