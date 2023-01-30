package equipes.TF.LP1;

import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import torneio.TF.LP1.*;

/**
 * @author Esc-Engenheiros-sem-curso
 * @version 1.0
 */
public class Aplicacao {

	public Aplicacao() {
		this.LerFicheiros();		
	}

	/*
	 * Variavies Gerais - Todas as funcoes.
	 */
	Torneio torneio = new Torneio();
	Scanner ler = new Scanner(System.in);
	String pastaFicheiros = "C:\\Users\\guts\\Documents\\LP1\\esc-engenheiros-sem-curso";

	/*
	 * CONTROLO DE ACOES
	 */
	public void Iniciar() {
		System.out.println("");
		System.out.println("                                                                    ___\r\n"
				+ "                                                o__        o__     |   |\\\r\n"
				+ "                                               /|          /\\      |   |X\\\r\n"
				+ "                                               / > o        <\\     |   |XX\\");
		System.out.println("\t\t\t\t _____________________________________________________");
        System.out.println("\t\t\t\t|           APLICACAO DO MUNDIAL DE FUTEBOL           |");
        System.out.println("\t\t\t\t|_____________________________________________________|");
        System.out.println("");
		// this.LerDadosFicheiros();
		this.ApresentarMenuPrincipal();
	}

	// Funcoes menu principal
	public void ApresentarMenuPrincipal() {
		
		do {
			System.out.println(" ______________________");
			System.out.println("|    MENU PRINCIPAL    |");
			System.out.println("|______________________|");
			System.out.println("");
			System.out.println("(Selecione uma opcao)");
	
			System.out.println("1. Equipas");
			System.out.println("2. Torneio");
			System.out.println("3. Historico");
			System.out.println("4. Fechar");
	
			switch (this.ler.nextInt()) {
			case 1:
				// apresentar menu equipa
				this.ApresentarMenuEquipas();
				break;
			case 2:
				// apresentar menu torneio
				this.ApresentarMenuTorneio();
				break;
			case 3:
				this.torneio.Historico();
	
			case 4: {
				// gravo a informacao para ficheiros e sai
				this.GravarFicheiros();
				break;
			}
			default:
				System.out.println("Opcao invalida.");
				this.ApresentarMenuPrincipal();
			}
		}while(this.ler.nextInt()!=4);
	}

	// Funcoes para gerir as equipas
	public void ApresentarMenuEquipas() {
		do {
			System.out.println("");
			System.out.println(" _______________");
			System.out.println("|    EQUIPAS    |");
			System.out.println("|_______________|");
			System.out.println("");
			System.out.println("(Selecione uma opcao)");
	
			System.out.println("1. Listar equipa");
			System.out.println("2. Adicionar equipa");
			System.out.println("3. Editar equipa");
			System.out.println("4. Eliminar equipa");
			System.out.println("0. Menu Principal");
	
			switch (this.ler.nextInt()) {
				case 1:
					this.ListarEquipas();
					break;
				case 2:
					this.AdicionarEquipa();
					break;
				case 3:
					EditarEquipa();
					this.ApresentarMenuEquipas();
					break;
				case 4:
					this.EliminarEquipa();
					break;
				case 5:
					this.ApresentarMenuPrincipal();
					break;
				case 0:
					this.ApresentarMenuPrincipal();
					break;
				default:
					System.out.println("!!!! opcao invalida !!!!");
					this.ApresentarMenuEquipas();
					break;
			}
		} while(this.ler.nextInt()!=0);
	}

