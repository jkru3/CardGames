// Joseph "Joey" Krueger
// 04/25/2022
// CS145
//
// For this project, I wanted to make a program that I could also use for my portfolio
// I tried to make a game that I thought might be enjoyable to play but also easy to build upon
// It shouldn't crash.
// I incorperated Queues which are used to shuffle the deck, rather than randomize it
// I also used an ArrayList, switch-case, and try/catchs
// There is plenty more that could be done. I would have loved to incorporate more features
// but I just didn't have time
//
// I'm currently working on re-coding this in Python, which will be a 2nd language for me

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
        }while(selection.charAt(0) != 'E' && selection.charAt(0) != 'e');
        System.out.println("\nGoodbye");
    }
    
    public static void instructionsJavaCasino() //
    {
        System.out.print("Welcome to Java Casino!\n\n");
        //timer();
        System.out.print("\tHere you can play a variety of games " +
                         "(so long as you can afford to)\n");
        System.out.print(
                "\tWhat would you like to play?\n\n" + "\t(B)lackJack or (E)xit: ");
    }
    
    //I tried to put timer in the instructions. It didn't work because it is nestled
    //within main which is a static method
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