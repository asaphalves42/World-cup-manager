package funçõesLP;

import java.util.Scanner;

import equipes.TF.LP1.Equipa;

public class Funcoes {
	public void listarEquipas(Equipa[] equipas, int nEquipas) {
		for (int i = 0; i < nEquipas; i++) {
			
			System.out.println(equipas[i].toString());

		}
	}
}
