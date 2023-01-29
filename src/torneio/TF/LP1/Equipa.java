package torneio.TF.LP1;
/**
 * @author Esc-Engenheiros-sem-curso
 * @version 1.0
 */

public class Equipa {
	
	private String id;
	private String federacao;
	private String nomeEquipa;
	private String continente;
	private int inauguracao;
	private int ranking;
	private boolean mundial;

	public Equipa() {
		
	}
	
	public String GetIdEquipa() {
		return id;
	}
	
	public void SetIdEquipa(String id) {
		this.id = id;
	}
	
	public String GetNomeEquipa() {
		return nomeEquipa;
	}

	public void SetNomeEquipa(String valor) {
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

