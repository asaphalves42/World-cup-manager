package equipes.TF.LP1;

import java.util.Random;

public class Equipa {
	
	private int id;
	private String federacao;
	private String nomeEquipa;
	private String continente;
	private int inauguracao;
	private int ranking;
	private boolean mundial;

	public Equipa() {
		Random gerador = new Random();
		this.id = gerador.nextInt(100000, 900000);
	}
	
	public int GetIdEquipa() {
		return id;
	}
	
	public String GetnomeEquipa() {
		return nomeEquipa;
	}

	public void SetnomeEquipa(String valor) {
		nomeEquipa = valor;
	}
	
	public String GetContinenteEquipa() {
		return continente;
	}

	public void SetContinenteEquipa(String valor) {
		continente = valor;
	}

	public String GetFederacao() {
		return federacao;
	}

	public void SetFederacao(String valor) {
		federacao = valor;
	}

	public int GetInaguracao() {
		return inauguracao;
	}

	public void SetInaguracao(int valor) {
		inauguracao = valor;
	}

	public int GetRanking() {
		return ranking;
	}

	public void SetRanking(int valor) {
		ranking = valor;
	}

	public boolean GetMundial() {
		return mundial;
	}

	public void SetMundial(boolean valor) {
		mundial = valor;
	}

}

