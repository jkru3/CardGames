import java.util.*;

public class TestDeck
{
    public static void main(String[] args)
    {
        //Scanner     input         = new Scanner();
    
        //instructions();
        BlackJackGame game = new BlackJackGame();
        //System.out.printf("\n\n");
        game.playGame();
    }
    
    public static void instructions()
    {
        System.out.printf("Welcome to blackjack\n" +
                          "You will be dealt 2 cards.\n" +
                          "The Dealer will also be dealt 2 cards with one facing down.\n" +
                          "You may choose to \"hit\" if you'd like to try for higher hand.\n" +
                          "However, If you go over 21 or score equal to or less than " +
                          "the dealer, you lose\n" +
                          "Face cards (J, Q, K) equal 10 and Aces equal 1 or 11\n" +
                          "Winning with 21 is \"Blackjack\"" +
                          " and worth 1.5x your bet!");
    }
}
