package main.TF.LP1;

import java.util.Scanner;

import equipes.TF.LP1.Equipa;
import fun��esLP.Funcoes;

public class RunnerLP {

	public static void main(String[] args) {
		int escolha;
		String nome;
		String novoNome;
		String federac;
		int dataDeInaug;
		int ranking;
		boolean estaMundial;

		Funcoes funcoes = new Funcoes();
		

		do {
			Scanner ler = new Scanner(System.in);

			Equipa[] equipas = new Equipa[24];
			
			System.out.println("**************************************");

			System.out.println("Bem vindo ao mundial do Catar de 2022!");
			
			System.out.println("**************************************");

			System.out.println("\n");

			System.out.println("Escolha uma das op��es: \n");
			System.out.println("-------------------------");
			System.out.println("1 - Inserir equipa");
			System.out.println("2 - Deletar equipa");
			System.out.println("3 - Listar equipas");
			System.out.println("4 - Editar equipas");

			escolha = ler.nextInt();

			switch (escolha) {
			case 1:
				System.out.print("Insira o nome da equipa: ");
				nome = ler.next();

				System.out.print("Federa��o: ");
				federac = ler.next();

				System.out.print("Ano de inaugura��o: ");
				dataDeInaug = ler.nextInt();
				
				System.out.print("Ranking: ");
				ranking = ler.nextInt();
				
				System.out.print("Est� no mundial? ");
				estaMundial = ler.nextBoolean();
				System.out.println("\n");

				Equipa novaEquipa = new Equipa(nome, federac, dataDeInaug, ranking, estaMundial);
				equipas[0] = novaEquipa;

				break;

			case 2:
				System.out.println("Qual equipa queres deletar?");
				nome = ler.next();
				funcoes.listarEquipas(equipas);
				//funcao para deletar equipas
				break;

			case 3:
				funcoes.listarEquipas(equipas);
				break;

			case 4:
				// fun�ao para listar equipas
				System.out.println("Qual equipa queres alterar: ");
				nome = ler.next();

				System.out.println("Novo nome:");
				novoNome = ler.next();
				// fun�ao para trocar os nomes

			default:
				System.out.println("Escolha desconhecida!");
			}

		} while (escolha != 5);
	}
}
