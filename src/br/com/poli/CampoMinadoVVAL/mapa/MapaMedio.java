package br.com.poli.CampoMinadoVVAL.mapa;

import br.com.poli.CampoMinadoVVAL.jogo.Dificuldade;

public class MapaMedio extends Mapa {
	public static final int BOMBAS = 40;

	public MapaMedio() {
		super(BOMBAS, Dificuldade.MEDIO);
	}

}
