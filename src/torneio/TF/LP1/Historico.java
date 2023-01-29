package torneio.TF.LP1;
/**
 * @author Esc-Engenheiros-sem-curso
 * @version 1.0
 */
public class Historico {

	private int Ano;
	private Equipa Vencedor;
	private Equipa Segundo;
	private Equipa Terceiro;
	private String MelhorMarcador;
	
	public Historico() {
		
	}

	public int getAno() {
		return Ano;
	}

	public void setAno(int ano) {
		Ano = ano;
	}

	public Equipa getVencedor() {
		return Vencedor;
	}

	public void setVencedor(Equipa vencedor) {
		Vencedor = vencedor;
	}

	public String getMelhorMarcador() {
		return MelhorMarcador;
	}

	public void setMelhorMarcador(String melhorMarcador) {
		MelhorMarcador = melhorMarcador;
	}

	public Equipa getSegundo() {
		return Segundo;
	}

	public void setSegundo(Equipa segundo) {
		Segundo = segundo;
	}

	public Equipa getTerceiro() {
		return Terceiro;
	}

	public void setTerceiro(Equipa terceiro) {
		Terceiro = terceiro;
	}
}
