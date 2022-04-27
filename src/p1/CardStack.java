// Joseph "Joey" Krueger
// 04/25/2022
// CS145
//
// CardStack is an object that defines card groupings. In this game there are 3
// Hand[0] is the dealers hand
// Hand[1] is the players hand
// deckModify allows Gametable to access the initialized deck, randomize it, shuffle it,
// and count how many cards are remaining in the deck

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
    
    public void initializeDeck() //setter; randomizes the deck at the beginning of the game
    {
        myDeck.initializeDeck();
    }
    
    public void shuffleDeck() //setter; shuffles the deck with queues
    {
        myDeck.shuffleDeck();
    }
    
    public int remainingCards() //getter; returns the integer of remaining cards in the deck left
    {
        return myDeck.remainingCards();
    }
}
