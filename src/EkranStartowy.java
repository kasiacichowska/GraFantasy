import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class EkranStartowy {
    private JTextArea witamWMojejGrzeTextArea;
    private JPanel panel1;
    private JButton zaczynajmyButton;
    private JLabel obrazek1;

    public EkranStartowy() {
        JFrame startowy = new JFrame("Menu Glowne");
        startowy.setContentPane(panel1);
        startowy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("ikonki/aaa.gif");
        obrazek1.setIcon(icon);
        ImageIcon icon2 = new ImageIcon("ikonki/play-button.png");
        zaczynajmyButton.setIcon(icon2);
        startowy.pack();
        startowy.setLocationRelativeTo(null); // Wyśrodkowanie okna
        startowy.setVisible(true);


        zaczynajmyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startowy.dispose();
                new TloGlowne();
            }
        });
    }

}
