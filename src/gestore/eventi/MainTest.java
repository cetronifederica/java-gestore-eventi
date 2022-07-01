package gestore.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);

		Conferenza nuovaConf = null;
		Evento nuovoEvento = null;
		String eventoConferenza = "";
		Oratore nuovoOratore = null;
		boolean continua = true;

		do {
			System.out.println("Crea nuovo evento: ");
			System.out.print("Inserisci il nome dell'evento: ");
			String nomeInput = scan.nextLine();

			System.out.print("Inserisci la data dell'evento: \nGiorno: ");
			int giornoEvento = Integer.parseInt(scan.nextLine());

			System.out.print("Mese: ");
			int meseEvento = Integer.parseInt(scan.nextLine());

			System.out.print("Anno: ");
			int annoEvento = Integer.parseInt(scan.nextLine());

			LocalDate dataEvento = LocalDate.of(annoEvento, meseEvento, giornoEvento);

			System.out.print("Inserisci il numero di posti totali: ");
			int numeroPostiTotaliInput = Integer.parseInt(scan.nextLine());

			System.out.println("É un evento generico o una conferenza?");
			System.out.println("(1)Evento \n(2)Conferenza");
			eventoConferenza = scan.nextLine();

			if (eventoConferenza.equalsIgnoreCase("1")) {
				try {

					nuovoEvento = new Evento(nomeInput, dataEvento, numeroPostiTotaliInput);
					continua = false;

				} catch (NullPointerException npe) {
					System.out.println("Errore nella creazione dell'evento: " + npe.getMessage());

				} catch (IllegalArgumentException iae) {
					System.out.println("Errore nella creazione dell'evento: " + iae.getMessage());
				}

			} else if (eventoConferenza.equalsIgnoreCase("2")) {

				System.out.print("Inserisci l'argomento: ");
				String argomento = scan.nextLine();
				System.out.println("Inserisci l'oratore");
				System.out.print("Nome: ");
				String nomeOratore = scan.nextLine();
				System.out.print("Cognome: ");
				String cognomeOratore = scan.nextLine();
				System.out.println("Titolo di studio: ");
				String titoloOratore = scan.nextLine();

				try {
					nuovoOratore = new Oratore(nomeOratore, cognomeOratore, titoloOratore);
				} catch (NullPointerException npe) {
					System.out.println("Errore: ");
				}

				try {
					nuovaConf = new Conferenza(nomeInput, dataEvento, numeroPostiTotaliInput, argomento, nuovoOratore);
					continua = false;
				} catch (NullPointerException npe) {
					System.out.println("Errore nella creazione dell'evento: " + npe.getMessage());

				} catch (IllegalArgumentException iae) {
					System.out.println("Errore nella creazione dell'evento: " + iae.getMessage());
				}

			} else {

				System.out.println("Selezione non valida");

			}
		} while (continua);

		if (eventoConferenza.equalsIgnoreCase("1")) {
			do {

				System.out.println(
						"Premere \n(1)per fare una prenotazione \n(2)per disdire una prenotazione \n(3)uscire");
				String sceltaUtente = scan.nextLine();

				try {
					switch (sceltaUtente) {

					case "1":
						System.out.println("Quanti posti vuoi prenotare?");
						int postiPrenot = Integer.parseInt(scan.nextLine());

						for (int i = 0; i < postiPrenot; i++) {
							nuovoEvento.prenota(i);
						}

						System.out.println("Hai effettuato " + postiPrenot + " prenotazioni");
						System.out.println("Il totale di posti prenotati é ora a: " + nuovoEvento.getnPostiPrenotati());

						continua = true;

						break;
					case "2":
						System.out.println("Quanti posti vuoi disdire?");
						int postiDaDisdire = Integer.parseInt(scan.nextLine());

						for (int i = 1; i <= postiDaDisdire; i++) {
							nuovoEvento.disdici(i);
						}
						System.out.println("Hai effettuato " + postiDaDisdire + " disdette");
						System.out.println("Il totale di posti prenotati é ora a: " + nuovoEvento.getnPostiPrenotati());

						continua = true;

						break;

					case "3":
						continua = false;
						break;

					default:
						System.out.println("Inserimento non valido");
						continua = true;
					}

				} catch (IllegalArgumentException iae) {
					System.out.println("Impossibile effettuare l'azione: " + iae.getMessage());
				}

			} while (continua);

			System.out.println(nuovoEvento.toString());
			System.out.println("I posti prenotati sono: " + nuovoEvento.getnPostiPrenotati());
			int postiDisponibili = nuovoEvento.getnPostiTot() - nuovoEvento.getnPostiPrenotati();
			System.out.println("I posti disponinbili sono: " + postiDisponibili);

		} else if (eventoConferenza.equalsIgnoreCase("2")) {
			do {

				System.out.println(
						"Premere \n(1)per fare una prenotazione \n(2)per disdire una prenotazione \n(3)uscire");
				String sceltaUtente = scan.nextLine();

				try {
					switch (sceltaUtente) {

					case "1":
						System.out.println("Quanti posti vuoi prenotare?");
						int postiDaPrenotare = Integer.parseInt(scan.nextLine());

						for (int i = 0; i < postiDaPrenotare; i++) {
							nuovaConf.prenota(i);
						}

						System.out.println("Hai effettuato " + postiDaPrenotare + " prenotazioni");
						System.out.println("Il totale di posti prenotati é ora a: " + nuovaConf.getnPostiPrenotati());

						continua = true;

						break;
					case "2":
						System.out.println("Quanti posti vuoi disdire?");
						int postiDaDisdire = Integer.parseInt(scan.nextLine());

						for (int i = 1; i <= postiDaDisdire; i++) {
							nuovaConf.disdici(i);
						}
						System.out.println("Hai effettuato " + postiDaDisdire + " disdette");
						System.out.println("Il totale di posti prenotati é ora a: " + nuovaConf.getnPostiPrenotati());

						continua = true;

						break;

					case "3":
						continua = false;
						break;

					default:
						System.out.println("Inserimento non valido");
						continua = true;
					}

				} catch (IllegalArgumentException iae) {
					System.out.println("Impossibile effettuare l'azione: " + iae.getMessage());
				}

			} while (continua);

			System.out.println(nuovaConf.toString());
			System.out.println("I posti prenotati sono: " + nuovaConf.getnPostiPrenotati());
			int postiDisponibili = nuovaConf.getnPostiTot() - nuovaConf.getnPostiPrenotati();
			System.out.println("I posti disponinbili sono: " + postiDisponibili);

		}
		scan.close();

	}
}
