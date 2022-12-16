package equipes.TF.LP1;


public class Equipa {
	private String nome;
	private String federacao;
	private int dataInaug;
	private int ranking;
	private boolean presenteOuNao;
	
	public Equipa(String nome, String federacao, int dataInaug, int ranking, boolean presenteOuNao) {
		super();
		this.nome = nome;
		this.federacao = federacao;
		this.dataInaug = dataInaug;
		this.ranking = ranking;
		this.presenteOuNao = presenteOuNao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFederacao() {
		return federacao;
	}

	public void setFederacao(String federacao) {
		this.federacao = federacao;
	}

	public int getDataInaug() {
		return dataInaug;
	}

	public void setDataInaug(int dataInaug) {
		this.dataInaug = dataInaug;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public boolean isPresenteOuNao() {
		return presenteOuNao;
	}

	public void setPresenteOuNao(boolean presenteOuNao) {
		this.presenteOuNao = presenteOuNao;
	}

	@Override
	public String toString() {
		return "Equipas [nome = " + nome + ", federacao = " + federacao + ", dataInaug = " + dataInaug + ", ranking = "
				+ ranking + ", presenteOuNao = " + presenteOuNao + "]";
	}
	
	
	
}

