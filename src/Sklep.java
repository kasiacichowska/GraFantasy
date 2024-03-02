import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Objects;

public class Sklep {
    private JButton buttonMiecz;
    private JButton buttonTopor;
    private JButton buttonSpodnie;
    private JButton buttonJablko;
    private JButton buttonEliksir;
    private JButton buttonHelm;
    private JButton buttonNapiersnik;
    private JButton buttonLuk;
    private JPanel tloSklepu;
    private JLabel napisSklep;
    private JButton buttonWyjscie;
    private JLabel stanPortfela;
    private JButton walkaButton;
    private JButton usuwaniePrzedmiotow;
    private JButton buttonZlotaTabletka;

    public Sklep() {
        JFrame sklep = new JFrame("Gra");
        sklep.setContentPane(tloSklepu);
        sklep.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        sklep.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                int result = JOptionPane.showConfirmDialog(sklep,
                        "Chcesz opuscic gre? Spowoduje to usuniecie aktualnego zapisu",
                        "Potwierdzenie zamkniecia",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    sklep.dispose();
                }
            }
        });
        Color color = new Color(84, 149, 114);
        tloSklepu.setBackground(color);
        sklep.pack();
        sklep.setLocationRelativeTo(null);
        sklep.setVisible(true);


        if (Main.bohater.isZdolnoscTeleportacji()) {
            Icon teleport2 = new ImageIcon("ikonki/teleport2.png");
            buttonZlotaTabletka.setIcon(teleport2);
        } else {
            Icon teleport = new ImageIcon("ikonki/teleport.png");
            buttonZlotaTabletka.setIcon(teleport);
        }

        if (Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Miecz"))) {
            Icon miecz2 = new ImageIcon("ikonki/gladius2.png");
            buttonMiecz.setIcon(miecz2);
        } else {
            Icon miecz = new ImageIcon("ikonki/gladius.png");
            buttonMiecz.setIcon(miecz);
        }

        if (Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Luk"))) {
            Icon luk2 = new ImageIcon("ikonki/high-shot2.png");
            buttonLuk.setIcon(luk2);
        } else {
            Icon luk = new ImageIcon("ikonki/high-shot.png");
            buttonLuk.setIcon(luk);
        }

        if (Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Topor"))) {
            Icon topor2 = new ImageIcon("ikonki/battle-axe2.png");
            buttonTopor.setIcon(topor2);
        } else {
            Icon topor = new ImageIcon("ikonki/battle-axe.png");
            buttonTopor.setIcon(topor);
        }

        if (Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Helm"))) {
            Icon helm2 = new ImageIcon("ikonki/dwarf-helmet2.png");
            buttonHelm.setIcon(helm2);
        } else {
            Icon helm = new ImageIcon("ikonki/dwarf-helmet.png");
            buttonHelm.setIcon(helm);
        }

        if (Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Napiersnik"))) {
            Icon napiersnik2 = new ImageIcon("ikonki/breastplate2.png");
            buttonNapiersnik.setIcon(napiersnik2);
        } else {
            Icon napiersnik = new ImageIcon("ikonki/breastplate.png");
            buttonNapiersnik.setIcon(napiersnik);
        }

        if (Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Spodnie"))) {
            Icon spodnie2 = new ImageIcon("ikonki/armored-pants2.png");
            buttonSpodnie.setIcon(spodnie2);
        } else {
            Icon spodnie = new ImageIcon("ikonki/armored-pants.png");
            buttonSpodnie.setIcon(spodnie);
        }

        if(Main.bohater.isCzyUznany()){
            JOptionPane.showMessageDialog(null, "W ramach zabicia 5 przeciwnikow pod rzad uzyskales 10% znizki na caly asortyment!");
        }


        Icon jablko = new ImageIcon("ikonki/shiny-apple.png");
        buttonJablko.setIcon(jablko);
        Icon eliksir = new ImageIcon("ikonki/health-potion.png");
        buttonEliksir.setIcon(eliksir);


        stanPortfela.setText("Stan portfela: " + Main.bohater.getPieniadze());
        Icon pieniadz = new ImageIcon("ikonki/rupee.png");
        stanPortfela.setIcon(pieniadz);

        if(Main.bohater.isCzyUznany()){
            buttonJablko.setText("<html>45 dukatow <br> 5 pkt zycia</html>");
            buttonEliksir.setText("<html>90 dukatow <br> 10 pkt zycia</html>");
            buttonNapiersnik.setText("<html>90 dukatow <br> 10 pkt obrony</html>");
            buttonTopor.setText("<html>180 dukatow <br> 15 pkt ataku</html>");
            buttonSpodnie.setText("<html>135 dukatow <br> 15 pkt obrony</html>");
            buttonHelm.setText("<html>45 dukatow <br> 5 pkt obrony</html>");
            buttonMiecz.setText("<html>63 dukatow <br> 5 pkt ataku</html>");
            buttonLuk.setText("<html>45 dukatow <br> 5 pkt obrony</html>");
            buttonZlotaTabletka.setText("<html>900 dukatow <br> zdolnosc teleportacji</html>");
        }


        buttonWyjscie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sklep.dispose();
                new TloGlowne();
            }
        });


