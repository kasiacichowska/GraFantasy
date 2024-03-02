import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;

public class PoleWalki {
    private JPanel tloWalki;
    private JLabel pktAtakuObrazek;
    private JLabel pktObronyObrazek;
    private JLabel pktZdrowiaObrazek;
    private JLabel pktSzczesciaObrazek;
    private JLabel czyTeleportacjaObrazek;
    private JLabel napisWalka;
    private JLabel pktAtakuPrzeciwnikaObrazek;
    private JLabel pktObronyPrzeciwnikaObrazek;
    private JLabel pktZdrowiaPrzeciwnikaObrazek;
    private JLabel czyStrasznyObrazek;
    private JButton ucieczka;
    private JButton atak;
    private JLabel bohaterObrazek;
    private JLabel przeciwnikObrazek;
    private int ktoraWalka;

    public PoleWalki() {
        JFrame poleWalki = new JFrame("Gra");
        poleWalki.setContentPane(tloWalki);

        poleWalki.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        poleWalki.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                int result = JOptionPane.showConfirmDialog(poleWalki,
                        "Chcesz opuscic gre? Spowoduje to usuniecie aktualnego zapisu",
                        "Potwierdzenie zamkniecia",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    poleWalki.dispose();
                }
            }
        });
        ktoraWalka = 0;

        Color color = new Color(84, 149, 114);
        tloWalki.setBackground(color);
        poleWalki.pack();
        poleWalki.setLocationRelativeTo(null);
        poleWalki.setVisible(true);

        boolean czyStrasznyy = (Math.random() < 0.5);
        Przeciwnik przeciwnik = new Przeciwnik((int) (Math.random() * 30), ((int) (Math.random() * 30)), ((int) (Math.random() * 30)), ((int) (Math.random() * 100)), czyStrasznyy);

        Icon ata = new ImageIcon("ikonki/sword-wound.png");
        pktAtakuObrazek.setIcon(ata);
        Icon obron = new ImageIcon("ikonki/checked-shield.png");
        pktObronyObrazek.setIcon(obron);
        Icon zdrow = new ImageIcon("ikonki/health-normal.png");
        pktZdrowiaObrazek.setIcon(zdrow);
        Icon szczesc = new ImageIcon("ikonki/clover.png");
        pktSzczesciaObrazek.setIcon(szczesc);

        pktAtakuObrazek.setText("" + Main.bohater.getPktAtaku());
        pktObronyObrazek.setText("" + Main.bohater.getPktObrony());
        pktZdrowiaObrazek.setText("" + Main.bohater.getPktZdrowia());
        pktSzczesciaObrazek.setText("" + Main.bohater.getPktSzczescia());

        Icon ataP = new ImageIcon("ikonki/sword-wound.png");
        pktAtakuPrzeciwnikaObrazek.setIcon(ataP);
        pktAtakuPrzeciwnikaObrazek.setText(przeciwnik.getPktAtaku() + "  ");
        Icon obronP = new ImageIcon("ikonki/checked-shield.png");
        pktObronyPrzeciwnikaObrazek.setIcon(obronP);
        pktObronyPrzeciwnikaObrazek.setText(przeciwnik.getPktObrony() + "  ");
        Icon zdrowP = new ImageIcon("ikonki/health-normal.png");
        pktZdrowiaPrzeciwnikaObrazek.setIcon(zdrowP);
        pktZdrowiaPrzeciwnikaObrazek.setText(przeciwnik.getPktZdrowia() + "  ");
        Icon szczescP = new ImageIcon("ikonki/clover.png");
        pktSzczesciaObrazek.setIcon(szczescP);
        if (przeciwnik.isCzyStraszny()) {
            Icon straszny = new ImageIcon("ikonki/terror.png");
            czyStrasznyObrazek.setIcon(straszny);
            czyStrasznyObrazek.setText("    ");
        }

        Icon bohaterPhoto = new ImageIcon("ikonki/high-punch.png");
        bohaterObrazek.setIcon(bohaterPhoto);

        Icon przeciwnikPhoto;
        int jakiObrazek = (int) (Math.random() * 2);

        if (jakiObrazek == 0) przeciwnikPhoto = new ImageIcon("ikonki/bully-minion.png");
        else if (jakiObrazek == 2) przeciwnikPhoto = new ImageIcon("ikonki/werewolf.png");
        else przeciwnikPhoto = new ImageIcon("ikonki/wyvern.png");

        przeciwnikObrazek.setIcon(przeciwnikPhoto);


        atak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int zaIleBohater = ((int) ((Math.random()) * Main.bohater.getPktAtaku() + 0.5));
                JOptionPane.showMessageDialog(null, "Zaatakowales przeciwnika za " + zaIleBohater + " punktow!");

                if (zaIleBohater <= przeciwnik.getPktObrony()) {
                    przeciwnik.setPktObrony(przeciwnik.getPktObrony() - zaIleBohater);
                } else {
                    if (zaIleBohater >= przeciwnik.getPktZdrowia() + przeciwnik.getPktObrony()) {
                        przeciwnik.setPktZdrowia(0);
                        przeciwnik.setPktObrony(0);
                    } else if (zaIleBohater > przeciwnik.getPktObrony() && zaIleBohater < przeciwnik.getPktZdrowia()) {
                        int roznica = zaIleBohater - przeciwnik.getPktObrony();
                        przeciwnik.setPktObrony(0);
                        przeciwnik.setPktZdrowia(przeciwnik.getPktZdrowia() - roznica);
                    }
                }
                pktZdrowiaPrzeciwnikaObrazek.setText(przeciwnik.getPktZdrowia() + "");
                pktObronyPrzeciwnikaObrazek.setText(przeciwnik.getPktObrony() + "");

                if (przeciwnik.getPktZdrowia() == 0) {
                    Timer timer = new Timer(10, new ActionListener() {
                        private int deltaX = 1;
                        private int deltaY = 0;

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Container contentPane = poleWalki.getContentPane();
                            int x = przeciwnikObrazek.getX() + deltaX;
                            int y = przeciwnikObrazek.getY() + deltaY;


                            if (x > contentPane.getWidth() || x + przeciwnikObrazek.getWidth() < 0) {
                                ((Timer) e.getSource()).stop();
                            }

                            przeciwnikObrazek.setLocation(x, y);

                            Point point = new Point(801, 207);
                            if (przeciwnikObrazek.getLocation().equals(point) && Main.bohater.getPktZdrowia() > 0) {
                                int ileSzczescia=((int)(Math.random()*5));
                                int result = JOptionPane.showConfirmDialog(poleWalki,
                                        "Gratulacje, pokonales przeciwnika! \nZyskales " + przeciwnik.getPieniadze() + "$ i "+ileSzczescia+" punktow szczescia! \nChcesz zawalczyc z kolejnym?",
                                        "Hurra!",
                                        JOptionPane.YES_NO_OPTION);
                                Main.bohater.setPieniadze(Main.bohater.getPieniadze() + przeciwnik.getPieniadze());
                                Main.bohater.setPktSzczescia(Main.bohater.getPktSzczescia()+ileSzczescia);
                                if (result == JOptionPane.YES_OPTION) {
                                    poleWalki.dispose();
                                    new PoleWalki();
                                } else {
                                    poleWalki.dispose();
                                    new TloGlowne();
                                }
                            }

                        }

                    });
                    timer.start();
                }

                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                int zaIlePrzeciwnik = ((int) ((Math.random()) * przeciwnik.getPktAtaku() + 0.5));

                if (przeciwnik.getPktZdrowia() > 0) {
                    JOptionPane.showMessageDialog(null, "Przeciwnik zaatakowal za " + zaIlePrzeciwnik + " punktow!");

                    if (zaIlePrzeciwnik <= Main.bohater.getPktObrony()) {
                        Main.bohater.setPktObrony(Main.bohater.getPktObrony() - zaIlePrzeciwnik);
                    } else {
                        if (zaIlePrzeciwnik >= Main.bohater.getPktZdrowia() + Main.bohater.getPktObrony()) {
                            Main.bohater.setPktZdrowia(0);
                            Main.bohater.setPktObrony(0);
                        } else if (zaIlePrzeciwnik > Main.bohater.getPktObrony() && zaIlePrzeciwnik < Main.bohater.getPktZdrowia()) {
                            int roznica = zaIlePrzeciwnik - Main.bohater.getPktObrony();
                            Main.bohater.setPktObrony(0);
                            Main.bohater.setPktZdrowia(Main.bohater.getPktZdrowia() - roznica);
                        }
                    }
                    pktZdrowiaObrazek.setText(Main.bohater.getPktZdrowia() + "");
                    pktObronyObrazek.setText(Main.bohater.getPktObrony() + "");
                }
                if (Main.bohater.getPktZdrowia() == 0) {
                    Timer timer = new Timer(10, new ActionListener() {
                        private int deltaX = -1;
                        private int deltaY = 0;

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Container contentPane = poleWalki.getContentPane();
                            int x = bohaterObrazek.getX() + deltaX;
                            int y = bohaterObrazek.getY() + deltaY;


                            if (x > contentPane.getWidth() || x + bohaterObrazek.getWidth() < 0) {
                                ((Timer) e.getSource()).stop();
                            }

                            bohaterObrazek.setLocation(x, y);
                            System.out.println(bohaterObrazek.getLocation());

                            Point point = new Point(-201, 207);
                            if (bohaterObrazek.getLocation().equals(point)) {
                                JOptionPane.showMessageDialog(null, "<html>GAME OVER<br>Zacznij jeszcze raz!</html>");
                                poleWalki.dispose();

                                Main.bohater.setPktAtaku(20);
                                Main.bohater.setPktObrony(20);
                                Main.bohater.setPktZdrowia(20);
                                Main.bohater.setPieniadze(100);
                                Main.bohater.setPktSzczescia(0);
                                Main.bohater.setCzyUznany(false);
                                Main.bohater.setZdolnoscTeleportacji(false);

                                new EkranStartowy();
                            }

                        }

                    });
                    timer.start();
                }

            }


        });


        ucieczka.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(poleWalki,
                        "Chcesz sprobowac ucieczki?",
                        "Ucieczka!",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {

                    if (przeciwnik.isCzyStraszny()) {
                        JOptionPane.showMessageDialog(null, "Nie udalo sie uciec!\nPrzeciwnik jest straszny przez co musisz odrzucic jeden przedmiot!");
                        new WyrzucaniePrzedmiotow(2);
                    } else if (Math.random() + Math.random() * Main.bohater.getPktSzczescia() > 0.7) {
                        JOptionPane.showMessageDialog(null, "Udalo sie uciec!");
                        poleWalki.dispose();
                        new TloGlowne();
                    } else if (Main.bohater.isZdolnoscTeleportacji() == true) {
                        JOptionPane.showMessageDialog(null, "Udalo sie uciec za pomoca zdolnosci teleportacji!");
                        poleWalki.dispose();
                        new TloGlowne();
                    } else {
                        JOptionPane.showMessageDialog(null, "Nie udalo sie uciec!");
                        new WyrzucaniePrzedmiotow(2);
                    }
                }
            }
        });
    }
}
