package final_project;

/**
 *
 * @author Ben Turner
 */

import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackTest {
    static int money;
    static int currentBet;
    static int comTotal;
    static int playerTotal;
    
    // execute application
    public static void main(String[] args) {
        money = 100;
        while(money > 0) {
            playerTotal = 0;
            comTotal = 0;
            playHand();    
        }  
        cls();
        System.out.println("You ran out of money!");
        System.out.println("Game Over");
    }  
    
    public static int findCardValue(String cardFace, boolean busting) {
        int cardValue;
        switch(cardFace) {
            case "Ace":
                if (!busting) cardValue = 11;
                else cardValue = 1;
                break;
            case "Deuce":
                cardValue = 2;
                break;
            case "Three":
                cardValue = 3;
                break;
            case "Four":
                cardValue = 4;
                break;
            case "Five":
                cardValue = 5;
                break;
            case "Six":
                cardValue = 6;
                break;
            case "Seven":
                cardValue = 7;
                break;
            case "Eight":
                cardValue = 8;
                break;
            case "Nine":
                cardValue = 9;
                break;
            default:
                cardValue = 10;           
        }
        return cardValue;
    }
    
    public static void playHand() {
        Scanner userInput = new Scanner(System.in);
        int playing = 1;
        int playerChoice;
        boolean playerBust = false;
        boolean comBust = false;
        boolean doubleDown = false;
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        cls();
        currentBet = placeBet();
        ArrayList playerHand = new ArrayList();
        ArrayList comHand = new ArrayList();
        playerHand.add(deck.dealCard());
        comHand.add(deck.dealCard());
        playerHand.add(deck.dealCard());
        comHand.add(deck.dealCard());
        while (playing == 1) {
            showCurrentPlayState(playerHand, comHand, playing);
            if (playerTotal > 21) {
                System.out.println("Oops, you busted!");
                money -= currentBet;
                System.out.println("Remaining Funds: $" + money);
                playerBust = true;
                pressEnterToContinue();
                cls();
                break;
            }
            playerTotal = 0;
            comTotal = 0;
            if (!doubleDown) {
                System.out.print("""
                                 Choose an Action
                                 1. Hit
                                 2. Stand
                                 """);
            if (currentBet * 2 <= money) {
                System.out.println("3. Double Down");
            }
            System.out.print("Enter choice here: ");
            playerChoice = userInput.nextInt();
            }
            else
                playerChoice = 2;
            switch(playerChoice) {
                case 1:
                    playerHand.add(deck.dealCard());
                    break;
                case 2:
                    playing = 2;
                    break; 
                case 3:
                    currentBet *= 2;
                    playerHand.add(deck.dealCard());
                    doubleDown = true;
                    break;
            }
        }
        while (playing == 2) {
            showCurrentPlayState(playerHand, comHand, playing);
            comHand.add(deck.dealCard());
            if (comTotal >= 17) {
                if (comTotal > 21) {
                    comBust = true;
                }
                break;
            }
            comTotal = 0;
            playerTotal = 0;
        }
        if (comBust) {
            cls();
            money += currentBet;
            System.out.println("Dealer bust! You win!");
            System.out.println("Total Money: $" + money);
            pressEnterToContinue();
        }
        if (!playerBust && !comBust) {
            if (comTotal > playerTotal) {
                cls();
                money -= currentBet;
                System.out.println("You lose!");
                System.out.println("Total Money: $" + money);
                pressEnterToContinue();
            }
            else if (comTotal < playerTotal) {
                cls();
                money += currentBet;
                System.out.println("You win!");
                System.out.println("Total Money: $" + money);
                pressEnterToContinue();
        }
            else if (comTotal == playerTotal) {
                cls();
                System.out.println("You tied!");
                System.out.println("Total Money: $" + money);
                pressEnterToContinue();
            }
        }
    }
    
    public static int placeBet() {
        Scanner userInput = new Scanner(System.in);
        int bet = 0;
        int inputCheck = 0;
        while (inputCheck == 0) {
            System.out.println("Total Money: $" + money);
            System.out.print("Place your bet: ");
            bet = userInput.nextInt(); 
            if (bet > 0 && bet <= money) {
                inputCheck = 1;
            }
            else{
                cls();
                System.out.println("Invalid amount. Try again.");
            }
        }
        return bet;
    }
    
    public static void cls() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }
    
    public static void showCurrentPlayState(ArrayList<Card> playerHand, ArrayList<Card> comHand, int playing) {
        cls();
        System.out.println("Total Money: $" + money);
        System.out.println("Bet Amount: $" + currentBet);
        System.out.println();
        System.out.println("Dealer's Hand: ");
        if (playing == 1) System.out.println("Unrevealed Card"); 
        else {
            System.out.println(comHand.get(0));
            if (comTotal < 11) {
                comTotal += findCardValue(DeckOfCards.cardFace(comHand.get(0)), false);
            }
            else {
                comTotal += findCardValue(DeckOfCards.cardFace(comHand.get(0)), true);
            }
        }
        for (int i = 1; i < comHand.size(); i++) {
            System.out.println(comHand.get(i));
            if (comTotal < 11) {
                comTotal += findCardValue(DeckOfCards.cardFace(comHand.get(i)), false);
            }
            else {
                comTotal += findCardValue(DeckOfCards.cardFace(comHand.get(i)), true);
            }
        }
        System.out.println("Total: " + comTotal);
        System.out.println();
        System.out.println("Player's Hand: ");
        for (int i = 0; i < playerHand.size(); i++) {
            System.out.println(playerHand.get(i));
            if (playerTotal < 11) {
                playerTotal += findCardValue(DeckOfCards.cardFace(playerHand.get(i)), false);
            }
            else {
                playerTotal += findCardValue(DeckOfCards.cardFace(playerHand.get(i)), true);
            }   
        }
        System.out.println("Total: " + playerTotal);
        System.out.println();
        if (playing != 1) {
            pressEnterToContinue();
        }
    }

    private static void pressEnterToContinue() {
        System.out.println("Press Enter key to continue...");
        Scanner s = new Scanner(System.in);
        s.nextLine();
    }
}
