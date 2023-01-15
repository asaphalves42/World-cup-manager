package equipes.TF.LP1;

import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import torneio.TF.LP1.*;

public class Aplicacao {

	public Aplicacao() {
		this.LerFicheiros();
	}

	/*
	 * Variavies Gerais - Todas as funcões.
	 */
	Torneio torneio = new Torneio();
	Scanner ler = new Scanner(System.in);
	String pastaFicheiros = "C:\\Users\\asaph\\Desktop\\testeLP1";

	/*
	 * CONTROLO DE AÇÕES
	 */
	public void Iniciar() {
		System.out.println(" -<<<< APLICAÇÃO DO MUNDIAL >>>>-");
		// this.LerDadosFicheiros();
		this.ApresentarMenuPrincipal();
	}

	// Fun��es menu principal
	public void ApresentarMenuPrincipal() {
		System.out.println("");
		System.out.println(" ## MENU PRINCIPAL ##");
		System.out.println("(Selecione uma opção)");

		System.out.println("1. Equipas");
		System.out.println("2. Torneio");
		System.out.println("3. Fechar");

		switch (this.ler.nextInt()) {
		case 1:
			// apresentar menu equipa
			this.ApresentarMenuEquipas();
			break;
		case 2:
			// apresentar menu torneio
			this.ApresentarMenuTorneio();
			break;
		case 3: {
			// gravo a informa��o para ficheiros e sai
			this.GravarFicheiros();
			break;
		}
		default:
			System.out.println("Opçãoo inválida.");
			this.ApresentarMenuPrincipal();
		}

	}

