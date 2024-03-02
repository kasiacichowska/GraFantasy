public class Wyposazenie {
    private int cena;
    private String nazwa;

    public Wyposazenie(int cena, String nazwa) {
        this.cena = cena;
        this.nazwa = nazwa;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
