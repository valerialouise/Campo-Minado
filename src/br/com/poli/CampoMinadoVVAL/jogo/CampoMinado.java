package br.com.poli.CampoMinadoVVAL.jogo;

import java.util.Scanner;

import br.com.poli.CampoMinadoVVAL.Jogador;
import br.com.poli.CampoMinadoVVAL.mapa.Mapa;
import br.com.poli.CampoMinadoVVAL.mapa.MapaDificil;
import br.com.poli.CampoMinadoVVAL.mapa.MapaFacil;
import br.com.poli.CampoMinadoVVAL.mapa.MapaMedio;

public class CampoMinado {
	private Jogador jogador;
	private Mapa mapa;
	private Dificuldade dificuldade;

	public CampoMinado(String nome, Dificuldade dificuldade) {
		// Construtor!!! c:
		this.jogador = new Jogador(nome);
		this.dificuldade = dificuldade;
		// Inicializa um novo mapa!
		switch (dificuldade) {
		case FACIL:
			this.mapa = new MapaFacil();
			break;
		case MEDIO:
			this.mapa = new MapaMedio();
			break;
		case DIFICIL:
			this.mapa = new MapaDificil();
			break;
		}

	}

	public void iniciarJogo() {
		// Método em que possibilita o usuario jogar o jogo, escolhendo as linhas e
		// colunas
		Scanner scannermuriloehgayvsf = new Scanner(System.in);
		int will, iam;
		while (!this.mapa.isFimDeJogo()) {
			mapa.imprimeTela(false);
			System.out.println("Digite a Linha");
			will = scannermuriloehgayvsf.nextInt();
			System.out.println("Digite a Coluna");
			iam = scannermuriloehgayvsf.nextInt();
			getMapa().escolherPosicao(will, iam);

		}
		scannermuriloehgayvsf.close();
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	public Dificuldade getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}

}
