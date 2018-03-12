package com.dave;

public class TresEnRaya {
    private int turno;
    private int[] casilla = new int[9];

    public TresEnRaya() {
        turno = 0;
        for (int i = 0; i < casilla.length; i++) {
            casilla[i] = 0;
        }
    }

    public boolean comprobarGanador() {
        int puntos;
        if (turno % 2 == 0) puntos = 3;
        else puntos = 12;

        return (casilla[0] + casilla[1] + casilla[2] == puntos ||
                casilla[0] + casilla[3] + casilla[6] == puntos ||
                casilla[0] + casilla[4] + casilla[8] == puntos ||
                casilla[1] + casilla[4] + casilla[7] == puntos ||
                casilla[2] + casilla[4] + casilla[6] == puntos ||
                casilla[2] + casilla[5] + casilla[8] == puntos ||
                casilla[3] + casilla[4] + casilla[5] == puntos ||
                casilla[6] + casilla[7] + casilla[8] == puntos);
    }

    public void jugada(int casilla) {
        int valor;
        if (turno % 2 == 0) valor = 1;
        else valor = 4;
        this.casilla[casilla] = valor;
    }

    public int getCasilla(int i) {
        return casilla[i];
    }

    public void siguienteTurno() {
        turno++;
    }

    public void limpiarTablero() {
        turno = 0;
        for (int i = 0; i < casilla.length; i++) {
            casilla[i] = 0;
        }
    }

    public int getTurno() {
        return turno;
    }

    public String getValor(int i) {
        switch (casilla[i]) {
            case 0:
                return "";
            case 1:
                return "O";
            case 4:
                return "X";
        }
        return "?";
    }
}
