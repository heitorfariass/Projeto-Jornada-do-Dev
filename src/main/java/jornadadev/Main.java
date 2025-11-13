package jornadadev;

import jornadadev.core.GameEngine;

/**
 * Classe de entrada do jogo Jornada do Dev — Startup Solana.
 */
public class Main {

    public static void main(String[] args) {
        GameEngine engine = new GameEngine();
        engine.iniciar();
    }
}
