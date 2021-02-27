package br.com.poli.CampoMinadoVVAL.mapa;

import br.com.poli.CampoMinadoVVAL.jogo.Dificuldade;

public class MapaDificil extends Mapa {
	public static final int BOMBAS = 99;

	public MapaDificil() {
		super(BOMBAS, Dificuldade.DIFICIL);
	}

}
