import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Objects;

public class WyrzucaniePrzedmiotow {
    private JCheckBox mieczCheckBox;
    private JCheckBox lukCheckBox;
    private JCheckBox toporCheckBox;
    private JCheckBox helmCheckBox;
    private JCheckBox spodnieCheckBox;
    private JCheckBox napiersnikCheckBox;
    private JPanel tloUsuwaniaPrzedmiotow;
    private JButton powrotButton;
    private JButton potwierdzButton;
    private JLabel mieczObrazek;
    private JLabel toporObrazek;
    private JLabel napiersnikObrazek;
    private JLabel lukObrazek;
    private JLabel helmObrazek;
    private JLabel spodnieObrazek;

    public WyrzucaniePrzedmiotow() {
        JFrame wyrzucaniePrzedmiotow = new JFrame("Gra");
        wyrzucaniePrzedmiotow.setContentPane(tloUsuwaniaPrzedmiotow);
        wyrzucaniePrzedmiotow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        wyrzucaniePrzedmiotow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                int result = JOptionPane.showConfirmDialog(wyrzucaniePrzedmiotow,
                        "Chcesz opuscic gre? Spowoduje to usuniecie aktualnego zapisu",
                        "Potwierdzenie zamkniecia",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    wyrzucaniePrzedmiotow.dispose();
                }
            }
        });
        Color color = new Color(84, 149, 114);
        tloUsuwaniaPrzedmiotow.setBackground(color);
        wyrzucaniePrzedmiotow.pack();
        wyrzucaniePrzedmiotow.setLocationRelativeTo(null);
        wyrzucaniePrzedmiotow.setVisible(true);


        if (Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Miecz"))) {
            Icon miecz = new ImageIcon("ikonki/gladius2.png");
            mieczObrazek.setIcon(miecz);
            Main.bohater.setPktAtaku(Main.bohater.getPktAtaku()-5);
        }

        if (Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Luk"))) {
            Icon luk = new ImageIcon("ikonki/high-shot2.png");
            lukObrazek.setIcon(luk);
            Main.bohater.setPktAtaku(Main.bohater.getPktAtaku()-8);
        }

        if (Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Topor"))) {
            Icon topor = new ImageIcon("ikonki/battle-axe2.png");
            toporObrazek.setIcon(topor);
            Main.bohater.setPktAtaku(Main.bohater.getPktAtaku()-15);
        }

        if (Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Helm"))) {
            Icon helm = new ImageIcon("ikonki/dwarf-helmet2.png");
            helmObrazek.setIcon(helm);
            Main.bohater.setPktObrony(Main.bohater.getPktObrony()-5);
        }

        if (Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Napiersnik"))) {
            Icon napiersnik = new ImageIcon("ikonki/breastplate2.png");
            napiersnikObrazek.setIcon(napiersnik);
            Main.bohater.setPktObrony(Main.bohater.getPktObrony()-10);
        }

        if (Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Spodnie"))) {
            Icon spodnie = new ImageIcon("ikonki/armored-pants2.png");
            spodnieObrazek.setIcon(spodnie);
            Main.bohater.setPktObrony(Main.bohater.getPktObrony()-15);
        }


        potwierdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz usunac te przedmioty? To nieodwracalne!", "Potwierdzenie", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    if (mieczCheckBox.isSelected()) {
                        int index = -1;
                        for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                            if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Miecz")) {
                                index = i;
                                Wyposazenie[] newWyposazenie = Main.bohater.getWyposazenie();
                                newWyposazenie[i] = new Wyposazenie(0, "null");
                                Main.bohater.setWyposazenie(newWyposazenie);
                            }
                        }
                    }
                    if (lukCheckBox.isSelected()) {
                        int index = -1;
                        for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                            if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Luk")) {
                                index = i;
                                Wyposazenie[] newWyposazenie = Main.bohater.getWyposazenie();
                                newWyposazenie[i] = new Wyposazenie(0, "null");
                                Main.bohater.setWyposazenie(newWyposazenie);
                            }
                        }
                    }
                    if (toporCheckBox.isSelected()) {
                        int index = -1;
                        for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                            if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Topor")) {
                                index = i;
                                Wyposazenie[] newWyposazenie = Main.bohater.getWyposazenie();
                                newWyposazenie[i] = new Wyposazenie(0, "null");
                                Main.bohater.setWyposazenie(newWyposazenie);
                            }
                        }
                    }
                    if (helmCheckBox.isSelected()) {
                        int index = -1;
                        for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                            if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Helm")) {
                                index = i;
                                Wyposazenie[] newWyposazenie = Main.bohater.getWyposazenie();
                                newWyposazenie[i] = new Wyposazenie(0, "null");
                                Main.bohater.setWyposazenie(newWyposazenie);
                            }
                        }
                    }
                    if (napiersnikCheckBox.isSelected()) {
                        int index = -1;
                        for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                            if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Napiersnik")) {
                                index = i;
                                Wyposazenie[] newWyposazenie = Main.bohater.getWyposazenie();
                                newWyposazenie[i] = new Wyposazenie(0, "null");
                                Main.bohater.setWyposazenie(newWyposazenie);
                            }
                        }
                    }
                    if (spodnieCheckBox.isSelected()) {
                        int index = -1;
                        for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                            if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Spodnie")) {
                                index = i;
                                Wyposazenie[] newWyposazenie = Main.bohater.getWyposazenie();
                                newWyposazenie[i] = new Wyposazenie(0, "null");
                                Main.bohater.setWyposazenie(newWyposazenie);
                            }
                        }
                    }
                    wyrzucaniePrzedmiotow.dispose();
                    new Sklep();
                }
            }
        });
        powrotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wyrzucaniePrzedmiotow.dispose();
                new Sklep();
            }
        });


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    }public WyrzucaniePrzedmiotow(int a) {
        JFrame wyrzucaniePrzedmiotow = new JFrame("Gra");
        wyrzucaniePrzedmiotow.setContentPane(tloUsuwaniaPrzedmiotow);
        wyrzucaniePrzedmiotow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        wyrzucaniePrzedmiotow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                int result = JOptionPane.showConfirmDialog(wyrzucaniePrzedmiotow,
                        "Chcesz opuscic gre? Spowoduje to usuniecie aktualnego zapisu",
                        "Potwierdzenie zamkniecia",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    wyrzucaniePrzedmiotow.dispose();
                }
            }
        });
        Color color = new Color(84, 149, 114);
        tloUsuwaniaPrzedmiotow.setBackground(color);
        wyrzucaniePrzedmiotow.pack();
        wyrzucaniePrzedmiotow.setLocationRelativeTo(null);
        wyrzucaniePrzedmiotow.setVisible(true);


        if (Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Miecz"))) {
            Icon miecz = new ImageIcon("ikonki/gladius2.png");
            mieczObrazek.setIcon(miecz);
            Main.bohater.setPktAtaku(Main.bohater.getPktAtaku()-5);
        }

        if (Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Luk"))) {
            Icon luk = new ImageIcon("ikonki/high-shot2.png");
            lukObrazek.setIcon(luk);
            Main.bohater.setPktAtaku(Main.bohater.getPktAtaku()-8);
        }

        if (Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Topor"))) {
            Icon topor = new ImageIcon("ikonki/battle-axe2.png");
            toporObrazek.setIcon(topor);
            Main.bohater.setPktAtaku(Main.bohater.getPktAtaku()-15);
        }

        if (Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Helm"))) {
            Icon helm = new ImageIcon("ikonki/dwarf-helmet2.png");
            helmObrazek.setIcon(helm);
            Main.bohater.setPktObrony(Main.bohater.getPktObrony()-5);
        }

        if (Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Napiersnik"))) {
            Icon napiersnik = new ImageIcon("ikonki/breastplate2.png");
            napiersnikObrazek.setIcon(napiersnik);
            Main.bohater.setPktObrony(Main.bohater.getPktObrony()-10);
        }

        if (Arrays.stream(Main.bohater.getWyposazenie()).anyMatch(e -> e.getNazwa().equals("Spodnie"))) {
            Icon spodnie = new ImageIcon("ikonki/armored-pants2.png");
            spodnieObrazek.setIcon(spodnie);
            Main.bohater.setPktObrony(Main.bohater.getPktObrony()-15);
        }


        potwierdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int czyCos=0;
                int ileNull=0;
                for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                    if(Main.bohater.getWyposazenie()[i].getNazwa().equals("null")){
                        ileNull++;
                    }
                }
                if(ileNull!=0) {
                    int result = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz usunac te przedmioty? To nieodwracalne!", "Potwierdzenie", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        if (mieczCheckBox.isSelected()) {
                            int index = -1;
                            czyCos++;
                            for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                                if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Miecz")) {
                                    index = i;
                                    Wyposazenie[] newWyposazenie = Main.bohater.getWyposazenie();
                                    newWyposazenie[i] = new Wyposazenie(0, "null");
                                    Main.bohater.setWyposazenie(newWyposazenie);
                                }
                            }
                        }
                        if (lukCheckBox.isSelected()) {
                            int index = -1;
                            czyCos++;
                            for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                                if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Luk")) {
                                    index = i;
                                    Wyposazenie[] newWyposazenie = Main.bohater.getWyposazenie();
                                    newWyposazenie[i] = new Wyposazenie(0, "null");
                                    Main.bohater.setWyposazenie(newWyposazenie);
                                }
                            }
                        }
                        if (toporCheckBox.isSelected()) {
                            int index = -1;
                            czyCos++;
                            for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                                if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Topor")) {
                                    index = i;
                                    Wyposazenie[] newWyposazenie = Main.bohater.getWyposazenie();
                                    newWyposazenie[i] = new Wyposazenie(0, "null");
                                    Main.bohater.setWyposazenie(newWyposazenie);
                                }
                            }
                        }
                        if (helmCheckBox.isSelected()) {
                            int index = -1;
                            czyCos++;
                            for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                                if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Helm")) {
                                    index = i;
                                    Wyposazenie[] newWyposazenie = Main.bohater.getWyposazenie();
                                    newWyposazenie[i] = new Wyposazenie(0, "null");
                                    Main.bohater.setWyposazenie(newWyposazenie);
                                }
                            }
                        }
                        if (napiersnikCheckBox.isSelected()) {
                            int index = -1;
                            czyCos++;
                            for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                                if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Napiersnik")) {
                                    index = i;
                                    Wyposazenie[] newWyposazenie = Main.bohater.getWyposazenie();
                                    newWyposazenie[i] = new Wyposazenie(0, "null");
                                    Main.bohater.setWyposazenie(newWyposazenie);
                                }
                            }
                        }
                        if (spodnieCheckBox.isSelected()) {
                            int index = -1;
                            czyCos++;
                            for (int i = 0; i < Main.bohater.getWyposazenie().length; i++) {
                                if (Objects.equals(Main.bohater.getWyposazenie()[i].getNazwa(), "Spodnie")) {
                                    index = i;
                                    Wyposazenie[] newWyposazenie = Main.bohater.getWyposazenie();
                                    newWyposazenie[i] = new Wyposazenie(0, "null");
                                    Main.bohater.setWyposazenie(newWyposazenie);
                                }
                            }
                        }


                        if (czyCos == 1 || ileNull == Main.bohater.getWyposazenie().length) {
                            wyrzucaniePrzedmiotow.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Musisz wybrac jeden przedmiot!");
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Brak przedmiotow! \nWracasz na pole walki!");
                    wyrzucaniePrzedmiotow.dispose();
                }
            }
        });
    }
}
