package Fila;

import Patricia.No;

public class Fila {
    private NoFila inicio;

    public Fila() {
        this.inicio = null;
    }

    public NoFila dequeue(){
        NoFila n = null;
        if(this.inicio != null){
            n = inicio;
            if(this.inicio.getProx() == null){
                this.inicio = null;
            }
            else{
                inicio = inicio.getProx();
            }
        }
        return n;
    }
    public void enqueue(No n, int nivel){
        if(this.inicio == null)
            inicio = new NoFila(n, nivel);
        else{
            NoFila aux = inicio;
            while(aux.getProx() != null){
                aux = aux.getProx();
            }
            aux.setProx(new NoFila(n, nivel));
        }
    }
    public boolean isEmpty(){
        return inicio == null;
    }
}
