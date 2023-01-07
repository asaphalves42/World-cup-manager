package equipes.TF.LP1;

import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Aplicacao {

	public Aplicacao() {
		this.equipas = new Equipa[100];
		this.InicializarEquipas();
	}

	/*
	 * Variavies Gerais - Todas as funções.
	 */
	Equipa[] equipas;
	Scanner ler = new Scanner(System.in);
	String pastaFicheiros = "C:\\aplicacao\\";

	/*
	 * CONTROLO DE funções
	 */
	public void Iniciar() {
		System.out.println(" -<<<< APLICAï¿½ï¿½O DO MUNDIAL >>>>-");
		// this.LerDadosFicheiros();
		this.ApresentarMenuPrincipal();
	}

	// Funï¿½ï¿½es menu principal
	public void ApresentarMenuPrincipal() {
		System.out.println("");
		System.out.println(" ## MENU PRINCIPAL ##");
		System.out.println("(Selecione uma opï¿½ï¿½o)");

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
			// gravo a informaï¿½ï¿½o para ficheiros e sai
			// this.GravarDadosParaFicheiros();
			break;
		}
		default:
			System.out.println("Opï¿½ï¿½o invï¿½lida.");
			this.ApresentarMenuPrincipal();
		}

	}

	// Funï¿½ï¿½es para gerir as equipas
	public void ApresentarMenuEquipas() {
		System.out.println("");
		System.out.println(" ## EQUIPAS ##");
		System.out.println("(Selecione uma opï¿½ï¿½o)");

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
			System.out.println("!!!! Opï¿½ï¿½o invï¿½lida !!!");
			this.ApresentarMenuEquipas();
		}
	}

	// Funï¿½ï¿½es para gerir o torneio
	public void ApresentarMenuTorneio() {

	}

	/*
	 * GESTï¿½O DE EQUIPAS
	 */

	public void AdicionarEquipa() {
		// Peï¿½o os dados ao utilizador
		Equipa nova = new Equipa();

		System.out.println("Indique o nome  da equipa:");
		nova.SetnomeEquipa(ler.next());

		System.out.println("Indique a federaï¿½ï¿½o da equipa:");
		nova.SetFederacao(ler.next());

		System.out.println("Indique o ano de inauguraï¿½ï¿½o:");
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
		// adiciono a equipa na ultima posiï¿½ï¿½o do array
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
				if (this.equipas[i].GetnomeEquipa().equals(nomeEquipa) || encontrei == true) {
					// encontrei a equipa entï¿½o vou colocar o proximo elemento na posiï¿½ï¿½o deste, ou
					// seja, todos as proximos equipas da lista andam uma casa para trï¿½s
					
					this.equipas[i] = this.equipas[i + 1];
					encontrei = true;
				}
			}
		}

		if (encontrei == true) {
			System.out.println("Equipa eliminada com sucesso.");
		} else {
			System.out.println("Equipa nï¿½o encontrada");
		}
		ApresentarMenuEquipas();
	}

	public void ListarEquipas() {
		// se o array estaï¿½ vazio, ou seja, nï¿½o existem equipas
		if (this.ContagemEquipas() == 0) {
			System.out.println("Nï¿½o existem equipas registadas.");
		} else {
			System.out.println("\n-------------------------\n"); // o barra n daï¿½ uma quebra de linha
			for (int i = 0; i < this.equipas.length; i++) {
				// vou correr todas as equipas do array e apresentar informaï¿½ï¿½o. so apresento
				// a
				// equipa no array se estiver preenchida essa posiï¿½ï¿½oo do array
				if (this.equipas[i] != null) {
					Equipa equipa = this.equipas[i];
					System.out.println("Equipa " + (equipa.GetIdEquipa()) + "\nNome: " + equipa.GetnomeEquipa() + "\nFederaï¿½ï¿½oo: "
							+ equipa.GetFederacao() + "\nAno Inauguraï¿½ï¿½o: " + equipa.GetInaguracao() + "\nRanking: "
							+ equipa.GetRanking() + "\nMundial: " + equipa.GetMundial());
					// adiciono uma quebra de linha por cada equipa
					System.out.println("");
				}else {
					break;
				}
			}
			System.out.println("-------------------------");
		}
		ApresentarMenuEquipas();
	}

	public void EditarEquipa() {

		System.out.println("Indique o nome da equipa que pretende editar");
		String nomeEquipa = ler.next();

		// vou correr todo o array para verificar se existe alguma equipa com aquele		
		Equipa equipaEncontrada = null;
		for (int i = 0; i < this.equipas.length; i++) {
			if (this.equipas[i] != null) {
				if (this.equipas[i].GetnomeEquipa().toLowerCase().equals(nomeEquipa.toLowerCase())) {					
					equipaEncontrada = this.equipas[i];
					break;
				}
			}
		}
		
		if (equipaEncontrada != null) {
			System.out.println("Indique o nome da nova equipa:");
			equipaEncontrada.SetnomeEquipa(ler.next());

			System.out.println("Indique a federaï¿½ï¿½o da nova equipa:");
			equipaEncontrada.SetFederacao(ler.next());

			System.out.println("Indique o ano de inauguraï¿½ï¿½o:");
			equipaEncontrada.SetInaguracao(ler.nextInt());

			System.out.println("Indique o ranking da equipa:");
			equipaEncontrada.SetRanking(ler.nextInt());

			System.out.println("Indique vai ao mundial:");
			String mundial = ler.next();

			if (mundial.equals("sim")) {
				equipaEncontrada.SetMundial(true);
			} else {
				equipaEncontrada.SetMundial(false);
			}
			// informo que a equipa foi adicionada
			System.out.println("Equipa editada com sucesso!");
		} else {
			// informo que a equipa foi adicionada
			System.out.println("Equipa nÃ£o encontrada!");
		}
		
		// volta ao menu de equipas
		ApresentarMenuEquipas();

	}
	
	private int ContagemEquipas() {
		int contador = 0;
		for (int i = 0; i < this.equipas.length; i++) {
			// vou correr todas as equipas do array e apresentar informaï¿½ï¿½o, so apresento
			// a
			// equipa no array se estiver preenchida essa posiï¿½ï¿½o do array
			if (this.equipas[i] != null) {
				contador++;
			} else {
				break;
			}
		}
		return contador;
	}
	
	
	private void InicializarEquipas() {
		Equipa novo = new Equipa();
		novo.SetnomeEquipa("Portugal");
		novo.SetFederacao("Portugal");
		novo.SetMundial(true);
		novo.SetRanking(5);
		novo.SetInaguracao(2000);
		novo.SetContinenteEquipa("europa");
		this.equipas[0] = novo;
		
		novo = new Equipa();
		novo.SetnomeEquipa("Espanha");
		novo.SetFederacao("Espanha");
		novo.SetMundial(true);
		novo.SetRanking(5);		
		novo.SetInaguracao(2000);
		novo.SetContinenteEquipa("europa");
		this.equipas[1] = novo;	
		
		novo = new Equipa();
		novo.SetnomeEquipa("FranÃ§a");
		novo.SetFederacao("FranÃ§a");
		novo.SetMundial(true);
		novo.SetRanking(5);
		novo.SetInaguracao(2000);
		novo.SetContinenteEquipa("europa");
		this.equipas[2] = novo;	
	}

}
