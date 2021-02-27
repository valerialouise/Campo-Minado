package br.com.poli.CampoMinadoVVAL.mapa;

import br.com.poli.CampoMinadoVVAL.jogo.Dificuldade;

public class MapaFacil extends Mapa {
	public static final int BOMBAS = 10;

	public MapaFacil() {
		super(BOMBAS, Dificuldade.FACIL);
	}

}
