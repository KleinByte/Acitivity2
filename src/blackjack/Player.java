/**
 * An implementation of a blackjack player.
 * @Author : Jordyn Kleinheksel
 */
// package blackjack;

// import java.util.ArrayList;

// public class Player {
//     String name;
//     double money;
//     private ArrayList<Card> hand;

//     public Player(String name, double money) {
//         this.name = name;
//         this.money = money;
//         this.cards = new ArrayList<Card>();
//     }

//     @Override
//     public String toString() {
//         return "Player{" + "name='" + name + '\'' + ", money=" + money + '}';
//     }

//     public void addCard(Card card) {
//         hand.addCard(this.cards);
//     }

//     // public Card getCard(int cardOneOrTwo) {
//     //     return this.hand.getCard(cardOneOrTwo);
//     // }


//     public String getHand() {
//         return hand.toString();
//     }

//     public String getName() {
//         return name;
//     }


//     public double getMoney() {
//         return money;
//     }

//     public void subtractBet(double betAmount) {
//         this.money -= betAmount;
//     }

//     public void addBet(double betAmount) {
//         this.money += betAmount;
//     }

//     public String printPlayersHand() {
//         String stringHand = "";

//         for (Card oneCard : this.cards) {
//             stringHand += oneCard.getValue() + " of ";
//             stringHand += oneCard.getSuit() + "s, ";
//         }

//         return stringHand;
//     }

//     public int playerHandValue() {
//         int totalValue = 0;
//         int aces = 0;

//         for (Card aCard : this.hand) {
//             switch (aCard.getValue()) {
//                 case "2":
//                     totalValue += 2;
//                     break;
//                 case "3":
//                     totalValue += 3;
//                     break;
//                 case "4":
//                     totalValue += 4;
//                     break;
//                 case "5":
//                     totalValue += 5;
//                     break;
//                 case "6":
//                     totalValue += 6;
//                     break;
//                 case "7":
//                     totalValue += 7;
//                     break;
//                 case "8":
//                     totalValue += 8;
//                     break;
//                 case "9":
//                     totalValue += 9;
//                     break;
//                 case "10":
//                     totalValue += 10;
//                     break;
//                 case "Jack":
//                     totalValue += 10;
//                     break;
//                 case "Queen":
//                     totalValue += 10;
//                     break;
//                 case "King":
//                     totalValue += 10;
//                     break;
//                 case "Ace":
//                     aces += 1;
//                     break;
//             }
//         }

//         for (int i = 0; i < aces; i++) {
//             if (totalValue > 10) {
//                 totalValue += 1;
//             } else {
//                 totalValue += 11;
//             }
//         }

//         return totalValue;

//     }
// }