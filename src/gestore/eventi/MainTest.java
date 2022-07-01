package gestore.eventi;

import java.util.Scanner;

public class MainTest {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Evento nuovoEvento = null;
		System.out.println("Inserisci un nuovo evento");

		try {

			System.out.println("Inserire il titolo del nuovo evento: ");
			String titolo = scan.nextLine();

			System.out.println("Inserire la data dell'evento: ");
			String data = scan.nextLine();

			System.out.println("Inserire il numero di posti che la sala eventi può ospitare: ");
			int nPostiTotali = Integer.parseInt(scan.nextLine());

			Evento nEvento = new Evento(titolo, data, nPostiTotali);
			System.out.println(nEvento.toString());

		} catch (Exception e) {
			System.out.println("Errore: " + e.getMessage());
		}

		boolean finisci = false;

		do {
			System.out.println("Vuole prenotare o disdire posti: ");
			String scelta = scan.nextLine();

			switch (scelta.toLowerCase()) {
			case "prenotare": {
				System.out.println("Quanti posti vuole prenotare?");
				int prenota = Integer.parseInt(scan.nextLine());

				nuovoEvento.prenota(prenota);
			}
				break;
			case "disdire": {
				System.out.println("Quanti posti vuole disdire?");
				int cancella = Integer.parseInt(scan.nextLine());
				nuovoEvento.disdici(cancella);
			}
				break;
			case "nulla":
				finisci = true;
				break;
			default:
				System.out.println(
						"Parola inserita non valida. Inserire 'prenotare' per prenotare, 'disdire' per disdire o 'nulla' per uscire");
			}
		} while (!finisci);

		scan.close();
	}

}
