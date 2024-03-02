public class Zbroja extends Wyposazenie{
    private int nadawanePktObrony;

    public Zbroja(int cena, String nazwa, int nadawanePktObrony) {
        super(cena, nazwa);
        this.nadawanePktObrony = nadawanePktObrony;
    }

    public int getNadawanePktObrony() {
        return nadawanePktObrony;
    }

    public void setNadawanePktObrony(int nadawanePktObrony) {
        this.nadawanePktObrony = nadawanePktObrony;
    }


}
