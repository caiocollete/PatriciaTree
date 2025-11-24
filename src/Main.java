import Patricia.Patricia;

public class Main {
    public static void main(String[] args) {
            Patricia p = new Patricia();

            p.insert("bear");
            p.insert("ben");
            p.insert("be");
            p.insert("bell");
            p.insert("bid");
            p.insert("bull");
            p.insert("buy");
            p.insert("sell");
            p.insert("stock");
            p.insert("stop");

            //p.exibir();
            p.exibir_nivel();
    }
}