	// Funcões para gerir o torneio
	public void ApresentarMenuTorneio() {
		do {
			System.out.println("");
			System.out.println(" _______________");
			System.out.println("|    TORNEIO    |");
			System.out.println("|_______________|");
			System.out.println("");
			System.out.println("(Selecione uma opcao)");
	
			System.out.println("1. Gerar Torneio");
			System.out.println("2. Listar grupo A");
			System.out.println("3. Listar grupo B");
			System.out.println("4. Listar grupo C");
			System.out.println("5. Listar grupo D");
			System.out.println("6. Listar grupo E");
			System.out.println("7. Listar grupo F");
			System.out.println("8. Listar grupo G");
			System.out.println("9. Listar grupo H");
			System.out.println("10. Listar todos grupos");
			System.out.println("0. Menu Principal");
	
			switch (this.ler.nextInt()) {
				case 1:
					if (this.torneio.GerarFaseGrupos() == true) {
						System.out.println("Fase de grupos gerada");
					} else {
						System.out.println("Nao foi possivel gerar a fase de grupos. Deve existir 32 equipas.");
					}
					this.torneio.GerarFaseGrupos();
					this.ApresentarMenuTorneio();
					break;
				case 2:
					this.ListarGrupo("A");
					ApresentarMenuGrupo("A");
					break;
				case 3:
					this.ListarGrupo("B");
					ApresentarMenuGrupo("B");
					break;
				case 4:
					this.ListarGrupo("C");
					ApresentarMenuGrupo("C");
					break;
				case 5:
					this.ListarGrupo("D");
					ApresentarMenuGrupo("D");
					break;
				case 6:
					this.ListarGrupo("E");
					ApresentarMenuGrupo("E");
					break;
				case 7:
					this.ListarGrupo("F");
					ApresentarMenuGrupo("F");
					break;
				case 8:
					this.ListarGrupo("G");
					ApresentarMenuGrupo("G");
					break;
				case 9:
					this.ListarGrupo("H");
					ApresentarMenuGrupo("H");
					break;
				case 10:
					this.ListasTodosGrupos();
					ApresentarMenuTorneio();
					break;
				case 0: ApresentarMenuPrincipal();
					break;
				default:
					System.out.println("!!!! opcao invalida !!!!");
					this.ApresentarMenuPrincipal();
			}
		}while(this.ler.nextInt()!=0);
	}

