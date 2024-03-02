public class Bohater extends Osoba{
    private int pktSzczescia;
    private boolean czyUznany, zdolnoscTeleportacji;

    private Wyposazenie [] wyposazenie;
    private int [] zabiciPodRzad;

    public Bohater(int pktAtaku, int pktObrony, int pktZdrowia, int pieniadze, int pktSzczescia, boolean czyUznany, boolean zdolnoscTeleportacji) {
        super(pktAtaku, pktObrony, pktZdrowia, pieniadze);
        this.pktSzczescia = pktSzczescia;
        this.czyUznany = czyUznany;
        this.zdolnoscTeleportacji = zdolnoscTeleportacji;
        this.wyposazenie=new Wyposazenie[5];
        for (int i = 0; i < 5; i++) {
            this.wyposazenie[i]=new Wyposazenie(0,"null");
        }
        this.zabiciPodRzad = new int[5];
    }

    public Wyposazenie[] getWyposazenie() {
        return wyposazenie;
    }

    public void setWyposazenie(Wyposazenie[] wyposazenie) {
        this.wyposazenie = wyposazenie;
    }

    public int getPktSzczescia() {
        return pktSzczescia;
    }

    public void setPktSzczescia(int pktSzczescia) {
        this.pktSzczescia = pktSzczescia;
    }

    public boolean isCzyUznany() {
        return czyUznany;
    }

    public void setCzyUznany(boolean czyUznany) {
        this.czyUznany = czyUznany;
    }

    public boolean isZdolnoscTeleportacji() {
        return zdolnoscTeleportacji;
    }

    public void setZdolnoscTeleportacji(boolean zdolnoscTeleportacji) {
        this.zdolnoscTeleportacji = zdolnoscTeleportacji;
    }

    public int[] getZabiciPodRzad() {
        return zabiciPodRzad;
    }

    public void setZabiciPodRzad(int[] zabiciPodRzad) {
        this.zabiciPodRzad = zabiciPodRzad;
    }
}
