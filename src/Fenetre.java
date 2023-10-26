import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fenetre extends JFrame {
    JLabel label = new JLabel();

    public Fenetre() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(800, 600);

        /* On initialise notre JLabel */
        Font police = new Font("DS-digital", Font.TYPE1_FONT, 30);
        this.label.setFont(police);
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.label.setText("Fenetre");

        /* On ajoute le JLabel et notre JFrame */
        this.getContentPane().add(this.label, BorderLayout.CENTER);
    }
}