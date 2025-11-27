package Patricia;

import Fila.*;

public class Patricia {
    private No raiz;

    public Patricia() {
        raiz = new No();
    }

    private int searchPosition(char letra) {
        return letra - 97;
    }

    private boolean isFolha(No no) {
        int i;

        for (i = 0; i < No.n && no.getvLig(i) == null; i++)
            ;

        return i == No.n;
    }

    public void insert(String word) {
        int pos, i;
        String part = word.toLowerCase();
        No aux = raiz;

        for(i=0; i<word.length() && !part.equals(""); i++){
            pos = searchPosition(part.charAt(0));

            if(aux.getvLig(pos)==null){
                aux.setvLig(pos, new No(part, true));
                part = "";
            }
            else{
                if(aux.getvLig(pos).getString().length()>1)
                    part = split(aux.getvLig(pos), part);
                else{
                    part = part.substring(1); // i++
                }
            }
            aux = aux.getvLig(pos);
        }
        if(i == part.length())
            aux.setEnd(true);
    }

    private String split(No atual, String part) {
        boolean flag = true;
        int i;
        int posStringNode, posNova;
        No aux;
        for(i=0; i<part.length() && i<atual.getString().length() && flag; i++){
            if (part.charAt(i) != atual.getString().charAt(i))
                flag = false;
        }

        // nenhumas das string chegou ao final, portanto, devemos splitar a string do nó
        if(!flag){
            posStringNode = searchPosition(atual.getString().charAt(i-1));
            aux = new No(atual.getString().substring(i-1), atual.getEnd());
            atual.setEnd(false);
            atual.setString(atual.getString().substring(0, i-1));

            if (!isFolha(atual)) {
                aux.copiaLigacoes(atual);
                atual.resetaLigacoes();
            }

            atual.setvLig(posStringNode, aux);

            // posição onde vai inserir a nova palavra
            posNova = searchPosition(part.charAt(i - 1));
            // insere na posição o restante da palavra
            aux = new No(part.substring(i-1), true);
            atual.setvLig(posNova, aux);
            return "";
        } else if(i<atual.getString().length()) {
            posStringNode = searchPosition(atual.getString().charAt(i));
            aux = new No(atual.getString().substring(i), atual.getEnd());
            atual.setString(part);
            atual.setEnd(true);
            if(!isFolha(atual)){
                aux.copiaLigacoes(atual);
                atual.resetaLigacoes();
            }
            atual.setvLig(posStringNode, aux);
            return "";
        } else if (i<part.length()) {
            // se a palavra que eu tenho for maior que a que possui no nó, deixa com que
        } else {
            atual.setEnd(true);
        }
        return part.substring(i);
    }

    public void exibir(){
        for(int i = 0; i< No.n; i++){
            exibirPalavrasArvore(raiz.getvLig(i), "");
        }
    }

    public void exibirPalavrasArvore(No no, String s){
        if(no!=null){
            if(no.getEnd())
               System.out.println(s+no.getString());

            for (int i = 0; i< No.n; i++){
                exibirPalavrasArvore(no.getvLig(i), s+no.getString());
            }
        }
    }

    public void exibir_nivel(){
        Fila f = new Fila();

        f.enqueue(raiz, 0);

        while(!f.isEmpty()){
            NoFila n = f.dequeue();

            System.out.println(n.toString());
            for(int i = 0; i < No.n; i++){
                if(n.getInfo().getvLig(i)!=null)
                    f.enqueue(n.getInfo().getvLig(i), n.getNivel()+1);
            }
        }
    }
}
