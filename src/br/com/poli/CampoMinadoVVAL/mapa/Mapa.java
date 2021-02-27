package br.com.poli.CampoMinadoVVAL.mapa;

import java.util.Random;

import br.com.poli.CampoMinadoVVAL.jogo.Dificuldade;

public abstract class Mapa {

	private Celula[][] campo;
	private int bombas;
	private int tamanhonfoc;
	private boolean fimDeJogo;
	private boolean ganhouJogo;
	private int celulasVisiveis;

	public Mapa(int bombas, Dificuldade dificuldade) {
		// Construtor!!! c:
		this.tamanhonfoc = dificuldade.getNumero();
		this.bombas = bombas;
		this.campo = new Celula[dificuldade.getNumero()][dificuldade.getNumero()];
		inicializarCelulas();
		distribuirBombas();
		contarBombas();

	}

	private void distribuirBombas() {
		// Método que coloca bombas no Campo!

		Random random = new Random();
		int geraBombaX, geraBombaY;
		/*
		 * Variáveis que receberão valores de 0 até tamanho do campo que representarão
		 * posições do tabuleiro para a atribuição de bombas!
		 */
		int contadorDeBombas = 0;
		// Serve para contar a quantidade de bombas atuais no tabuleiro!
		do {
			geraBombaX = random.nextInt(this.tamanhonfoc);
			geraBombaY = random.nextInt(this.tamanhonfoc);
			if (!campo[geraBombaX][geraBombaY].isBomba()) {
				campo[geraBombaX][geraBombaY].setBomba(true);
				contadorDeBombas++;
			}
		} while (contadorDeBombas < this.bombas);
	}

	private void inicializarCelulas() {
		for (int i = 0; i < tamanhonfoc; i++) {
			for (int j = 0; j < tamanhonfoc; j++) {
				campo[i][j] = new Celula(i, j);
			}

		}
	}

	public void escolherPosicao(int linha, int coluna) {
		/*
		 * Método que seleciona uma Celula a partir de uma linha e coluna, e deixa-a
		 * visível caso não possuir bomba, e finaliza o jogo caso seja bomba.
		 */
		if (linha >= 0 && linha < tamanhonfoc && coluna >= 0 && coluna < tamanhonfoc && !verificarGanhouJogo()) {
			if (!campo[linha][coluna].isVisivel()) {
				if (campo[linha][coluna].isBomba()) {
					System.out.println("Sylas tar! (Game Over)");
					this.fimDeJogo = true;
				} else if (campo[linha][coluna].isBandeira()) {
				} else if (!campo[linha][coluna].isEmBranco()) {
					campo[linha][coluna].setVisivel(true);
					this.celulasVisiveis++;
				} else {
					campo[linha][coluna].setVisivel(true);
					revelarEspacos(campo[linha][coluna]);
					this.celulasVisiveis++;
				}
			}
		} else {
			verificarGanhouJogo();
			imprimeTela(true);
		}

	}

	public void contarBombas() {
		// Método que atribui à Celula a quantidade de bombas vizinhas que possui
		for (int i = 0; i < tamanhonfoc; i++) {
			for (int j = 0; j < tamanhonfoc; j++) {
				if (campo[i][j].isBomba()) {
					for (int w = -1; w < 2; w++) {
						for (int y = -1; y < 2; y++) {
							if (i + w >= 0 && j + y >= 0 && i + w < tamanhonfoc && j + y < tamanhonfoc
									&& !campo[i + w][j + y].isBomba()) {
								campo[i + w][j + y].setQtdBombasVizinhas();
							}
						}

					}

				}
			}
		}
	}

	public void imprimeTela(boolean teste) {
		// Método que constroi o campo e imprime-o na tela!
		for (int i = 0; i < campo.length; i++) {
			for (int j = 0; j < campo.length; j++) {
				if (teste) {
					if (campo[i][j].isBomba()) {
						System.out.print("B  ");
					} else {
						System.out.print(campo[i][j].getQtdBombasVizinhas() + "  ");
					}
				} else {
					if (campo[i][j].isVisivel()) {
						if (campo[i][j].isBandeira()) {
							System.out.print("^  ");
						} else if (campo[i][j].isBomba()) {
							System.out.print("B  ");

						} else {
							System.out.print(campo[i][j].getQtdBombasVizinhas() + "  ");
						}

					} else {
						System.out.print("?  ");
					}
				}
			}
			System.out.println();
		}
	}

	public Celula getCelula(int linha, int coluna) {
		return this.campo[linha][coluna];
	}

	private void revelarEspacos(Celula celulaEscolhida) {
		/*
		 * Método que funciona caso o usuário tenha escolhido uma posição sem bombas
		 * vizinhas, abrindo todas as casas adjacentes, se repetindo caso as casas
		 * adjacentes não possuam bombas também.
		 */
		for (int w = -1; w < 2; w++) {
			for (int y = -1; y < 2; y++) {
				if (celulaEscolhida.getLinha() + w >= 0 && celulaEscolhida.getColuna() + y >= 0
						&& celulaEscolhida.getLinha() + w < tamanhonfoc && celulaEscolhida.getColuna() + y < tamanhonfoc
						&& !campo[celulaEscolhida.getLinha() + w][celulaEscolhida.getColuna() + y].isBomba()
						&& !campo[celulaEscolhida.getLinha() + w][celulaEscolhida.getColuna() + y].isVisivel()) {
					// Checa se está dentro do campo, se tem bomba, se é visível
					if (campo[celulaEscolhida.getLinha() + w][celulaEscolhida.getColuna() + y].isEmBranco())
					// Checa se não possui bombas adjacentes
					{
						escolherPosicao(celulaEscolhida.getLinha() + w, celulaEscolhida.getColuna() + y);
					} else {
						campo[celulaEscolhida.getLinha() + w][celulaEscolhida.getColuna() + y].setVisivel(true);
						this.celulasVisiveis++;
					}
				}
			}
		}
	}

	private boolean verificarGanhouJogo() {
		// Checa se ganhou o Jogo
		if (getCelulasVisiveis() + getBombas() == getTamanhonfoc() * getTamanhonfoc()) {
			this.ganhouJogo = true;
			this.fimDeJogo = true;
			System.out.println("parabains, ganhaste");
		} else {
			this.ganhouJogo = false;
		}
		return this.ganhouJogo;
	}

	public boolean isFimDeJogo() {
		return this.fimDeJogo;
	} // get fimDeJogo

	public boolean isGanhouJogo() {
		return this.ganhouJogo;
	} // get ganhouJogo

	public Celula[][] getCampo() {
		return campo;
	}

	public int getCelulasVisiveis() {
		return celulasVisiveis;
	}

	public void setCampo(Celula[][] campo) {
		this.campo = campo;
	}

	public int getBombas() {
		return bombas;
	}

	public void setBombas(int bombas) {
		this.bombas = bombas;
	}

	public int getTamanhonfoc() {
		return tamanhonfoc;
	}

	public void setTamanhonfoc(int tamanhonfoc) {
		this.tamanhonfoc = tamanhonfoc;
	}

}
