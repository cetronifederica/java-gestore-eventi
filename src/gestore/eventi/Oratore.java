package gestore.eventi;

public class Oratore {

	// attributi
	private String nome, cognome, titolo;

	public Oratore(String nome, String cognome, String titolo) {
		this.cognome = cognome;
		this.nome = nome;
		this.titolo = titolo;
	}

	// getter e setter

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	@Override
	public String toString() {
		return "Nome oratore: " + nome + " " + cognome + "\nTitolo: " + titolo;
	}
}
