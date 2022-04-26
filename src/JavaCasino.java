// Joseph "Joey" Krueger
// 04/25/2022
// CS145
//
//

import java.util.*;

public class JavaCasino
{
    public static void main(String[] args)
    {
        Scanner   input     = new Scanner(System.in);
        BlackJack blackJack = new BlackJack();
        String    selection = "";
        do{
            instructions();
            selection = input.next();
            if(selection.charAt(0) == 'B' || selection.charAt(0) == 'b')
                ;
            blackJack.playGame(input);
            selection = "0"; //resets selection so user can pick a new choice
        }while(selection.charAt(0) == 'E' || selection.charAt(0) == 'e');
        System.out.println("goodbye");
    }
        //timer class
        //cleaner deck initialization and selectable deck of cards
        //for each loop
        //number of players variable
        //package
        //cleanup, rename, reformat, comments
        //a queue based shuffle function
        //Python
    
        //WISHLIST
        //see https://gist.github.com/MelissaBruno/cabf119e2f6573de4fe5
        //additional players
        //a wallet try/catch with a surrender option for half-loss bets
        //what is E?
    
    public static void instructions()
    {
        System.out.print("Welcome to Java Casino!\n");
        //timer()
        System.out.print("Here you can play a variety of games " +
                         "(so long as you can afford to)\n");
        //timer();
        System.out.print("What would you like to play?\n" +
                         "(B)lackJack or (E)xit: ");
    }
    
    
}