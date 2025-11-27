import Patricia.Patricia;

public class Main {
    public static void main(String[] args) {
            Patricia p = new Patricia();

            p.insert("bear");
            p.insert("ben");
            p.insert("bee");
            p.insert("bell");
            p.insert("bid");
            p.insert("bull");
            p.insert("buy");
            p.insert("sell");
            p.insert("stock");
            p.insert("stop");

            System.out.println("Palavras na árvore:");
            p.exibir();

            System.out.println("todos os nodos da árvore com seus conteúdos nível a nível:");
            p.exibir_nivel();
    }
}