	// Funcoes para gerir o grupo
	public void ApresentarMenuGrupo(String codigoGrupo) {
		do {
			System.out.println("");
			System.out.println(" ## TORNEIO - GRUPO "+codigoGrupo+" ##");
			System.out.println("(Selecione uma opcao)");
	
			System.out.println("1. Listas Jogos");
			System.out.println("2. Adicionar Evento");		
			System.out.println("0. Menu Principal");
	
			switch (this.ler.nextInt()) {
				case 1:	
					this.ListarJogosGrupo(codigoGrupo);
					this.ApresentarMenuGrupo(codigoGrupo);
					break;
				case 2:
					this.AdicionarEventoJogo(codigoGrupo);
					this.ApresentarMenuGrupo(codigoGrupo);
					break;
				case 3:
					this.ApresentarMenuGrupo(codigoGrupo);
					break;					
				case 0: ApresentarMenuTorneio();
					break;
				default:
					System.out.println("!!!! opcao invalida !!!!");						
			}
		}while(this.ler.nextInt()!=0);
	}

	
	public void GerirJogos() {

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
			System.out.println("0. Menu Principal");
			
			
			switch (this.ler.nextInt()) {
				case 1: //A
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
					System.out.println("Opcao invalida");
					break;
			}
		} while (this.ler.nextInt()!= 8);
	}

	/*
	 * GESTAO DE EQUIPAS
	 */

	public void AdicionarEquipa() {
		// Pede os dados ao utilizador
		Equipa nova = new Equipa();
				
		System.out.println("Indique o nome  da equipa:");
		nova.SetNomeEquipa(ler.next());

		System.out.println("Indique a federacao da equipa:");
		nova.SetFederacao(ler.next());

		System.out.println("Indique o ano de inauguracao:");
		this.VerificarInauguracao(nova);
		

		System.out.println("Indique o ranking da equipa:");
		nova.SetRanking(ler.nextInt());

		System.out.println("Indique vai ao mundial:");
		this.VerificarVaiMundial(nova);
		
		
		// adiciono a equipa na ultima posicao do array~
		this.torneio.InserirEquipa(nova);
		// informo que a equipa foi adicionada
		System.out.println("Equipa adicionada com sucesso!");

		
		// volta ao menu de equipas
		ApresentarMenuEquipas();
	}

	public void EliminarEquipa() {
		System.out.println("Indique o identificador da equipa que pretende eliminar:");
		String idEquipa = ler.next();
		// vou correr todo o array para verificar se existe alguma equipa com aquele
		if (this.torneio.EliminarEquipa(idEquipa) == true) {
			System.out.println("Equipa eliminada com sucesso.");
		} else {
			System.out.println("Equipa nao encontrada");
		}
		ApresentarMenuEquipas();
	}

	public void ListarEquipas() {
		// se o array esta vazio, ou seja, nao existem equipas
		if (this.torneio.ContagemEquipas() == 0) {
			System.out.println("Nao existem equipas registadas.");
		} else {
			System.out.println("\n-------------------------\n"); // o barra n da� uma quebra de linha

			for (int i = 0; i < this.torneio.ObterEquipas().length; i++) {
				// vou correr todas as equipas do array e apresentar informacao. so
				// apresento
				// a
				// equipa no array se estiver preenchida essa posicao do array
				if (this.torneio.ObterEquipas()[i] != null) {
					Equipa equipa = this.torneio.ObterEquipas()[i];
					System.out.println("Equipa " + (equipa.GetIdEquipa()) + "\nNome: " + equipa.GetNomeEquipa()
							+ "\nFederacao: " + equipa.GetFederacao() + "\nAno Inauguracao: "
							+ equipa.GetInaguracao() + "\nRanking: " + equipa.GetRanking() + "\nMundial: "
							+ equipa.GetMundial());
					// adiciono uma quebra de linha por cada equipa
					System.out.println("");
				} else {
					break;
				}
			}
			System.out.println("-------------------------");
		}
		ApresentarMenuEquipas();
	}

	public void EditarEquipa() {
		int opcao;
		String mundial;
		System.out.println("Indique o identificador da equipa que pretende editar:");
		String idEquipa = ler.next();

		// obter da lista de equipas por ID
		Equipa equipaEncontrada = this.torneio.ObterEquipa(idEquipa);

		if (equipaEncontrada != null) {
			do {

				System.out.println("Selecione uma opcao:");
				System.out.println("1. Alterar nome da equipa");
				System.out.println("2. Alterar ano da fundacao");
				System.out.println("3. Alterar Federacao");
				System.out.println("4. Alterar Ranking");
				System.out.println("5. Alterar se esta ou nao no mundial ");
				System.out.println("6. Alterar equipa completa");
				System.out.println("0. Menu Equipas");

				opcao = this.ler.nextInt();
				switch (opcao) {
				case 1:
					System.out.println("Insira o novo nome da equipa");
					equipaEncontrada.SetNomeEquipa(ler.next());
					break;
				case 2:
					this.VerificarInauguracaoEditada(equipaEncontrada);
					break;
				case 3:
					System.out.println("Insira a nova federacao da equipa");
					equipaEncontrada.SetFederacao(ler.next());
					break;
				case 4:
					System.out.println("Insira o novo ranking da equipa");
					equipaEncontrada.SetRanking(ler.nextInt());
					break;
				case 5:
					mundial = ler.next();
					if (mundial.equalsIgnoreCase("sim") || mundial.equalsIgnoreCase("s")) {
					    equipaEncontrada.SetMundial(true);
					    System.out.println("Alterado para sim");
					} else if (mundial.equalsIgnoreCase("nao") || mundial.equalsIgnoreCase("n")) {
					    equipaEncontrada.SetMundial(false);
					    System.out.println("Alterado para nao");
					} else {
					    System.out.println("opcao invalida");
					}

					break;
				case 6:
					System.out.println("Indique o nome da nova equipa:");
					equipaEncontrada.SetNomeEquipa(ler.next());

					System.out.println("Indique a federacao da nova equipa:");
					equipaEncontrada.SetFederacao(ler.next());

					System.out.println("Indique o ano de inauguracao:");
					this.VerificarAnoInaururacaoNovo(equipaEncontrada);
		

					System.out.println("Indique o ranking da equipa:");
					equipaEncontrada.SetRanking(ler.nextInt());

					System.out.println("Indique vai ao mundial (sim, nao):");

					boolean enumero = true;
					while(true){
					    mundial = ler.next();
					    for (int i = 0; i < mundial.length(); i++) {
					        if (!Character.isDigit(mundial.charAt(i))) {
					          enumero = false;
					          break;
					        }
					    }
					    if(enumero || !(mundial.equalsIgnoreCase("sim") || mundial.equalsIgnoreCase("s") || mundial.equalsIgnoreCase("nao") || mundial.equalsIgnoreCase("n"))){
					        System.out.println("Entrada invalida, por favor digite somente 'sim' ou 's' ou 'nao' ou 'n'");
					        enumero = true;
					    }else {
					        break;
					    }
					}
					if (mundial.equalsIgnoreCase("sim") || mundial.equalsIgnoreCase("s")) {
					    equipaEncontrada.SetMundial(true);
					} else {
					    equipaEncontrada.SetMundial(false);
					}
					System.out.println("Equipa editada com sucesso!");

				// volta ao menu de equipas
				case 7:
					ApresentarMenuEquipas();
					break;
				}
			} while (opcao != 0);
		}
	}

	/*
	 * GESTAO DE TORNEIO
	 */
	public void ListarGrupo(String codigo) {
		Grupo grupo = this.torneio.GetGrupo(codigo);
		if (grupo != null) {
			System.out.println("--- GRUPO " + codigo + " ---");

			for (int i = 0; i < grupo.GetEquipas().length; i++) {
				System.out.println(i + ". " + grupo.GetEquipas()[i].GetNomeEquipa() +" - PONTOS :" + grupo.PontosPorEquipa(grupo.GetEquipas()[i].GetIdEquipa()));
			}

		} else {
			System.out.println("Grupo nao existente, deve gerar o torneio.");
		}
	}

	public void ListasTodosGrupos() {

		Grupo[] grupos = this.torneio.GetGrupos();
		for (int i = 0; i < grupos.length; i++) {
			ListarGrupo(grupos[i].GetCodigo());
		}
		ApresentarMenuTorneio();
	}

	public void ListarJogosGrupo(String codigoGrupo) {		
		Jogo[] jogos = this.torneio.GetGrupo(codigoGrupo).GetJogos();
		
		for(int i = 0; i < jogos.length ; i++) {
			Jogo jogo = jogos[i];
			System.out.print(
					"Jogo n." + jogo.GetId()+"\n" +
					jogo.GetEquipaA().GetNomeEquipa() + " [" + jogo.GetGolosA() +" - "+ jogo.GetGolosB()+"] "+ jogo.GetEquipaB().GetNomeEquipa()	+"\n"							
			);
			
			Evento[] eventos = jogo.GetEventos();
			if (jogo.ContagemEventos() == 0) {				
				System.out.print("Jogo sem eventos. \n"	);
			}else {		
				System.out.print("Eventos do jogo: \n"	);
				for(int j = 0; j < eventos.length ; j++) {
					if (eventos[j] != null) {
						Evento evento = eventos[j];
						System.out.print(
								" - " + evento.GetTipo() + " aos " + evento.GetMinuto() +" por " + evento.GetNomeJogador() + " ("	+ evento.GetEquipa().GetNomeEquipa() +")\n"			
						); 	
					}
				}			
			}
			System.out.print("-------------------------\n");		
		}				
	}
	
	public void AdicionarEventoJogo(String codigoGrupo) {
		System.out.println("Indique o número do jogo que pretende inserir o evento:");
		int idJogo = ler.nextInt();
		Jogo jogo = this.torneio.GetGrupo(codigoGrupo).GetJogo(idJogo);
		if (jogo != null) {
			
			
			System.out.println("Indique o tipo de evento:");
			System.out.println("1 - Golo, 2 - Cartoes Amarelos, 3 - Cartoes Vermelhos");
			TipoEvento tipo = null;;
			while(tipo == null) {
				switch(ler.nextInt()) {
				case 1:
					tipo = TipoEvento.Golo;
					break;
				case 2:
					tipo = TipoEvento.CartaoAmarelo;
					break;
				case 3:
					tipo = TipoEvento.CartaoVermelho;
					break;
				default:
					System.out.println("Opcao invalida\n");
					break;
				}
			}
			
			System.out.println("Indique o minuto do evento:\n ");
			int minuto = ler.nextInt();
			
			System.out.println("Indique a equipa:");
			System.out.println("1 - " + jogo.GetEquipaA().GetNomeEquipa()+", 2 - "+jogo.GetEquipaB().GetNomeEquipa() +"\n");
			Equipa equipa = null;
			while(equipa == null) {
				switch(ler.nextInt()) {
				case 1:
					equipa = jogo.GetEquipaA();
					break;
				case 2:
					equipa = jogo.GetEquipaB();
					break;				
				default:
					System.out.println("Opcao invalida\n");
					break;
				}
			}
			
			System.out.println("Indique o nome do jogador:\n ");
			String jogador = ler.next();
					
			jogo.AdicionarEvento(tipo, equipa.GetIdEquipa(), jogador, minuto);
			
		} else {
			System.out.println("Jogo nao encontrado.");
		}
	}
	/*
	 * GESTAO FICHEIRO
	 */

	private void LerFicheiros() {
		// criar uma pasta -->
		// https://www.guj.com.br/t/criando-arquivos-e-diretorios/42487/2
		File file = new File(this.pastaFicheiros);
		if (!file.exists()) {
			file.mkdirs();
		}
		// esta dentro de um try porque vai tentar ler o ficheiro, se der erro salta
		// ate 
		// o catch mais abaixo
		try {
			// 1. Ler o ficheiro equipas que esta na pasta
			Scanner scanner = new Scanner(new FileReader(this.pastaFicheiros + "\\equipas.txt")).useDelimiter("\n");
			while (scanner.hasNext()) {

				// 1.1 Após lido a linha vou dividir o texto pelo separador |
				String[] linhaEquipa = scanner.next().split("\\|");

				// 1.2 Crio uma nova equipa com os dados lidos
				Equipa nova = new Equipa();
				nova.SetIdEquipa(linhaEquipa[0]);
				nova.SetNomeEquipa(linhaEquipa[1]);
				nova.SetInaguracao(Integer.parseInt(linhaEquipa[2]));
				nova.SetFederacao(linhaEquipa[3]);
				nova.SetContinenteEquipa(linhaEquipa[4]);
				nova.SetRanking(Integer.parseInt(linhaEquipa[5]));
				nova.SetMundial(Boolean.parseBoolean(linhaEquipa[6]));

				// 1.3 Adiciono a equipa no array
				this.torneio.InserirEquipa(nova);
			}
		} catch (Exception ex) {
			System.out.println("Ocorreu um erro a ler ficheiro. \n" + ex.getMessage());
		}
	}

	private void GravarFicheiros() {
		try {
			FileWriter caneta = new FileWriter(this.pastaFicheiros +"\\equipas.txt");
			String linha = "";

			if (this.torneio.ContagemEquipas() == 0) {
				caneta.write("");
			} else {
				Equipa[] equipas = this.torneio.ObterEquipas();

				for (int i = 0; i < equipas.length; i++) {
					if (equipas[i] != null) {
						linha = "";
						linha += equipas[i].GetIdEquipa() + "|";
						linha += equipas[i].GetNomeEquipa() + "|";
						linha += equipas[i].GetInaguracao() + "|";
						linha += equipas[i].GetFederacao() + "|";
						linha += equipas[i].GetContinenteEquipa() + "|";
						linha += equipas[i].GetRanking() + "|";
						linha += equipas[i].GetMundial() + "|\n";
						caneta.write(linha);
					}
				}
			}
			caneta.close();
			System.out.println("Ficheiro guardado com sucesso");
		} catch (IOException ex) {
			System.out.println("Ocorreu um erro a gravar. Tente mais tarde.\n" + ex.getMessage());
		}
	}
	
	
	
	/**        ||||||||||||||||||||||||||||||||||||||||||||||||||
	 * 		   |*************FUNCOES DE VALIDACAO **************|
	 * 		   ||||||||||||||||||||||||||||||||||||||||||||||||||
	 */
	private void VerificarInauguracao(Equipa nova) {
		while(true){
			try {
				int ano = Integer.parseInt(ler.next());
				if(ano < 1000 || ano > 9999){
					System.out.println("Entrada invalida, por favor digite somente números de 4 digitos");
				} else {
					nova.SetInaguracao(ano);
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Entrada invalida, por favor digite somente números de 4 digitos");
			}
		}
	}
	
	private void  VerificarInauguracaoEditada(Equipa equipaEncontrada) {
		
		while(true) {
		    System.out.println("Insira o novo ano da inauguracao:");
		    String entradaFundacao = ler.next();
		    try {
		        int ano = Integer.parseInt(entradaFundacao);
		        if(entradaFundacao.length() == 4 && ano > 0) {
		            equipaEncontrada.SetInaguracao(ano);
		            break;
		        }
		        else {
		            System.out.println("Entrada invalida, por favor digite um número inteiro de 4 digitos.");
		        }
		    } catch(NumberFormatException e) {
		        System.out.println("Entrada invalida, por favor digite um número inteiro de 4 digitos.");
		    }
		}
	}
	
	
	private void VerificarVaiMundial(Equipa nova) {
		String mundial;

		boolean eNumero = true;
		while(true){
		    mundial = ler.next();
		    for (int i = 0; i < mundial.length(); i++) {
		        if (!Character.isDigit(mundial.charAt(i))) {
		          eNumero = false;
		          break;
		        }
		    }
		    if(eNumero || !(mundial.equalsIgnoreCase("sim") || mundial.equalsIgnoreCase("s") || mundial.equalsIgnoreCase("nao") || mundial.equalsIgnoreCase("n"))){
		        System.out.println("Entrada invalida, por favor digite somente 'sim' ou 's' ou 'nao' ou 'n'");
		        eNumero = true;
		    }else {
		        break;
		    }
		}
		if (mundial.equalsIgnoreCase("sim") || mundial.equalsIgnoreCase("s")) {
		    nova.SetMundial(true);
		} else {
		    nova.SetMundial(false);
		}
	}
	
	private void VerificarAnoInaururacaoNovo(Equipa equipaEncontrada) {
	    System.out.println("Indique o ano de inauguracao:");
	    int anoInauguracao = ler.nextInt();
	    while (anoInauguracao < 1000 || anoInauguracao > 9999) {
	        System.out.println("Ano invalido. Por favor, insira um ano valido com 4 digitos:");
	        anoInauguracao = ler.nextInt();
	    }
	    equipaEncontrada.SetInaguracao(anoInauguracao);
	}
	
	
}
