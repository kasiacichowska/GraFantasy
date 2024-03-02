public class Bron extends Wyposazenie{
    int zadawanyAtak;

    public Bron(int cena, String nazwa, int zadawanyAtak) {
        super(cena, nazwa);
        this.zadawanyAtak = zadawanyAtak;
    }

    public int getZadawanyAtak() {
        return zadawanyAtak;
    }

    public void setZadawanyAtak(int zadawanyAtak) {
        this.zadawanyAtak = zadawanyAtak;
    }

}
