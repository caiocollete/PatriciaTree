package Patricia;

public class No {
    public final static int n = 26;
    private String string;
    private No[] vLig;

    private boolean end;

    public No() {
        vLig = new No[n];
        end = false;
        string = "";
    }

    public No(String string, boolean end) {
        this.string = string;
        vLig = new No[n];
        this.end = end;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public No getvLig(int pos) {
        return vLig[pos];
    }

    public void setvLig(int pos, No no) {
        this.vLig[pos] = no;
    }

    public boolean getEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public void copiaLigacoes(No no){
        for (int i = 0; i < No.n; i++) {
            setvLig(i, no.getvLig(i));
        }
    }

    public void resetaLigacoes(){
        this.vLig = new No[No.n];
    }
}
