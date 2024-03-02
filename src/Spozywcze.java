public class Spozywcze extends Wyposazenie{
    private int nadawanePktZdrowia;

    public Spozywcze(int cena, String nazwa, int nadawanePktZdrowia) {
        super(cena, nazwa);
        this.nadawanePktZdrowia = nadawanePktZdrowia;
    }

    public int getNadawanePktZdrowia() {
        return nadawanePktZdrowia;
    }

    public void setNadawanePktZdrowia(int nadawanePktZdrowia) {
        this.nadawanePktZdrowia = nadawanePktZdrowia;
    }

}
