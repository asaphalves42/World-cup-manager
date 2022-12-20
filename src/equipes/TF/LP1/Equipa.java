package equipes.TF.LP1;


public class Equipa {
	
	private String federacao;
	private String nomeEquipa;
	private int inauguracao;
	private int ranking;
	private boolean mundial;

	public Equipa() {

	}
	
	public String GetnomeEquipa() {
		return nomeEquipa;
	}

	public void SetnomeEquipa(String valor) {
		nomeEquipa = valor;
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

