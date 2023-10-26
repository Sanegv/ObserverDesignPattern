# Observer Design Pattern implementation

A simple implementation of the Observer Design Pattern, in the form of a hangman game.

---

## Structure

### App

This is where the main class is located. It doesn't do much, it just creates two windows,
one being the observer, the other being the subject, and it adds the observer in the subject's list. 

### Fenetre

This is an example window, that was provided for the exercise. 
It is not used per se in the project, but the two other classes are upgraded versions of this one.

### ObserverInterface

As the name suggests, it is the interface that will be implemented for any observer.
It only has one method: update(String guess), that listens to the SubjectInterface.

### SubjectInterface

Once again, pretty explicit name: this interface is the subject, and has three methods:
- addObserver(ObserverInterface);

which adds an observer to the list.

- removeObserver(ObserverInterface);

which removes an observer from the list.

- setWord(String word);

which warns all the observers of the list that an update occured.

### FenetreSubject

This class is an elaborate version of the class Fenetre, and implements SubjectInterface.
It consists of a label, a text field, and a button.
When the button is pressed, it warns the observers of the list of an update, and sends them the text in the text field.

### FenetreObserver

This class is an elaborate version of the class Fenetre, and implements ObserverInterface.
It only consists of a label that shows the masked word (for now, the word is always "Observer", not case sensitive).
When its subjects warns it of an update, it takes the first letter of the string it receives, and checks if it is in the word.
If so, it reveals the letter in the masked word, if not, it decrements the amount of lives the player has left.

## TODO
- fix: when a letter is present several times in the word, only the first one will be revealed, making it impossible to reveal the whole word.
- implement: when a word is entirely revealed (no more '*' char), the player wins.
- implement: a dicitonnary of more words, maybe the posibility for one player to choose a word that another player should guess
- implement: a slightly nicer UI, with separated labels in the FenetreSubject.

> note: this project's purpose was just to implement the Observer Design Pattern. 
I did not intend to make a real hangman, and I will most likely never implement this TODO list, or update this repo, unless I am bored someday.