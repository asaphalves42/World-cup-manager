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
	 * Variavies Gerais - Todas as funcÃµes.
	 */
	Torneio torneio = new Torneio();
	Scanner ler = new Scanner(System.in);
	String pastaFicheiros = "C:\\Users\\asaph\\Desktop\\testeLP1";

	/*
	 * CONTROLO DE AÇÕES
	 */
	public void Iniciar() {
		System.out.println(" -<<<< APLICACAO DO MUNDIAL >>>>-");
		// this.LerDadosFicheiros();
		this.ApresentarMenuPrincipal();
	}

	// Funcoes menu principal
	public void ApresentarMenuPrincipal() {
		
		do {
		System.out.println("");
		System.out.println(" ## MENU PRINCIPAL ##");
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
		System.out.println(" ## EQUIPAS ##");
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
		}while(this.ler.nextInt()!=0);
	}

	// FuncÃµes para gerir o torneio
	public void ApresentarMenuTorneio() {
		do {
		System.out.println("");
		System.out.println(" ## TORNEIO ##");
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
		System.out.println("11. Gerir jogos dos grupos");
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
		case 11:
			this.GerirJogos();
			break;
		case 0:ApresentarMenuTorneio();
			break;
		default:
			System.out.println("!!!! opcao invalida !!!!");
			this.ApresentarMenuEquipas();
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
				System.out.println("Opção inválida");
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
			System.out.println("\n-------------------------\n"); // o barra n daï¿½ uma quebra de linha

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
					System.out.println("Insira o novo ano da fundacao");
					equipaEncontrada.SetInaguracao(ler.nextInt());
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
					if (mundial.toLowerCase().equals("sim")) {
						equipaEncontrada.SetMundial(true);
						System.out.println("Alterado para sim");
					} else if (mundial.toLowerCase().equals("nao")) {
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
					equipaEncontrada.SetInaguracao(ler.nextInt());

					System.out.println("Indique o ranking da equipa:");
					equipaEncontrada.SetRanking(ler.nextInt());

					System.out.println("Indique vai ao mundial (sim, nao):");

					mundial = ler.next();
					if (mundial.toLowerCase().equals("sim")) {
						equipaEncontrada.SetMundial(true);
					} else if (mundial.toLowerCase().equals("nao")) {
						equipaEncontrada.SetMundial(false);
					} else {
						System.out.println("opcao 'vai ao mundial' invalida");
					}
					// informo que a equipa foi adicionada
					System.out.println("Equipa editada com sucesso!");
					break;
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
				System.out.println(i + ". " + grupo.GetEquipas()[i].GetNomeEquipa());
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

				// 1.1 ApÃ³s lido a linha vou dividir o texto pelo separador |
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
