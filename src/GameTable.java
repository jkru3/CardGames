// Joseph "Joey" Krueger
// 04/25/2022
// CS145
//
// Aside from saving space, making GameTable a superclass of BlackJack

import java.util.Scanner;

public class GameTable
{
    protected static int numberOfPlayers = 1;
    protected Hand    hand[] = new Hand[numberOfPlayers + 1];
    
    public GameTable()
    {
        /*for(int i = 0; i < (1 + this.numberOfPlayers); i++){
            this.hand[i] = new Hand("inputName", null);
        }*/
        this.hand[0] = new Hand("Dealer", null);
        this.hand[1] = new Hand("Player", null);
    }
    
    public void printTopOfCard(int p, int c, boolean showCards)
    {
        boolean hideCard = hideCardCheck(p, c, showCards);
        char   face = String.valueOf(hand[p].checkCards(c)).charAt(0);
        String upperFace;
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
        boolean hideCard = hideCardCheck(p, n, showCards);
        char   suit = String.valueOf(hand[p].checkCards(n)).charAt(1);
        String suitSymbol = "";
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
        if(hideCard)
            suitSymbol = "?";
        System.out.printf("| %s |   ", suitSymbol);
    }
    
    public void printBottomOfCard(int p, int n, boolean showCards)
    {
        boolean hideCard = hideCardCheck(p, n, showCards);
        char   face = String.valueOf(hand[p].checkCards(n)).charAt(0);
        String lowerFace;
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
        if(p == 0 && n == 1 && hand[0].checkSize() == 2 && !showCards)
            return true;
        else
            return false;
    }
}
