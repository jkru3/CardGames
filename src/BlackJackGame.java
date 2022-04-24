import com.sun.media.jfxmedia.events.PlayerEvent;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackGame
{
    //isEmpty
    //isFull
    //MENU
    
    private Hand handDealer = new Hand();
    private Hand handPlayer = new Hand();
    
    public BlackJackGame()
    {
        this.handDealer = handDealer;
        this.handPlayer = handPlayer;
        
        //input.nextLine()
    }
    
    public void playGame()
    {
        //deal();
        handDealer.dealCard();
        handPlayer.dealCard();
        handDealer.dealCard();
        handPlayer.dealCard();
        String cardsPlayer = String.valueOf(handPlayer.checkCards());
        String cardsDealer = String.valueOf(handDealer.checkCards());
        System.out.println(cardsPlayer + cardsDealer);
        //System.out.printf("yeet");
        //playGame(card);
        //card = handPlayer.dealCard();
        //playGame(card);
    }
    
    public void deal()
    {
        String card = "";
        for(int i = 0; i < 2; i++)
        {
            card = String.valueOf(handDealer.dealCard());
            dealCards(card);
            card = String.valueOf(handPlayer.dealCard());
            dealCards(card);
        }
        
    }
    
    public void dealCards(String card)
    {
            char   face = card.charAt(0);
            String upperFace;
            String lowerFace;
            if(face == 1) {
                upperFace = face + "0";
                lowerFace = face + "0";
            } else {
                upperFace = face + " ";
                lowerFace = "_" + face;
            }
            char   suit       = card.charAt(2);
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
            System.out.printf("%s%s ", face, suitSymbol);
    }
}

