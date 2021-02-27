package br.com.poli.CampoMinadoVVAL.jogo;

public enum Dificuldade {
	FACIL(9), MEDIO(16), DIFICIL(32);
	private int numero;
	/*
	 * numero que será usado para a definição do tamanho do tabuleiro com base na
	 * escolha da dificuldade do jogador (FACIL ou DIFICIL)!
	 */

	private Dificuldade(int numero) {
		// Construtor!!! c:
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}
    public void setNumero(int numero) {
    	this.numero = numero;
    }
}
