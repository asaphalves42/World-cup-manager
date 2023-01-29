package torneio.TF.LP1;

public class Evento {
	private int Id;
	private TipoEvento Tipo;
	private String NomeJogador;
	private Equipa Equipa;
	private int Minuto;
	
	public Evento(int Id, TipoEvento Tipo, Equipa Equipa, String NomeJogador, int Minuto) {
		
		this.Id = Id;
		this.Tipo = Tipo;
		this.NomeJogador = NomeJogador;
		this.Equipa = Equipa;
		this.Minuto = Minuto;
	}

	public int GetId() {
		return this.Id;
	}

	public TipoEvento GetTipo() {
		return this.Tipo;
	}

	public String GetNomeJogador() {
		return this.NomeJogador;
	}

	public Equipa GetEquipa() {
		return this.Equipa;
	}

	public int GetMinuto() {
		return this.Minuto;
	}
	
}
