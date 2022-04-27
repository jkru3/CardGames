// Joseph "Joey" Krueger
// 04/25/2022
// CS145
//
//

package p1;

import java.util.ArrayList;

public class CardStack
{
    private String          name;
    private ArrayList<Card> cardsInHand = new ArrayList<>();
    
    protected static DeckOfCards myDeck = new DeckOfCards();
    
    public CardStack(String name,
                     Card cardsInHand) // first constructor, used for the players hands
    {
        this.myDeck = myDeck;
        this.name   = name;
    }
    
    public Card whatIsCard(int cardNumber)
                                //getter; returns card face and suit at a given index
    {
        return cardsInHand.get(cardNumber);
    }
    
    public int checkHandSize() //getter, lets GameTable know how many times to print cards
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
    
    public void clearHand() //setter; clears players hand at the end of a round
    {
        cardsInHand.removeAll(cardsInHand);
    }
    
    
    public CardStack() //second constructor for deck modifications
    {
        this.myDeck = myDeck;
    }
    
    public void initializeDeck() //randomizes the deck at the beginning of the game
    {
        myDeck.initializeDeck();
    }
    
    public int remainingCards() //returns the integer of remaining cards in the deck left
    {
        return myDeck.remainingCards();
    }
    
    public void shuffleDeck() //shuffles the deck with queues
    {
        myDeck.shuffleDeck();
    }
}
