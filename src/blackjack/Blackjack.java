/*/ Author: Jordyn Kleinheksel
    Description: A simple game of blackjack to learn oop/objects/constructors/methods/polymorphism
/*/

package blackjack;

import java.util.Scanner;

public class Blackjack {

    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

    //Welcome Screen and initial game LOGIC
    System.out.println("Welcome to Blackjack!\n ======================");
    System.out.println("Don't lose all your money! :-)");
    System.out.println("------------------");
    //Creating Deck Object
    Deck shoeDeck = new Deck();
    Shoe shoe = new Shoe();
    shoe.makeShoe(shoeDeck);
    //Creating Hands Object
    Hand dealerHand = new Hand();
    Hand playerHand = new Hand();

    double playerMoney = 100; //Players Current Score/Money

    //GAME LOOP
    while(playerMoney > 0){
        shoeDeck.shuffle();
        System.out.println("Deck Has Been Shuffled.");
        System.out.println("------------------");
        //Take Bet, If player bets too high, they get kicked out.
        System.out.println("You have $"+ playerMoney + " , how much would you like to bet?");
        double playerBet = userInput.nextDouble();
        System.out.println("****************************************************************");
        boolean endRound = false;
        if(playerBet > playerMoney){
            System.out.println("You've bet more than you have,\n Thats.... CHEATING.... GUARDS!!");
            break;
        }

        //Start Dealing
        //Player gets two cards
        playerHand.draw(shoeDeck);
        playerHand.draw(shoeDeck);
        //Dealer gets cards
        dealerHand.draw(shoeDeck);
        dealerHand.draw(shoeDeck);

        //Loop for Hits
        while(true){
            // Player Hand
            System.out.println("Your hand:");
            System.out.println(playerHand.toString());
            System.out.println("------------------");
            System.out.println("Your hand value is: " + playerHand.cardsValue());
            System.out.println("==================\n");

            //Dealer Hand
            System.out.println("Dealer hand: " + dealerHand.getCard(0).toString() +" and [Hidden]");
            System.out.println("------------------");
            System.out.println("Dealer's Hand is valued at: " + dealerHand.cardsValue());
            System.out.println("==================\n");

            //Player Next Move

            System.out.println("Would you like to (1)Hit or (2)Stand?");
            int response = userInput.nextInt();
            System.out.println("----------------------------------------------");


            //Hit
            if (response == 1) {
                playerHand.draw(shoeDeck);
                System.out.println("You draw a : " + playerHand.getCard(playerHand.deckSize()-1).toString());
                //Bust and Remove Bet
                if(playerHand.cardsValue() > 21){
                    System.out.println("+++++++++++++++++++++");
                    System.out.println("YOU BUSTED. Currently valued at: " + playerHand.cardsValue());
                    System.out.println("+++++++++++++++++++++");

                    playerMoney -= playerBet;
                    endRound = true;
                    break;
                }
            }

            if(response == 2) {
                break;
            }
        }

        //Reveal Dealers Cards
        System.out.println("Dealer Cards: " + dealerHand.toString());
        System.out.println("------------------");
        //compare to player
        if((dealerHand.cardsValue() > playerHand.cardsValue()) && endRound == false) {

            System.out.println("Dealer wins!");
            playerMoney -= playerBet;
            endRound = true;
        }
        //Dealer Draws at 16, stand at 17
        while((dealerHand.cardsValue() < 17 ) && endRound == false) {
            dealerHand.draw(shoeDeck);
            System.out.println("Dealer Draws: " + dealerHand.getCard(dealerHand.deckSize()-1).toString());
            System.out.println("------------------");
        }
        //Display Value for Dealer
        System.out.println("Dealer's Hand is valued at: " + dealerHand.cardsValue());
        System.out.println("==================\n");
        //determine if dealer busted
        if((dealerHand.cardsValue()> 21 ) && endRound == false){
            System.out.println("+++++++++++++++++++++");
            System.out.println("DEALER BUSTED! You win!");
            System.out.println("+++++++++++++++++++++");
            playerMoney += playerBet;
            endRound = true;
        }

        //Determine if push
        if((playerHand.cardsValue() == dealerHand.cardsValue()) && endRound == false){
            System.out.println("Push");
            System.out.println("------------------");

            endRound = true;
        }

        if((playerHand.cardsValue() > dealerHand.cardsValue()) && endRound == false){
            System.out.println("YOU WIN THE HAND!");
            playerMoney += playerBet;
            endRound = true;
            System.out.println("------------------");
        }

        else if (endRound == false){
            System.out.println("YOU LOSE THE HAND!");
            playerMoney -= playerBet;
            endRound = true;
            System.out.println("------------------");
        }

        System.out.println("\nTaking cards from players and dealer.....\n");
        playerHand.moveAllToDeck(shoeDeck);
        dealerHand.moveAllToDeck(shoeDeck);

        System.out.println("End of hand.");
        System.out.println("------------------");
    }

    if(playerMoney <= 0){
        System.out.println("Game Over, Out of Money!\nBye!");
    }


    }
}
