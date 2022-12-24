package equipes.TF.LP1;

import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Aplicacao {

	public Aplicacao() {
		this.equipas = new Equipa[100];
	}

	/*
	 * Variavies Gerais - Todas as funcões.
	 */
	Equipa[] equipas;
	Scanner ler = new Scanner(System.in);
	String pastaFicheiros = "C:\\aplicacao\\";

	/*
	 * CONTROLO DE AÇÕES
	 */
	public void Iniciar() {
		System.out.println(" -<<<< APLICAÇÂO DO MUNDIAL >>>>-");
		// this.LerDadosFicheiros();
		this.ApresentarMenuPrincipal();
	}

	// Funções menu principal
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
			// gravo a informação para ficheiros e sai
			// this.GravarDadosParaFicheiros();
			break;
		}
		default:
			System.out.println("Opção inválida.");
			this.ApresentarMenuPrincipal();
		}

	}

	// Funções para gerir as equipas
	public void ApresentarMenuEquipas() {
		System.out.println("");
		System.out.println(" ## EQUIPAS ##");
		System.out.println("(Selecione uma opção)");

		System.out.println("1. Listar equipa");
		System.out.println("2. Adicionar equipa");
		System.out.println("3. Editar equipa");
		System.out.println("4. Eliminar equipa");
		System.out.println("5. Menu Principal");

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
		default:
			System.out.println("!!!! Opção inválida !!!");
			this.ApresentarMenuEquipas();
		}
	}

	// Funções para gerir o torneio
	public void ApresentarMenuTorneio() {

	}

	/*
	 * GESTÂO DE EQUIPAS
	 */

	public void AdicionarEquipa() {
		// Peço os dados ao utilizador
		Equipa nova = new Equipa();

		System.out.println("Indique o nome  da equipa:");
		nova.SetnomeEquipa(ler.next());

		System.out.println("Indique a federação da equipa:");
		nova.SetFederacao(ler.next());

		System.out.println("Indique o ano de inauguração:");
		nova.SetInaguracao(ler.nextInt());

		System.out.println("Indique o ranking da equipa:");
		nova.SetRanking(ler.nextInt());

		System.out.println("Indique vai ao mundial:");
		String mundial = ler.next();

		if (mundial.equals("sim")) {
			nova.SetMundial(true);
		} else {
			nova.SetMundial(false);
		}
		// adiciono a equipa na ultima posição do array
		this.equipas[this.ContagemEquipas()] = nova;

		// informo que a equipa foi adicionada
		System.out.println("Equipa adicionada com sucesso!");

		// volta ao menu de equipas
		ApresentarMenuEquipas();
	}

	public void EliminarEquipa() {

		System.out.println("Indique o nome da equipa que pretende eliminar:");
		String nomeEquipa = ler.next();

		// vou correr todo o array para verificar se existe alguma equipa com aquele
		// nome
		Boolean encontrei = false;
		for (int i = 0; i < this.equipas.length; i++) {
			if (this.equipas[i] != null) {
<<<<<<< HEAD
				if (this.equipas[i].GetnomeEquipa().equals(nomeEquipa) | encontrei == true) {
					// encontrei a equipa ent�o vou colocar o proximo elemento na posi��o deste, ou
					// seja, todos as proximos equipas da lista andam uma casa para tr�s
=======
				if (this.equipas[i].GetnomeEquipa().equals(nomeEquipa)| encontrei == true) {
					// encontrei a equipa então vou colocar o proximo elemento na posição deste, ou
					// seja, todos as proximos equipas da lista andam uma casa para trás
>>>>>>> eab420defb82c1dd6453ebe8a940481e940bfe5d
					this.equipas[i] = this.equipas[i + 1];
					encontrei = true;
				}
			}
		}

		if (encontrei == true) {
			System.out.println("Equipa eliminada com sucesso.");
		} else {
			System.out.println("Equipa não encontrada");
		}
		ApresentarMenuEquipas();
	}

	public void ListarEquipas() {
		// se o array está vazio, ou seja, não existem equipas
		if (this.ContagemEquipas() == 0) {
			System.out.println("Não existem equipas registadas.");
		} else {
			System.out.println("\n-------------------------\n"); // o barra n dá uma quebra de linha
			for (int i = 0; i < this.equipas.length; i++) {
				// vou correr todas as equipas do array e apresentar informação. so apresento a
				// equipa no array se estiver preenchida essa posição do array
				if (this.equipas[i] != null) {
					Equipa equipa = this.equipas[i];
					System.out.println("Equipa " + (i + 1) + "\nNome: " + equipa.GetnomeEquipa() + "\nFederação: "
							+ equipa.GetFederacao() + "\nAno Inauguração: " + equipa.GetInaguracao() + "\nRanking: "
							+ equipa.GetRanking() + "\nMundial: " + equipa.GetMundial());
					// adiciono uma quebra de linha por cada equipa
					System.out.println("");
				}
			}
			System.out.println("-------------------------");
		}
		ApresentarMenuEquipas();
	}

<<<<<<< HEAD
	private void EditarEquipa() {

		System.out.println("Qual equipa pretende editar?");
		
		String nomeEquipa = ler.next();
		
		Boolean encontrei = false;
		for (int i = 0; i < equipas.length; i++) {
			if (equipas[i] != null)
				if (equipas[i].GetnomeEquipa().equals(nomeEquipa) | encontrei == true) {
					this.equipas[i] = this.equipas[i + 1];
					encontrei = true;
				}
		}
		if (encontrei == true) {
			Equipa nova = new Equipa();
=======
	public void EditarEquipa() {

		
		
		System.out.println("Indique o nome da equipa que pretende editar");
		String nomeEquipa = ler.next();

		// vou correr todo o array para verificar se existe alguma equipa com aquele
		// nome
		Boolean encontrei = false;
		for (int i = 0; i < this.equipas.length; i++) {
			if (this.equipas[i] != null) {
				if (this.equipas[i].GetnomeEquipa().equals(nomeEquipa)| encontrei == true) {
					// encontrei a equipa então vou colocar o proximo elemento na posição deste, ou
					// seja, todos as proximos equipas da lista andam uma casa para trás
					this.equipas[i] = this.equipas[i + 1];
					encontrei = true;
				}
			}
		}
		Equipa nova = new Equipa();
		System.out.println("Indique o nome  da equipa:");
		nova.SetnomeEquipa(ler.next());

		System.out.println("Indique a federação da equipa:");
		nova.SetFederacao(ler.next());

		System.out.println("Indique o ano de inauguração:");
		nova.SetInaguracao(ler.nextInt());

		System.out.println("Indique o ranking da equipa:");
		nova.SetRanking(ler.nextInt());

		System.out.println("Indique vai ao mundial:");
		String mundial = ler.next();

		if (mundial.equals("sim")) {
			nova.SetMundial(true);
		} else {
			nova.SetMundial(false);
		}
		// adiciono a equipa na ultima posição do array
		this.equipas[this.ContagemEquipas()] = nova;

		// informo que a equipa foi adicionada
		System.out.println("Equipa adicionada com sucesso!");

		// volta ao menu de equipas
		ApresentarMenuEquipas();
		
		
		AdicionarEquipa();
		
		
	}
		/*for (int i = 0; i < equipas.length; i++) {
			if (equipas[i].GetnomeEquipa() == nomeEquipa) {
>>>>>>> eab420defb82c1dd6453ebe8a940481e940bfe5d

			System.out.println("Indique o nome da nova equipa:");
			nova.SetnomeEquipa(ler.next());

			System.out.println("Indique a federa��o da nova equipa:");
			nova.SetFederacao(ler.next());

			System.out.println("Indique o ano de inaugura��o:");
			nova.SetInaguracao(ler.nextInt());

			System.out.println("Indique o ranking da equipa:");
			nova.SetRanking(ler.nextInt());

			System.out.println("Indique vai ao mundial:");
			String mundial = ler.next();

			if (mundial.equals("sim")) {
				nova.SetMundial(true);
			} else {
				nova.SetMundial(false);
			}
			// adiciono a equipa na ultima posi��o do array
			this.equipas[this.ContagemEquipas()] = nova;

			// informo que a equipa foi adicionada
			System.out.println("Equipa editada com sucesso!");

			// volta ao menu de equipas
			ApresentarMenuEquipas();
		}else {
			System.out.println("Equipa n�o encontrada");
		}

	}
	*/

	private int ContagemEquipas() {
		int contador = 0;
		for (int i = 0; i < this.equipas.length; i++) {
			// vou correr todas as equipas do array e apresentar informação. so apresento a
			// equipa no array se estiver preenchida essa posição do array
			if (this.equipas[i] != null) {
				contador++;
			} else {
				break;
			}
		}
		return contador;
	}

}
