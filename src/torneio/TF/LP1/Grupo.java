package torneio.TF.LP1;
/**
 * @author Esc-Engenheiros-sem-curso
 * @version 1.0
 */

public class Grupo {
	
	private String Codigo;
	private Equipa[] Equipas;
	private Jogo[] Jogos;

	public Grupo(String Codigo) {		
		
		this.Codigo = Codigo;
		this.Equipas = new Equipa[4];
		this.Jogos = new Jogo[6];
	}

	public String GetCodigo() {
		return this.Codigo;
	}

	public Equipa[] GetEquipas() {
		return this.Equipas;
	}

	public Jogo[] GetJogos() {
		return this.Jogos;
	}
	
	public Jogo GetJogo(int id) {
		for(int i = 0; i < this.Jogos.length ; i++) {
			if (Jogos[i].GetId() == id) {
				return Jogos[i];
			}														
		}
		return null;
	}
	
	public void AdicionarEquipa (Equipa equipa) {
		this.Equipas[ContagemEquipas()] = equipa;
	}
	
	public void AdicionarJogo(Equipa equipaA, Equipa equipaB, int golosA, int golosB) {
		//crio a classe do jogo
		Jogo jogo = new Jogo(ContagemJogos()+1,equipaA, equipaB, golosA, golosB);
		//adiciono o jogo ao array
		this.Jogos[this.ContagemJogos()] = jogo;
	}
	
	public int ContagemEquipas() {
		int contador = 0;
		for (int i = 0; i < this.Equipas.length; i++ ) {
			if(this.Equipas[i]!=null) {
				contador++;
			} else {
				break;
			}
		}	
		return contador;
	}
		
	public int ContagemJogos() {
		int contador = 0;
		for(int i=0; i < this.Jogos.length;i++) {
			if(this.Jogos[i]!=null) {
				contador++;
			}else {
				break;
			}
		}
		return contador;
	}
	
	public int PontosPorEquipa(String idEquipa) {		
		int pontos = 0 ;
		for(int i = 0 ; i < this.Jogos.length; i++) {
			Jogo jogo = Jogos[i];
			if (jogo.ContagemEventos() > 0) {
				if (jogo.GetEquipaA().GetIdEquipa().equals(idEquipa) || jogo.GetEquipaB().GetIdEquipa().equals(idEquipa)) {
					if (jogo.GetGolosA() == jogo.GetGolosB()) {
						pontos = pontos + 1;
					}else if (jogo.GetEquipaA().GetIdEquipa().equals(idEquipa) && jogo.GetGolosA() > jogo.GetGolosB()) {
						pontos = pontos + 3;
					}
				}
			}
		}
		return pontos;
	}
}