//guzik zakupu miecza
        buttonMiecz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz to kupic", "Potwierdzenie", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    int index = -1;
                    for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                        if (Main.bohater.getWyposazenie()[i].getCena() == 0) {
                            index = i;
                            break;
                        }
                    }
                    boolean czyDalej = true;

                    for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                        if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Luk")) {
                            czyDalej = false;
                        } else if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Miecz")) {
                            czyDalej = false;
                        } else if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Topor")) {
                            czyDalej = false;
                        }
                    }

                    if (czyDalej) {

                        if ((Main.bohater.getPieniadze() - 70 >= 0) && (index > -1)) {

                            Wyposazenie[] arr = Main.bohater.getWyposazenie();
                            arr[index] = new Bron(70, "Miecz", 5);
                            Main.bohater.setWyposazenie(arr);
                            if(!Main.bohater.isCzyUznany()) {
                                Main.bohater.setPieniadze(Main.bohater.getPieniadze() - 70);
                            }else{
                                Main.bohater.setPieniadze(Main.bohater.getPieniadze() - 63);
                            }
                            Main.bohater.setPktAtaku(Main.bohater.getPktAtaku()+5);
                            sklep.dispose();
                            new Sklep();
                            JOptionPane.showMessageDialog(null, "Przedmiot Miecz dodal 5 punktow ataku!");

                        } else if (Main.bohater.getPieniadze() - 70 < 0)
                            JOptionPane.showMessageDialog(null, "Brak srodkow!");
                        else JOptionPane.showMessageDialog(null, "Brak miejsca!");
                    } else JOptionPane.showMessageDialog(null, "Juz nie mozesz miec wiecej obiektow tego typu!");
                }
            }
        });


        //guzik zakupu luku
        buttonLuk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz to kupic", "Potwierdzenie", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    int index = -1;
                    for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                        if (Main.bohater.getWyposazenie()[i].getCena() == 0) {
                            index = i;
                            break;
                        }
                    }
                    boolean czyDalej = true;

                    for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {

                        if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Luk")) {
                            czyDalej = false;
                        } else if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Miecz")) {
                            czyDalej = false;
                        } else if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Topor")) {
                            czyDalej = false;
                        }
                    }

                    if (czyDalej) {

                        if ((Main.bohater.getPieniadze() - 100 >= 0) && (index > -1)) {

                            Wyposazenie[] arr = Main.bohater.getWyposazenie();
                            arr[index] = new Bron(100, "Luk", 8);
                            Main.bohater.setWyposazenie(arr);

                            if(!Main.bohater.isCzyUznany()) {
                                Main.bohater.setPieniadze(Main.bohater.getPieniadze() - 100);
                            }else{
                                Main.bohater.setPieniadze(Main.bohater.getPieniadze() - 90);
                            }
                            Main.bohater.setPktAtaku(Main.bohater.getPktAtaku()+8);
                            sklep.dispose();
                            new Sklep();
                            JOptionPane.showMessageDialog(null, "Przedmiot Luk dodal 8 punktow ataku!");

                        } else if (Main.bohater.getPieniadze() - 100 < 0)
                            JOptionPane.showMessageDialog(null, "Brak srodkow!");
                        else JOptionPane.showMessageDialog(null, "Brak miejsca!");
                    } else JOptionPane.showMessageDialog(null, "Juz nie mozesz miec wiecej obiektow tego typu!");
                }
            }
        });

        //guzik zakupu toporka
        buttonTopor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz to kupic", "Potwierdzenie", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    int index = -1;
                    for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                        if (Main.bohater.getWyposazenie()[i].getCena() == 0) {
                            index = i;
                            break;
                        }
                    }
                    boolean czyDalej = true;

                    for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {

                        if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Luk")) {
                            czyDalej = false;
                        } else if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Miecz")) {
                            czyDalej = false;
                        } else if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Topor")) {
                            czyDalej = false;
                        }
                    }

                    if (czyDalej) {

                        if ((Main.bohater.getPieniadze() - 200 >= 0) && (index > -1)) {

                            Wyposazenie[] arr = Main.bohater.getWyposazenie();
                            arr[index] = new Bron(200, "Topor", 15);
                            Main.bohater.setWyposazenie(arr);

                            if(!Main.bohater.isCzyUznany()) {
                                Main.bohater.setPieniadze(Main.bohater.getPieniadze() - 200);
                            }else{
                                Main.bohater.setPieniadze(Main.bohater.getPieniadze() - 180);
                            }
                            Main.bohater.setPktAtaku(Main.bohater.getPktAtaku()+15);
                            sklep.dispose();
                            new Sklep();
                            JOptionPane.showMessageDialog(null, "Przedmiot Topor dodal 15 punktow ataku!");

                        } else if (Main.bohater.getPieniadze() - 200 < 0)
                            JOptionPane.showMessageDialog(null, "Brak srodkow!");
                        else JOptionPane.showMessageDialog(null, "Brak miejsca!");
                    } else JOptionPane.showMessageDialog(null, "Juz nie mozesz miec wiecej obiektow tego typu!");
                }
            }
        });

        //guzik zakupu helmu
        buttonHelm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz to kupic", "Potwierdzenie", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    int index = -1;
                    for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                        if (Main.bohater.getWyposazenie()[i].getCena() == 0) {
                            index = i;
                            break;
                        }
                    }
                    boolean czyDalej = true;

                    for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                        if (Main.bohater.getWyposazenie()[i] instanceof Zbroja) {
                            if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Helm")) {
                                czyDalej = false;
                            }
                        }
                    }

                    if (czyDalej) {

                        if ((Main.bohater.getPieniadze() - 50 >= 0) && (index > -1)) {

                            Wyposazenie[] arr = Main.bohater.getWyposazenie();
                            arr[index] = new Zbroja(50, "Helm", 5);
                            Main.bohater.setWyposazenie(arr);

                            if(!Main.bohater.isCzyUznany()) {
                                Main.bohater.setPieniadze(Main.bohater.getPieniadze() - 50);
                            }else{
                                Main.bohater.setPieniadze(Main.bohater.getPieniadze() - 45);
                            }
                            Main.bohater.setPktObrony(Main.bohater.getPktObrony()+5);
                            sklep.dispose();
                            new Sklep();
                            JOptionPane.showMessageDialog(null, "Przedmiot Helm dodal 5 punktow obrony!");

                        } else if (Main.bohater.getPieniadze() - 50 < 0)
                            JOptionPane.showMessageDialog(null, "Brak srodkow!");
                        else JOptionPane.showMessageDialog(null, "Brak miejsca!");
                    } else JOptionPane.showMessageDialog(null, "Juz nie mozesz miec wiecej obiektow tego typu!");
                }
            }
        });

        //guzik zakupu napiersnika
        buttonNapiersnik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz to kupic", "Potwierdzenie", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    int index = -1;
                    for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                        if (Main.bohater.getWyposazenie()[i].getCena() == 0) {
                            index = i;
                            break;
                        }
                    }
                    boolean czyDalej = true;

                    for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                        if (Main.bohater.getWyposazenie()[i] instanceof Zbroja) {
                            if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Napiersnik")) {
                                czyDalej = false;
                            }
                        }
                    }

                    if (czyDalej) {

                        if ((Main.bohater.getPieniadze() - 100 >= 0) && (index > -1)) {

                            Wyposazenie[] arr = Main.bohater.getWyposazenie();
                            arr[index] = new Zbroja(100, "Napiersnik", 10);
                            Main.bohater.setWyposazenie(arr);

                            if(!Main.bohater.isCzyUznany()) {
                                Main.bohater.setPieniadze(Main.bohater.getPieniadze() - 100);
                            }else{
                                Main.bohater.setPieniadze(Main.bohater.getPieniadze() - 90);
                            }
                            Main.bohater.setPktObrony(Main.bohater.getPktObrony()+10);
                            sklep.dispose();
                            new Sklep();
                            JOptionPane.showMessageDialog(null, "Przedmiot Napiersnik dodal 10 punktow obrony!");

                        } else if (Main.bohater.getPieniadze() - 100 < 0)
                            JOptionPane.showMessageDialog(null, "Brak srodkow!");
                        else JOptionPane.showMessageDialog(null, "Brak miejsca!");
                    } else JOptionPane.showMessageDialog(null, "Juz nie mozesz miec wiecej obiektow tego typu!");
                }
            }
        });

        //guzik zakupu spodni
        buttonSpodnie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz to kupic", "Potwierdzenie", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    int index = -1;
                    for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                        if (Main.bohater.getWyposazenie()[i].getCena() == 0) {
                            index = i;
                            break;
                        }
                    }
                    boolean czyDalej = true;

                    for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                        if (Main.bohater.getWyposazenie()[i] instanceof Zbroja) {
                            if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Spodnie")) {
                                czyDalej = false;
                            }
                        }
                    }

                    if (czyDalej) {

                        if ((Main.bohater.getPieniadze() - 150 >= 0) && (index > -1)) {

                            Wyposazenie[] arr = Main.bohater.getWyposazenie();
                            arr[index] = new Zbroja(150, "Spodnie", 15);
                            Main.bohater.setWyposazenie(arr);

                            if(!Main.bohater.isCzyUznany()) {
                                Main.bohater.setPieniadze(Main.bohater.getPieniadze() - 150);
                            }else{
                                Main.bohater.setPieniadze(Main.bohater.getPieniadze() - 135);
                            }
                            Main.bohater.setPktObrony(Main.bohater.getPktObrony()+15);
                            sklep.dispose();
                            new Sklep();
                            JOptionPane.showMessageDialog(null, "Przedmiot Spodnie dodal 15 punktow obrony!");

                        } else if (Main.bohater.getPieniadze() - 150 < 0)
                            JOptionPane.showMessageDialog(null, "Brak srodkow!");
                        else JOptionPane.showMessageDialog(null, "Brak miejsca!");
                    } else JOptionPane.showMessageDialog(null, "Juz nie mozesz miec wiecej obiektow tego typu!");
                }
            }
        });

        usuwaniePrzedmiotow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean czyWEkwipunku;
                int x=0;
                for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                    if(Main.bohater.getWyposazenie()[i].getNazwa().equals("null")){
                        x++;
                    }
                }
                if(x==5) {
                    JOptionPane.showMessageDialog(null, "Brak przedmiotow w ekwipunku!");
                }else{
                    sklep.dispose();
                    new WyrzucaniePrzedmiotow();
                }
            }
        });
        buttonJablko.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz to kupic?", "Potwierdzenie", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    if (Main.bohater.getPieniadze() >= 50 && Main.bohater.getPktZdrowia() < 20) {
                        if(!Main.bohater.isCzyUznany()) {
                            Main.bohater.setPieniadze(Main.bohater.getPieniadze() - 50);
                        }else{
                            Main.bohater.setPieniadze(Main.bohater.getPieniadze() - 45);
                        }
                        Main.bohater.setPktZdrowia(Main.bohater.getPktZdrowia() + 5);
                        JOptionPane.showMessageDialog(null, "Twoja postac zyskala 5 punktow zdrowia!");
                        sklep.dispose();
                        new Sklep();
                    }
                    if (!(Main.bohater.getPktZdrowia() < 20)) {
                        JOptionPane.showMessageDialog(null, "Twoja postac ma maksymalna ilosc punktow zdrowia!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Brak srodkow!");
                    }
                }
            }
        });
        buttonEliksir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz to kupic?", "Potwierdzenie", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    if (Main.bohater.getPieniadze() >= 100 && Main.bohater.getPktZdrowia() < 20) {
                        if(!Main.bohater.isCzyUznany()) {
                            Main.bohater.setPieniadze(Main.bohater.getPieniadze() - 100);
                        }else{
                            Main.bohater.setPieniadze(Main.bohater.getPieniadze() - 90);
                        }
                        Main.bohater.setPktZdrowia(Main.bohater.getPktZdrowia() + 10);
                        JOptionPane.showMessageDialog(null, "Twoja postac zyskala 10 punktow zdrowia!");
                        sklep.dispose();
                        new Sklep();
                    }
                    if (!(Main.bohater.getPktZdrowia() < 20)) {
                        JOptionPane.showMessageDialog(null, "Twoja postac ma maksymalna ilosc punktow zdrowia!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Brak srodkow!");
                    }
                }
            }
        });
        buttonZlotaTabletka.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz to kupic?", "Potwierdzenie", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    if (Main.bohater.getPieniadze() >= 1000 && !Main.bohater.isZdolnoscTeleportacji()) {
                        if(!Main.bohater.isCzyUznany()) {
                            Main.bohater.setPieniadze(Main.bohater.getPieniadze() - 1000);
                        }else{
                            Main.bohater.setPieniadze(Main.bohater.getPieniadze() - 900);
                        }
                        Main.bohater.setZdolnoscTeleportacji(true);
                        sklep.dispose();
                        new Sklep();
                    } else if (Main.bohater.isZdolnoscTeleportacji() == true) {
                        JOptionPane.showMessageDialog(null, "Twoja postac ma juz zdolnosc teleportacji!");
                    } else
                        JOptionPane.showMessageDialog(null, "Brak srodkow!");
                }
            }
        });
        walkaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz zaczac walke?", "Potwierdzenie", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    sklep.dispose();
                    new PoleWalki();
                }
            }

        });
    }
}
