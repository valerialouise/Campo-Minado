package br.com.poli.CampoMinadoVVAL.mapa;

import java.util.ArrayList;
import java.util.List;

public class Celula {
	private boolean bandeira;
	private boolean bomba;
	private int qtdBombasVizinhas;
	private boolean visivel;
	private int linha; // inicializado pelo construtor
	private int coluna; // inicializado pelo construtor
	private List<Celula> vizinhos = new ArrayList<Celula>();

	public Celula(int linha, int coluna) {
		this.bandeira = false;
		this.bomba = false;
		this.qtdBombasVizinhas = 0;
		this.visivel = false;
		this.linha = linha;
		this.coluna = coluna;

	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

	public boolean isBandeira() {
		return bandeira;
	}

	public void setBandeira(boolean bandeira) {
		this.bandeira = bandeira;
	}

	public boolean isBomba() {
		return bomba;
	}

	public void setBomba(boolean bomba) {
		this.bomba = bomba;
	}

	public int getQtdBombasVizinhas() {
		return qtdBombasVizinhas;
	}

	public void setQtdBombasVizinhas() {
		this.qtdBombasVizinhas++;
	}

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	public void buscarVizinhos(Celula[][] campo) {
		for (int w = -1; w < 2; w++) {
			for (int y = -1; y < 2; y++) {
				if (this.getLinha() + w >= 0 && this.getColuna() + y >= 0 && this.getLinha() + w < campo.length
						&& this.getColuna() + y < campo.length) {
					vizinhos.add(campo[this.getLinha() + w][this.getColuna() + y]);
				}
			}

		}
	}

	public boolean isEmBranco() {
		if (getQtdBombasVizinhas() == 0) {
			return true;
		} else {
			return false;
		}
	}

}
