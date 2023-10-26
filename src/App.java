
public class App {
    public static void main(String[] args) throws Exception {
        FenetreSubject fenetreS = new FenetreSubject();
        fenetreS.setVisible(true);
        
        FenetreObserver fenetreO = new FenetreObserver();
        fenetreO.setVisible(true);
        fenetreS.addObserver(fenetreO);
    }
}