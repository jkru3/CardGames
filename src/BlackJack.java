// Joseph "Joey" Krueger
// 04/25/2022
// CS145
//
//

import java.util.Scanner;

public class BlackJack extends GameTable
{
    public void instructions()
    {
        System.out.print("\nWelcome to Blackjack\n");
        timer("", false, 1500);
        System.out.print("\tYou will be dealt 2 cards.\n" +
                          "\tThe Dealer will also be dealt 2 cards with one facing down.\n" +
                          "\tYou may choose to \"hit\" if you'd like to try for higher hand.");
        timer("", false, 1500);
        System.out.print("\tHowever, If you go over 21 or score equal to or less than " +
                          "the dealer, you lose");
        timer("", false, 1000);
        System.out.print("\tFace cards (J, Q, K) equal 10 and Aces equal 1 or 11\n" +
                          "\tWinning with 21 is \"Blackjack\" " +
                          "and worth 1.5x your bet!\n");
        timer("", false, 1250);
    }
    
    public void playGame(Scanner input)
    {
        String playAgain = "";
        String hitOrStand = "";
        
        instructions();
        do{
            int[] score = new int[2]; // this block deals the first 4 cards
            for(int i = 0; i < 4; i++)
                hand[i % 2].dealCard();
            printCards(false);
            score[0] = findScore(0);
            score[1] = findScore(1);
            
            do{ // Player's turn
                System.out.print("\n(H)it or (S)tand? ");
                hitOrStand = input.next();
                if(hitOrStand.charAt(0) == 'H' || hitOrStand.charAt(0) == 'h') {
                    timer("Player hits", true, 300);
                    System.out.println();
                    hand[1].dealCard();
                    printCards(false);
                }
                score[1] = findScore(1);
            }while(score[1] <= 21 && hitOrStand.charAt(0) != 'S' &&
                   hitOrStand.charAt(0) != 's');
            
            while(score [1] <= 21 && score[0] < 17 ||
                  score [1] <= 21 && score[1] > score[0]) // dealers turn
            {
                timer("Dealer draws", true, 300);
                System.out.println();
                hand[0].dealCard();
                printCards(true);
                score[0] = findScore(0);
            }
                // now the scores will be added up
            System.out.println();
            if(score[1] > 21) {
                System.out.println("Player goes bust");
                clearHands();
            } else if(score[0] > 21) {
                System.out.println("Dealer goes bust, Player wins!");
                clearHands();
            } else if(score[1] == 21 && score[0] < 21) {
                System.out.println("Blackjack!! Player wins!");
                clearHands();
            } else if(score[1] <= score[0]) {
                System.out.println("Dealer wins");
                clearHands();
            } else {
                System.out.println("Player wins!");
                clearHands();
            }
            timer("", false, 900);
            System.out.print("Play again? (Y)es or (N)o: ");
            playAgain = input.next();
            System.out.println();
        }while(playAgain.charAt(0) != 'N' && playAgain.charAt(0) != 'n');
    }
    
    public void printCards(boolean showCards) // See GameTable for the actual print functions
    {
        int spacing = hand[1].checkSize() * 8 - 13;
        System.out.print("Player's Hand");
        for(int s = 0; s < spacing; s++)
            System.out.print(" ");
        System.out.print("Dealer's Hand");
        System.out.println();
        
        for(int i = 0; i < (hand[0].checkSize() + hand[1].checkSize()); i++)
            System.out.printf(" ___    ");
        System.out.println();
        
        for(int c = 0; c < hand[1].checkSize(); c++)
            printTopOfCard(1, c, showCards);
        for(int c = 0; c < hand[0].checkSize(); c++)
            printTopOfCard(0, c, showCards);
        System.out.println();
        
        for(int c = 0; c < hand[1].checkSize(); c++)
            printMiddleOfCard(1, c, showCards);
        for(int c = 0; c < hand[0].checkSize(); c++)
            printMiddleOfCard(0, c, showCards);
        System.out.println();
        
        for(int c = 0; c < hand[1].checkSize(); c++)
            printBottomOfCard(1, c, showCards);
        for(int c = 0; c < hand[0].checkSize(); c++)
            printBottomOfCard(0, c, showCards);
        System.out.println();
    }
    
    private void timer(String string, boolean loading, int millis)
    {
        System.out.print(string);
        try
        {
            Thread.sleep(millis);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        if(loading){
            for(int i = 0; i < 3; i++){
                System.out.print(".");
                try
                {
                    Thread.sleep(millis);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.println();
    }
    
    public void clearHands()
    {
        hand[1].clearHand(); //could be turned into a for loop for all players
        hand[0].clearHand();
    }
    
    public int findScore(int player)
    {
        int aces = 0;
        int score = 0;
        char value = 0;
        for(int cardNumber = 0; cardNumber < hand[player].checkSize(); cardNumber++) //for each
        {
            value = String.valueOf(hand[player].checkCards(cardNumber)).charAt(0);
            switch(value)
            {
                case 'A':
                    aces++;
                    break;
                case '2':
                    score += 2;
                    break;
                case '3':
                    score += 3;
                    break;
                case '4':
                    score += 4;
                    break;
                case '5':
                    score += 5;
                    break;
                case '6':
                    score += 6;
                    break;
                case '7':
                    score += 7;
                    break;
                case '8':
                    score += 8;
                    break;
                case '9':
                    score += 9;
                    break;
                case '1':
                case 'J':
                case 'Q':
                case 'K':
                    score += 10;
                    break;
                default:
                    score += 0;
            }
        }
        for(int i = 1; i <= aces; aces--)
        {
            if(score < (12 - aces))
                score += 11;
            else
                score += 1;
        }
        return score; //hit stand surrender
    }
}

