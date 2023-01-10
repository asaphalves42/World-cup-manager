package torneio.TF.LP1;

import java.util.Random;

public class Torneio {
	
		private Equipa[] equipas;
		private Grupo[] grupos;	
		public Torneio() {
			this.equipas = new Equipa[100];
			this.grupos = new Grupo[8];
		}
		
		/*
		 * GESTÃO DE EQUIPAS - CRUD
		 */
		
		public Equipa[] ObterEquipas() {
			return this.equipas;
		}
		
		public Equipa ObterEquipa(String id) {
			for (int i = 0; i < this.equipas.length; i++) {
				if (this.equipas[i] != null) {
					if (this.equipas[i].GetIdEquipa() == id) {										 
						return this.equipas[i];
					}
				}
			}
			return null;
		}
			
		public void InserirEquipa(Equipa equipa) {
			equipa.SetIdEquipa((this.ContagemEquipas()+1) + "");
			this.equipas[this.ContagemEquipas()] = equipa;
		}
		
		public Boolean AlterarEquipa(Equipa equipa) {
			for (int i = 0; i < this.equipas.length; i++) {
				if (this.equipas[i] != null) {
					if (this.equipas[i].GetIdEquipa() == equipa.GetIdEquipa()) {					
						this.equipas[i] = equipa;
						return true;
					}
				}
			}
			return false;
		}
		
		public Boolean EliminarEquipa(String id) {
			Boolean encontrei = false;
			for (int i = 0; i < this.equipas.length; i++) {
				if (this.equipas[i] != null) {
					if (this.equipas[i].GetIdEquipa().equals(id) || encontrei == true) {
						// encontrei a equipa entao vou colocar o proximo elemento na posicao deste, ou
						// seja, todos as proximos equipas da lista andam uma casa para tr�s					
						this.equipas[i] = this.equipas[i + 1];
						encontrei = true;				
					}
				}
			}
			return encontrei;
		}
		
		public int ContagemEquipas() {
			int contador = 0;
			for (int i = 0; i < this.equipas.length; i++) {
				// vou correr todas as equipas do array e apresentar informacao
				// da
				// equipa no array se estiver preenchida essa posiçao do array
				if (this.equipas[i] != null) {
					contador++;
				} else {
					break;
				}
			}
			return contador;
		}
		
		private int ContagemEquipasTorneio() {
			int contador = 0;
			for (int i = 0; i < this.equipas.length; i++) {
				// vou correr todas as equipas do array e apresentar informacao
				// da
				// equipa no array se estiver preenchida essa posiçao do array
				if (this.equipas[i] != null) {
					if (equipas[i].GetMundial() == true) {
						contador++;
					}
				} else {
					break;
				}
			}
			return contador;
		}
		
		/*
		 * GESTÃO DE TORNEIO
		 */
		
