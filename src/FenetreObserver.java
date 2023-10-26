import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FenetreObserver extends JFrame implements ObserverInterface{
    JLabel label = new JLabel();
    private String word;
    private String mask;
    private String guess;
    private int lives;

    public FenetreObserver() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setSize(800, 600);
        this.word = "observer";
        this.mask = "";
        for(int i = 0; i < word.length(); i++){
            mask += "*";
        }
        this.lives = 5;
        this.guess = "";

        /* On initialise notre JLabel */
        Font police = new Font("DS-digital", Font.TYPE1_FONT, 30);
        this.label.setFont(police);
        this.label.setHorizontalAlignment(JLabel.CENTER);
        updateLabel();

        /* On ajoute le JLabel et notre JFrame */
        this.getContentPane().add(this.label, BorderLayout.CENTER);
    }

    /* Observer update */
    public void update(String guess){
        this.setGuess(guess.substring(0, 1));
    }

    /* Game methods */    
    public void checkWord(){
        int pos = word.toLowerCase(getLocale()).indexOf(guess.toLowerCase());
        System.out.println(pos);
        if(pos == -1) decrementLives();
        else {
            mask = mask.substring(0, pos) + guess.toUpperCase(getLocale()) + mask.substring(pos+1);
            updateLabel();
        }
    }

    /* Getters & Setter */

    public void setLives(int lives){
        this.lives = lives;
    }

    public int getLives(){
        return lives;
    }

    public void setGuess(String guess){
        this.guess = guess;
        checkWord();
    }

    public String getGuess(){
        return guess;
    }

    public void setWord(String word){
        this.word = word;
        checkWord();
    }

    public void decrementLives(){
        this.lives--;
        if(lives < 0) {
            lives = 0;
            System.exit(0);
        }
        updateLabel();
    }

    public void updateLabel(){
        this.label.setText("Mot à deviner :\n " + mask + "\n Vies restantes :\n " + Integer.toString(getLives()));
    }
}
