package torneio.TF.LP1;

public class Jogo {
	private int Id;
	private Equipa EquipaA;
	private Equipa EquipaB;
	private int GolosA;
	private int GolosB;
	private Evento[] Eventos;
	
	public Jogo(int Id, Equipa EquipaA, Equipa EquipaB, int GolosA, int GolosB) {
		
		this.Id = Id;
		this.EquipaA = EquipaA;
		this.EquipaB = EquipaB;
		this.GolosA = GolosA;
		this.GolosB = GolosB;
		this.Eventos = new Evento[100];
		
		
	}

	public Jogo() {
		super();
	}

	public int GetId() {
		return this.Id;
	}

	public Equipa GetEquipaA() {
		return this.EquipaA;
	}

	public Equipa GetEquipaB() {
		return this.EquipaB;
	}

	public int GetGolosA() {
		return this.GolosA;
	}

	public int GetGolosB() {
		return this.GolosB;
	}
	
	public Evento[] GetEventos() {
		return this.Eventos;
	}
	
	public Boolean AdicionarEvento(TipoEvento tipo, String IdEquipa, String nomeJogador, int minuto) {
		if (IdEquipa.equals(EquipaA.GetIdEquipa()) == false && IdEquipa.equals(EquipaB.GetIdEquipa()) == false) {
			return false;
		}else {
			Equipa equipaEvento;
			if (IdEquipa.equals(EquipaA.GetIdEquipa())) {
				equipaEvento = this.EquipaA;
				if (tipo == TipoEvento.Golo) {
					GolosA +=1;
				}
			}else {
				equipaEvento = this.EquipaB;
				GolosB +=1;
			}
			Evento novo = new Evento(0, tipo, equipaEvento, nomeJogador, minuto);
			this.Eventos[this.ContagemEventos()] = novo;
			return true;
		}
	}
	
	public int ContagemEventos() {
		//obtem a quantidade de eventos registrados
		int contador = 0;
		for(int i = 0; i<this.Eventos.length;i++) {
			if(this.Eventos[i]!=null) {
				contador++;
			}else {
				break;
			}
		}
		return contador;
	}
	
	
}
