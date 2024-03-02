import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class TloGlowne {
    private JPanel panel1;
    private JLabel tekstjakiestaty;
    private JLabel pieniadze;
    private JLabel pktAtaku;
    private JLabel pktObrony;
    private JLabel pktZdrowia;
    private JLabel pktSzczescia;
    private JLabel czyUznany;
    private JLabel czyTeleportacja;
    private JButton doSklepuButton;
    private JLabel poleHelm;
    private JLabel poleNapiersnik;
    private JLabel poleSpodnie;
    private JLabel poleMiecz;
    private JLabel poleLuk;
    private JLabel poleTopor;
    private JLabel poleJablko;
    private JLabel poleEliksir;
    private JButton wyjscieButton;

    public TloGlowne() {
        JFrame tloGlowne = new JFrame("Gra");
        tloGlowne.setContentPane(panel1);

        tloGlowne.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        tloGlowne.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                int result = JOptionPane.showConfirmDialog(tloGlowne,
                        "Chcesz opuscic gre? Spowoduje to usuniecie aktualnego zapisu",
                        "Potwierdzenie zamkniecia",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    tloGlowne.dispose();
                }
            }
        });

        Color color = new Color(84,149,114);
        panel1.setBackground(color);
        tloGlowne.pack();
        tloGlowne.setLocationRelativeTo(null);
        tloGlowne.setVisible(true);

        Icon pieniadz = new ImageIcon("ikonki/rupee.png");
        pieniadze.setIcon(pieniadz);
        Icon ata = new ImageIcon("ikonki/sword-wound.png");
        pktAtaku.setIcon(ata);
        Icon obron = new ImageIcon("ikonki/checked-shield.png");
        pktObrony.setIcon(obron);
        Icon zdrow = new ImageIcon("ikonki/health-normal.png");
        pktZdrowia.setIcon(zdrow);
        Icon szczesc = new ImageIcon("ikonki/clover.png");
        pktSzczescia.setIcon(szczesc);


        pieniadze.setText("Dukaty: "+Main.bohater.getPieniadze());
        pktAtaku.setText("Punkty Ataku: "+Main.bohater.getPktAtaku());
        pktObrony.setText("Punkty Obrony: "+Main.bohater.getPktObrony());
        pktZdrowia.setText("Punkty Zdrowia: "+Main.bohater.getPktZdrowia());
        pktSzczescia.setText("Punkty Szczescia: "+Main.bohater.getPktSzczescia());

        czyUznany.setText("uznany");
        czyTeleportacja.setText("zdolnosc teleportacji");
        poleMiecz.setText("Miecz");
        poleLuk.setText("Luk");
        poleTopor.setText("Topor");
        poleHelm.setText("Helm");
        poleNapiersnik.setText("Napiersnik");
        poleSpodnie.setText("Spodnie");


        if(Main.bohater.isCzyUznany()){
            Icon uznanie2 = new ImageIcon("ikonki/medallist2.png");
            czyUznany.setIcon(uznanie2);
        }else{
            Icon uznanie = new ImageIcon("ikonki/medallist.png");
            czyUznany.setIcon(uznanie);
        }

        if(Main.bohater.isZdolnoscTeleportacji()){
            Icon teleport2 = new ImageIcon("ikonki/teleport2.png");
            czyTeleportacja.setIcon(teleport2);
        }else{
            Icon teleport = new ImageIcon("ikonki/teleport.png");
            czyTeleportacja.setIcon(teleport);
        }

        if(Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Miecz"))) {
            Icon miecz2 = new ImageIcon("ikonki/gladius2.png");
            poleMiecz.setIcon(miecz2);
        }else{
            Icon miecz = new ImageIcon("ikonki/gladius.png");
            poleMiecz.setIcon(miecz);
        }

        if(Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Luk"))) {
            Icon luk2 = new ImageIcon("ikonki/high-shot2.png");
            poleLuk.setIcon(luk2);
        }else{
            Icon luk = new ImageIcon("ikonki/high-shot.png");
            poleLuk.setIcon(luk);
        }

        if(Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Topor"))) {
            Icon topor2 = new ImageIcon("ikonki/battle-axe2.png");
            poleTopor.setIcon(topor2);
        }else{
            Icon topor = new ImageIcon("ikonki/battle-axe.png");
            poleTopor.setIcon(topor);
        }

        if(Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Helm"))) {
            Icon helm2 = new ImageIcon("ikonki/dwarf-helmet2.png");
            poleHelm.setIcon(helm2);
        }else{
            Icon helm = new ImageIcon("ikonki/dwarf-helmet.png");
            poleHelm.setIcon(helm);
        }

        if(Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Napiersnik"))) {
            Icon napiersnik2 = new ImageIcon("ikonki/breastplate2.png");
            poleNapiersnik.setIcon(napiersnik2);
        }else{
            Icon napiersnik = new ImageIcon("ikonki/breastplate.png");
            poleNapiersnik.setIcon(napiersnik);
        }

        if(Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Spodnie"))) {
            Icon spodnie2 = new ImageIcon("ikonki/armored-pants2.png");
            poleSpodnie.setIcon(spodnie2);
        }else{
            Icon spodnie = new ImageIcon("ikonki/armored-pants.png");
            poleSpodnie.setIcon(spodnie);
        }


        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Chcesz opuscic gre? Spowoduje to usuniecie aktualnego zapisu", "Potwierdzenie zamkniecia", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    tloGlowne.dispose();
                    new EkranStartowy();
                    Main.bohater=new Bohater(20, 20, 20, 1000,0,false,false);
                }
            }
        });

        doSklepuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Sklep();
                tloGlowne.dispose();
            }
        });
    }

}
