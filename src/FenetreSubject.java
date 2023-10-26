import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FenetreSubject extends JFrame implements SubjectInterface {
    JLabel label = new JLabel();
    private String word;
    private List<ObserverInterface> fenetres;
    private JButton button;
    private JTextField text;

    public FenetreSubject() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(800, 600);
        this.word = "";
        this.fenetres = new ArrayList<>(); 
        this.button = new JButton("Send", null);
        this.text = new JTextField(30);

        /* On initialise notre JLabel */
        Font police = new Font("DS-digital", Font.TYPE1_FONT, 30);
        this.label.setFont(police);
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.label.setText("Entrez une lettre :");

        /* On initialise notre JTextField */
        this.text.setText(word);
        this.text.setHorizontalAlignment(SwingConstants.CENTER);
        

        /* On initialise notre JButton */
        this.button.setVerticalTextPosition(AbstractButton.BOTTOM);
        this.button.setHorizontalTextPosition(AbstractButton.CENTER);
        this.button.setMnemonic(KeyEvent.VK_D);
        this.button.setActionCommand("send");
        this.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if("send".equals(e.getActionCommand())) {
                    setWord(text.getText());
                }
            }
        });

        /* On ajoute le JLabel et notre JFrame */
        this.getContentPane().add(this.label, BorderLayout.NORTH);
        this.getContentPane().add(this.button, BorderLayout.SOUTH);
        this.getContentPane().add(this.text, BorderLayout.CENTER);
    }

    public void addObserver(ObserverInterface fenetre){
        fenetres.add(fenetre);
    }

    public void removeObserver(ObserverInterface fenetre){
        fenetres.remove(fenetre);
    }

    public void setWord(String word){
        this.word = word;
        for(ObserverInterface observer: this.fenetres){
            observer.update(this.word);
        }
    }
}
