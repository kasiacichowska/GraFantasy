public class Osoba {

    private int pktAtaku, pktObrony, pktZdrowia, pieniadze;

    public Osoba(int pktAtaku, int pktObrony, int pktZdrowia, int pieniadze) {
        this.pktAtaku = pktAtaku;
        this.pktObrony = pktObrony;
        this.pktZdrowia = pktZdrowia;
        this.pieniadze = pieniadze;
    }

    public int getPktAtaku() {
        return pktAtaku;
    }

    public void setPktAtaku(int pktAtaku) {
        this.pktAtaku = pktAtaku;
    }

    public int getPktObrony() {
        return pktObrony;
    }

    public void setPktObrony(int pktObrony) {
        this.pktObrony = pktObrony;
    }

    public int getPktZdrowia() {
        return pktZdrowia;
    }

    public void setPktZdrowia(int pktZdrowia) {
        this.pktZdrowia = pktZdrowia;
    }

    public int getPieniadze() {
        return pieniadze;
    }

    public void setPieniadze(int pieniadze) {
        this.pieniadze = pieniadze;
    }
}
