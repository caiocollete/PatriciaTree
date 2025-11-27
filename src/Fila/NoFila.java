package Fila;

import Patricia.No;

public class NoFila {
    private No info;
    private NoFila prox;
    private int nivel;

    public NoFila(No info, int nivel) {
        this.info = info;
        this.nivel = nivel;
    }

    public NoFila() {
    }

    public No getInfo() {
        return info;
    }

    public void setInfo(No info) {
        this.info = info;
    }

    public NoFila getProx() {
        return prox;
    }

    public void setProx(NoFila prox) {
        this.prox = prox;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Nivel: " + nivel + ", info: " + info.getString();
    }
}
