package funçõesLP;

import equipes.TF.LP1.Equipa;

public class Funcoes {
	public void listarEquipas(Equipa[] equipas) {
		for (int i = 0; i <= equipas.length-1; i++) {
			if (equipas[i] != null) {
				System.out.println(equipas[i].toString());
			}
		}
	}
}
