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
	
	public Boolean AdicionarEvento(TipoEvento tipo, String nomeJogador,String IdEquipa, int minuto) {
		if (!IdEquipa.equals(EquipaA.GetIdEquipa()) && IdEquipa.equals(EquipaB.GetIdEquipa())) {
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
	
	private int ContagemEventos() {
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
	
	/*public static void GerirJogosA(Grupo grupo) {
	
		// adiciono os varios jogos do grupo
			
			grupo.AdicionarJogo(grupo.GetEquipas()[0], grupo.GetEquipas()[1], 0, 0); // A vs B
			
			
			grupo.AdicionarJogo(grupo.GetEquipas()[0], grupo.GetEquipas()[1], 0, 0); // A vs C
			
			
			grupo.AdicionarJogo(grupo.GetEquipas()[0], grupo.GetEquipas()[3], 0, 0); // A vs D
			
			
			grupo.AdicionarJogo(grupo.GetEquipas()[1], grupo.GetEquipas()[2], 0, 0); // B vs C
			
			
			grupo.AdicionarJogo(grupo.GetEquipas()[1], grupo.GetEquipas()[3], 0, 0); // B vs D
			
			
			grupo.AdicionarJogo(grupo.GetEquipas()[2], grupo.GetEquipas()[3], 0, 0); // C vs D
			
			
	 
}
*/
	
	/*public static void GerirJogos() {

		int opcao;

		do {
			System.out.println("## GERIR JOGOS ##");
			System.out.println("1. Gerir jogos grupo A");
			System.out.println("2. Gerir jogos grupo B");
			System.out.println("3. Gerir jogos grupo C");
			System.out.println("4. Gerir jogos grupo D");
			System.out.println("5. Gerir jogos grupo E");
			System.out.println("6. Gerir jogos grupo F");
			System.out.println("7. Gerir jogos grupo G");
			System.out.println("8. Gerir jogos grupo H");

			opcao = ler.nextInt();

			switch (opcao) {

			case 1: GerirJogosA();
				break;
			case 2: // B
				break;
			case 3: // C
				break;
			case 4: // D
				break;
			case 5: // E
				break;
			case 6: // F
				break;
			case 7: // G
				break;
			case 8: // H
				break;
			default:
				System.out.println("Opção inválida");
				break;
			}
		} while (opcao != 8);
	}
	
	*/
}
