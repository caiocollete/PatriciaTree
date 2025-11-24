package Fila;

import Patricia.No;

public class Fila {
    private NoFila inicio;

    public Fila() {
        this.inicio = null;
    }

    public No dequeue(){
        No n = null;
        if(this.inicio != null){
            if(this.inicio.getProx() == null){
                n = inicio.getInfo();
                this.inicio = null;
                return n;
            }
            else{
                n = inicio.getInfo();
                inicio = inicio.getProx();
            }
        }
        return n;
    }
    public void enqueue(No n){
        if(this.inicio == null)
            inicio = new NoFila(n);
        else{
            NoFila aux = inicio;
            while(aux.getProx() != null){
                aux = aux.getProx();
            }
            aux.setProx(new NoFila(n));
        }
    }
    public boolean isEmpty(){
        return inicio == null;
    }
}
