package blackjack;
import java.util.Scanner;

//Created a virtualized Shoe.(Gathers Multiple Decks and Shuffles them.)
public class Shoe extends Deck{

    public Deck makeShoe(Deck deck) {
        //constructor for shoe
        Scanner userInput = new Scanner(System.in);
        System.out.println("How many Decks would you like in the Shoe?");
        Integer numDecks = userInput.nextInt();

            for (int i = 0; i < numDecks; i++){
                deck.createFullDeck();
                }
        System.out.println("------------------------------------");
        System.out.println("You selected: " + numDecks + " Decks, for a total of " + deck.deckSize() + " Cards. ");
        System.out.println("------------------------------------");
        return deck;
    }
}