		public Boolean GerarFaseGrupos() {
			// só devo gerar o torneio se tiver 32 equipas registadas
			if (ContagemEquipasTorneio() == 32) 
			{
				
				//vou criar um novo array temporario apenas com as equipas que vão ao mundial
				Equipa[] arrayTemporario = new Equipa[32];
				for(int i = 0; i < this.equipas.length; i++) {
					if (this.equipas[i] != null) {
						if (this.equipas[i].GetMundial() == true) {
							arrayTemporario[i] = this.equipas[i];
						}else {
							break;
						}
					}
				}
				
				// vou baralhar o nosso array de forma aleatoria
				this.BaralharListaEquipas(arrayTemporario);
				
				// Adicionar grupos e colocar de forma sequencial
				// Tem que ser adicionado as condições dos continentes
				Grupo grupoA = new Grupo("A");
				this.grupos[0] = grupoA;
				
				Grupo grupoB = new Grupo("B");
				this.grupos[1] = grupoB;
				
				Grupo grupoC = new Grupo("C");
				this.grupos[2] = grupoC;
				
				Grupo grupoD = new Grupo("D");
				this.grupos[3] = grupoD;
				
				Grupo grupoE = new Grupo("E");
				this.grupos[4] = grupoE;
				
				Grupo grupoF = new Grupo("F");
				this.grupos[5] = grupoF;
				
				Grupo grupoG = new Grupo("G");
				this.grupos[6] = grupoG;
				
				Grupo grupoH = new Grupo("H");
				this.grupos[7] = grupoH;
				
				for(int i = 0 ; i< arrayTemporario.length; i++) {	
					//primeiras quatro equpas vão para grupo A...
					if (i >= 0 && i < 4) {				
						grupoA.AdicionarEquipa(arrayTemporario[i]);
					} else if (i >= 4 && i < 8) {
						grupoB.AdicionarEquipa(arrayTemporario[i]);										
					} else if (i >= 8 && i < 12) {
						grupoC.AdicionarEquipa(arrayTemporario[i]);										
					} else if (i >= 12 && i < 16) {
						grupoD.AdicionarEquipa(arrayTemporario[i]);						
					} else if (i >= 16 && i < 20) {
						grupoE.AdicionarEquipa(arrayTemporario[i]);						
					} else if (i >= 20 && i < 24) {
						grupoF.AdicionarEquipa(arrayTemporario[i]);										
					} else if (i >= 24 && i < 28) {
						grupoG.AdicionarEquipa(arrayTemporario[i]);				
					} else if (i >= 28 && i < 32) {
						grupoH.AdicionarEquipa(arrayTemporario[i]);						
					}
				}
				
				// Gerar os jogos - passo cada um dos grupos que está na lista
				for(int i = 0; i < this.grupos.length; i++) {
					this.GerarJogosGrupo(grupos[i]);
				}
				
				//retorno com indicação de sucesso = true
				return true;
				
			} else {
				
				//retorno indicação que falhou = false
				return false;
			}
		}
		
		public Grupo[] GetGrupos() {
			return this.grupos;
		}
		public Grupo GetGrupo(String codigo) {

			for(int i= 0; i< this.grupos.length; i++) {
				if (this.grupos[i]!=null) {
					if (this.grupos[i].GetCodigo() == codigo) {
						return this.grupos[i];
					}
				}
			}
			return null;
		}
		
		private void GerarJogosGrupo(Grupo grupo) {
			//adiciono os varios jogos do grupo
			// o zero é o resultado - deve ser adicionado numeros aleatorios entre 0 e 4
			// utilizar o Random			
			grupo.AdicionarJogo(grupo.GetEquipas()[0], grupo.GetEquipas()[1], 0 ,0);  //A vs B
			grupo.AdicionarJogo(grupo.GetEquipas()[0], grupo.GetEquipas()[1], 0 ,0);  //A vs C
			grupo.AdicionarJogo(grupo.GetEquipas()[0], grupo.GetEquipas()[3], 0 ,0);  //A vs D
			grupo.AdicionarJogo(grupo.GetEquipas()[1], grupo.GetEquipas()[2], 0 ,0);  //B vs C
			grupo.AdicionarJogo(grupo.GetEquipas()[1], grupo.GetEquipas()[3], 0 ,0);  //B vs D
			grupo.AdicionarJogo(grupo.GetEquipas()[2], grupo.GetEquipas()[3], 0 ,0);  //C vs D	 
		}
			
		//método estático que embaralha os elementos de um vetor de inteiros
		//https://www.devmedia.com.br/embaralhando-o-conteudo-de-vetores-em-java/26382
		private void BaralharListaEquipas(Equipa [] v) {
			Random random = new Random();
			for (int i=0; i < (v.length - 1); i++) {
				//sorteia um índice
				int j = random.nextInt(v.length);
				//troca o conteúdo dos índices i e j do vetor
				Equipa temp = v[i];
				v[i] = v[j];
				v[j] = temp;
			}		
		}
		
		/*
		 * GESTÃO DE HISTORICO
		 */
		public void AdicionarHistorico() {
			
		}
		
	}
}