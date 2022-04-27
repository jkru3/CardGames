// Joseph "Joey" Krueger
// 04/25/2022
// CS145
//
// GameTable is only a subclass of BlackJack to receive the timer() method
// This class prints out cards into the console
// it also constructs all the "hands" that will be used in the game

package p1;
public class GameTable extends JavaCasino
{
    protected static int numberOfPlayers = 2;
    protected CardStack hand[]           = new CardStack[numberOfPlayers];
            // this cardstack initiallizes an array of players, each with their own hand
    protected CardStack deckModify       = new CardStack();
            // this cardstack lets BlackJack modify the deck
    
    public GameTable()
    {
        /*for(int i = 0; i < (1 + this.numberOfPlayers); i++){
            this.hand[i] = new Hand("inputName", null);
        }*/
        this.hand[0] = new CardStack("Dealer", null);
        this.hand[1] = new CardStack("Player", null);
    }
    
    public void printCards(
            boolean showCards) // See GameTable for the actual print functions
    {
        int spacing = hand[1].checkHandSize() * 8 - 8;
        System.out.print("Player's Hand");
        for(int s = 0; s < spacing; s++){
            System.out.print(" ");
        }
        System.out.print("Dealer's Hand");
        System.out.println();
    
        for(int i = 0; i < (hand[1].checkHandSize()); i++){
            System.out.printf(" ___    ");
        }
        System.out.print("     ");
        for(int i = 0; i < (hand[0].checkHandSize()); i++){
            System.out.printf(" ___    ");
        }
        System.out.println();
    
        for(int c = 0; c < hand[1].checkHandSize(); c++){
            printTopOfCard(1, c, showCards);
        }
        System.out.print("     ");
        for(int c = 0; c < hand[0].checkHandSize(); c++){
            printTopOfCard(0, c, showCards);
        }
        System.out.println();
    
        for(int c = 0; c < hand[1].checkHandSize(); c++){
            printMiddleOfCard(1, c, showCards);
        }
        System.out.print("     ");
        for(int c = 0; c < hand[0].checkHandSize(); c++){
            printMiddleOfCard(0, c, showCards);
        }
        System.out.println();
    
        for(int c = 0; c < hand[1].checkHandSize(); c++){
            printBottomOfCard(1, c, showCards);
        }
        System.out.print("     ");
        for(int c = 0; c < hand[0].checkHandSize(); c++){
            printBottomOfCard(0, c, showCards);
        }
        System.out.println();
    }
    
    public void printTopOfCard(int p, int c, boolean showCards)
    {
        boolean hideCard = hideCardCheck(p, c, showCards);
        char    face     = String.valueOf(hand[p].whatIsCard(c)).charAt(0);
        String  upperFace;
        if(hideCard) {
            upperFace = "  ";
        } else if(face == 49) {
            upperFace = "10";
        } else {
            upperFace = face + " ";
        }
        System.out.printf("|%s |   ", upperFace);
        
    }
    
    public void printMiddleOfCard(int p, int n, boolean showCards)
    {
        boolean hideCard   = hideCardCheck(p, n, showCards);
        char    suit       = String.valueOf(hand[p].whatIsCard(n)).charAt(1);
        String  suitSymbol = "";
        switch(suit){
            case 'S':
                suitSymbol = "♤";
                break;
            case 'D':
                suitSymbol = "♢";
                break;
            case 'C':
                suitSymbol = "♧";
                break;
            case 'H':
                suitSymbol = "♡";
                break;
        }
        if(hideCard) {
            suitSymbol = "?";
        }
        System.out.printf("| %s |   ", suitSymbol);
    }
    
    public void printBottomOfCard(int p, int n, boolean showCards)
    {
        boolean hideCard = hideCardCheck(p, n, showCards);
        char    face     = String.valueOf(hand[p].whatIsCard(n)).charAt(0);
        String  lowerFace;
        if(hideCard) {
            lowerFace = "__";
        } else if(face == 49) {
            lowerFace = "10";
        } else {
            lowerFace = "_" + face;
        }
        System.out.printf("|_%s|   ", lowerFace);
    }
    
    public boolean hideCardCheck(int p, int n, boolean showCards)
    {
        if(p == 0 && n == 1 && hand[0].checkHandSize() == 2 && !showCards) {
            return true;
        } else {
            return false;
        }
    }
}
