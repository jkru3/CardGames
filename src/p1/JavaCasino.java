// Joseph "Joey" Krueger
// 04/25/2022
// CS145
//
//

package p1;
import java.util.*;

public class JavaCasino
{
    public static void main(String[] args) throws InterruptedException
    {
        Scanner   input     = new Scanner(System.in);
        BlackJack blackJack = new BlackJack();
        //Rummy rummy = new Rummy(); future game build idea
        //Poker poker = new Poker(); future game build idea
        
        String selection = "";
        
        do{
            instructionsJavaCasino();
            selection = input.nextLine();
            if(selection.charAt(0) == 'B' || selection.charAt(0) == 'b')
                blackJack.playGame(input);
            //rummy.playGame(input); future game build
            //poker.playGame(input); future game build idea
        }while(selection.charAt(0) != 'E' || selection.charAt(0) != 'e');
        System.out.println("Goodbye");
    }
    
    public static void instructionsJavaCasino()
    {
        System.out.print("Welcome to Java Casino!\n\n");
        System.out.print("\tHere you can play a variety of games " +
                         "(so long as you can afford to)\n");
        System.out.print(
                "\tWhat would you like to play?\n\n" + "\t(B)lackJack or (E)xit: ");
    }
    
    public void timer(String string, boolean loading, int millis)
    {
        System.out.print(string);
        try{
            Thread.sleep(millis);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        if(loading) {
            for(int i = 0; i < 3; i++){
                System.out.print(".");
                try{
                    Thread.sleep(millis);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.println();
    }
}