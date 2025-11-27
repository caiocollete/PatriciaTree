import Patricia.Patricia;

public class Main {
    public static void main(String[] args) {
            Patricia p = new Patricia();

            System.out.println("a) Inserindo...");
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
            p.insert("love");
            System.out.println("Inserido");

            System.out.println("\nb) Exibindo todos os nodos da árvore com seus conteúdos nível a nível:");
            p.exibir_nivel();

            System.out.println("\nc) Palavras na árvore:");
            p.exibir();

    }
}