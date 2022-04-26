// Joseph "Joey" Krueger
// 04/25/2022
// CS145
//
//

import java.util.ArrayList;

public class Hand
{
    private static DeckOfCards myDeck = new DeckOfCards(); // must be static
    private String name;
    private ArrayList<Card> cardsInHand = new ArrayList<>();
    
    public Hand(String name, Card cardsInHand) // constructor, creates the deck from DeckOfCards
    {
        myDeck.initializeDeck();
        this.myDeck = myDeck;
        this.name = name;
    }
    
    public Card checkCards(int cardNumber) //getter; returns Card objects to GameTable
    {
        return cardsInHand.get(cardNumber);
    }
    
    public int checkSize() //getter, lets GameTable know how many times to print cards
    {
        return cardsInHand.size();
    }
    
    public void dealCard() //setter; deals cards from deck
    {
        Card newCard = myDeck.nextCard();
        //System.out.println(String.valueOf(newCard));
        cardsInHand.add(newCard);
        //return topCard;
    }
    
    public void clearHand() //setter; clears the hand at the end of a round
    {
        cardsInHand.removeAll(cardsInHand);
    }
}
