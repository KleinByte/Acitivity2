package blackjack;

public class Driver {

    public static void main(String[] args) {

    //Welcome
    System.out.println("Welcome to Blackjack!");

    Deck playingDeck = new Deck();
    playingDeck.createFullDeck();
    playingDeck.shuffle();


    System.out.println(playingDeck);

    }

}