	// Fun��es para gerir as equipas
	public void ApresentarMenuEquipas() {
		System.out.println("");
		System.out.println(" ## EQUIPAS ##");
		System.out.println("(Selecione uma opção)");

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
				System.out.println("!!!! Opção inválida !!!!");
				this.ApresentarMenuEquipas();
				break;
		}
	}

	// Funções para gerir o torneio
	public void ApresentarMenuTorneio() {
		System.out.println("");
		System.out.println(" ## TORNEIO ##");
		System.out.println("(Selecione uma opção)");

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
				System.out.println("Não foi possivel gerar a fase de grupos. Deve existir 32 equipas.");
			}
			this.torneio.GerarFaseGrupos();
			this.ApresentarMenuTorneio();
			break;
		case 2:
			this.ListarGrupo("A");
			ApresentarMenuTorneio();
			break;
		case 3:
			this.ListarGrupo("B");
			ApresentarMenuTorneio();
			break;
		case 4:
			this.ListarGrupo("C");
			ApresentarMenuTorneio();
			break;
		case 5:
			this.ListarGrupo("D");
			ApresentarMenuTorneio();
			break;
		case 6:
			this.ListarGrupo("E");
			ApresentarMenuTorneio();
			break;
		case 7:
			this.ListarGrupo("F");
			ApresentarMenuTorneio();
			break;
		case 8:
			this.ListarGrupo("G");
			ApresentarMenuTorneio();
			break;
		case 9:
			this.ListarGrupo("H");
			ApresentarMenuTorneio();
			break;
		case 10:
			this.ListasTodosGrupos();
			ApresentarMenuTorneio();
			break;
		default:
			System.out.println("!!!! Opção inválida !!!!");
			this.ApresentarMenuEquipas();
		}
	}

	/*
	 * GEST�O DE EQUIPAS
	 */

	public void AdicionarEquipa() {
		// Pe�o os dados ao utilizador
		Equipa nova = new Equipa();

		System.out.println("Indique o nome  da equipa:");
		nova.SetNomeEquipa(ler.next());

		System.out.println("Indique a federação da equipa:");
		nova.SetFederacao(ler.next());

		System.out.println("Indique o ano de inauguração:");
		nova.SetInaguracao(ler.nextInt());

		System.out.println("Indique o ranking da equipa:");
		nova.SetRanking(ler.nextInt());

		System.out.println("Indique vai ao mundial:");
		String mundial = ler.next();

		if (mundial.equals("sim") || mundial.equals(("s"))) {
			nova.SetMundial(true);
		} else {
			nova.SetMundial(false);
		}
		// adiciono a equipa na ultima posi��o do array~
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
			System.out.println("Equipa não encontrada");
		}
		ApresentarMenuEquipas();
	}

	public void ListarEquipas() {
		// se o array esta� vazio, ou seja, n�o existem equipas
		if (this.torneio.ContagemEquipas() == 0) {
			System.out.println("Não existem equipas registadas.");
		} else {
			System.out.println("\n-------------------------\n"); // o barra n da� uma quebra de linha

			for (int i = 0; i < this.torneio.ObterEquipas().length; i++) {
				// vou correr todas as equipas do array e apresentar informa��o. so apresento
				// a
				// equipa no array se estiver preenchida essa posi��oo do array
				if (this.torneio.ObterEquipas()[i] != null) {
					Equipa equipa = this.torneio.ObterEquipas()[i];
					System.out.println("Equipa " + (equipa.GetIdEquipa()) + "\nNome: " + equipa.GetNomeEquipa()
							+ "\nFedera��oo: " + equipa.GetFederacao() + "\nAno Inaugura��o: " + equipa.GetInaguracao()
							+ "\nRanking: " + equipa.GetRanking() + "\nMundial: " + equipa.GetMundial());
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
				
				System.out.println("Selecione uma opção:"); 
				System.out.println("1. Alterar nome da equipa");
				System.out.println("2. Alterar ano da fundação");
				System.out.println("3. Alterar Federação");
				System.out.println("4. Alterar Ranking");
				System.out.println("5. Alterar se está ou não no mundial ");
				System.out.println("6. Alterar equipa completa");
				System.out.println("0. Menu Equipas");
				
				opcao = this.ler.nextInt();
				switch (opcao) {			
					case 1: 
						System.out.println("Insira o novo nome da equipa");
						equipaEncontrada.SetNomeEquipa(ler.next());
						break;
					case 2:
						System.out.println("Insira o novo ano da fundação");
						equipaEncontrada.SetInaguracao(ler.nextInt());
						break;
					case 3:
						System.out.println("Insira a nova federação da equipa");
						equipaEncontrada.SetFederacao(ler.next());
						break;
					case 4:
						System.out.println("Insira o novo ranking da equipa");
						equipaEncontrada.SetRanking(ler.nextInt());
						break;				
					case 5:
						mundial = ler.next();
						if	(mundial.toLowerCase().equals("sim")) {
							equipaEncontrada.SetMundial(true);
							System.out.println("Alterado para sim");
						} else if (mundial.toLowerCase().equals("não")) {
							equipaEncontrada.SetMundial(false);
							System.out.println("Alterado para não");
						} else {
							System.out.println("Opção inválida");
						}
						break;					
					case 6: 						
						System.out.println("Indique o nome da nova equipa:");
						equipaEncontrada.SetNomeEquipa(ler.next());
		
						System.out.println("Indique a federação da nova equipa:");
						equipaEncontrada.SetFederacao(ler.next());
		
						System.out.println("Indique o ano de inauguração:");
						equipaEncontrada.SetInaguracao(ler.nextInt());
							
						System.out.println("Indique o ranking da equipa:");
						equipaEncontrada.SetRanking(ler.nextInt());
							
						System.out.println("Indique vai ao mundial (sim, não):");
							
						mundial = ler.next();
						if (mundial.toLowerCase().equals("sim")) {
							equipaEncontrada.SetMundial(true);
						} else if (mundial.toLowerCase().equals("não")){
							equipaEncontrada.SetMundial(false);
						} else {
							System.out.println("Opção 'vai ao mundial' inválida");
						}
						// informo que a equipa foi adicionada
						System.out.println("Equipa editada com sucesso!");						
						break;	
				 	//volta ao menu de equipas
					case 7:
						ApresentarMenuEquipas();
						break;
				}					
			} while (opcao !=0);
		}
	}

	/*
	 * GESTÃO DE TORNEIO
	 */
	public void ListarGrupo(String codigo) {
		Grupo grupo = this.torneio.GetGrupo(codigo);
		if (grupo != null) {
			System.out.println("--- GRUPO " + codigo + " ---");

			for (int i = 0; i < grupo.GetEquipas().length; i++) {
				System.out.println(i + ". " + grupo.GetEquipas()[i].GetNomeEquipa());
			}

		} else {
			System.out.println("Grupo não existente, deve gerar o torneio.");
		}
	}

	public void ListasTodosGrupos() {
		Grupo[] grupos = this.torneio.GetGrupos();
		for (int i = 0; i < grupos.length; i++) {
			ListarGrupo(grupos[i].GetCodigo());
		}
		ApresentarMenuTorneio();
	}

	/*
	 * GESTÂO FICHEIRO
	 */

	private void LerFicheiros() {
		// criar uma pasta -->
		// https://www.guj.com.br/t/criando-arquivos-e-diretorios/42487/2
		File file = new File(this.pastaFicheiros);
		if (!file.exists()) {
			file.mkdirs();
		}
		// está dentro de um try porque vai tentar ler o ficheiro, se der erro salta até
		// o catch mais abaixo
		try {
			// 1. Ler o ficheiro equipas que está na pasta
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
			FileWriter caneta = new FileWriter("C:\\Users\\asaph\\Desktop\\testeLP1\\equipas.txt");
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
}
