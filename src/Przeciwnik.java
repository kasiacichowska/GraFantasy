public class Przeciwnik extends Osoba{
    private boolean czyStraszny;

    public Przeciwnik(int pktAtaku, int pktObrony, int pktZdrowia, int pieniadze, boolean czyStraszny) {
        super(pktAtaku, pktObrony, pktZdrowia, pieniadze);
        this.czyStraszny = czyStraszny;
    }

    public boolean isCzyStraszny() {
        return czyStraszny;
    }

    public void setCzyStraszny(boolean czyStraszny) {
        this.czyStraszny = czyStraszny;
    }

}
