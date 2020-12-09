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


    //Creates an easy readable representation of cards
    public String toString() {
        String cardListOutput = "";
        int i = 0;
        for(Card aCard : this.cards){
            cardListOutput += "\n " + aCard.toString();
            i ++;
        }
        return cardListOutput;
    }

    //Gets Deck Size
    public int deckSize() {
        return this.cards.size();
    }

    // Move all cards from hands into main deck.
    public void moveAllToDeck(Deck moveTo){
        int thisDeckSize = this.cards.size();

        //puts cards into moveTo deck
        for(int i=0; i < thisDeckSize; i++) {
            moveTo.addCard(this.getCard(i));
        }
        for (int i = 0; i < thisDeckSize; i++){
            this.removeCard(0);
        }
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
        comingFrom.removeCard(0);
    }
    //return total value of cards in hand
    public int cardsValue() {
        int totalValue = 0;
        int aces = 0;

        for(Card aCard : this.cards){
            switch(aCard.getValue()){
                case TWO : totalValue += 2; break;
                case THREE : totalValue += 3; break;
                case FOUR : totalValue += 4; break;
                case FIVE : totalValue += 5; break;
                case SIX : totalValue += 6; break;
                case SEVEN : totalValue += 7; break;
                case EIGHT : totalValue += 8; break;
                case NINE : totalValue += 9; break;
                case TEN : totalValue += 10; break;
                case JACK : totalValue += 10; break;
                case QUEEN : totalValue += 10; break;
                case KING : totalValue += 10; break;
                case ACE : aces += 1; break;
            }
        }
        //Calculating value of aces
        for(int i = 0; i < aces; i++) {

            if(totalValue > 10){
                totalValue += 1;
            }
            else{
                totalValue += 11;
            }
        }

        return totalValue;
    }
}

