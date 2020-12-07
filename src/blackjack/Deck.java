package blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    
    //instance
    private ArrayList<Card> cards;

    //constructor
    public Deck() {

        this.cards = new ArrayList<Card>();

    }

    public void createFullDeck() {

        //Card Generator

        for (Suit cardSuit : Suit.values()) {
            for(Value cardValue : Value.values()) {

                //Add 52 Cards to Deck
                this.cards.add(new Card(cardSuit,cardValue));
            }
        }
    }

    //Method to create random deck.
    public void shuffle() {

        ArrayList<Card> tempDeck = new ArrayList<Card>();

        Random random = new Random();
        int randCardIndex =0;
        int originalSize = this.cards.size();
        for(int i = 0; i < originalSize; i++) {
            //gen rand index
            randCardIndex = random.nextInt((this.cards.size() -1 -0 ) + 1) +0 ;
            tempDeck.add(this.cards.get(randCardIndex));

            //remove from original Deck
            this.cards.remove(randCardIndex);

        }
        this.cards = tempDeck;
    }



    public String toString() {
        String cardListOutput = "";
        int i = 0;
        for(Card aCard : this.cards){
            cardListOutput += "\n " + aCard.toString();
            i ++;
        }
        return cardListOutput;
    }

//--------------------------------------------------------------------------

    //Methods of Dealer
    public void removeCard(int i){
        this.cards.remove(i);
    }

    public Card getCard(int i) {
        return this.cards.get(i);
    }

    public void addCard(Card addCard){
        this.cards.add(addCard);
    }
    //Draws from requested deck
    public void draw(Deck comingFrom) {
        this.cards.add(comingFrom.getCard(0));
    }
}
