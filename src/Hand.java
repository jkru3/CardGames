import java.util.ArrayList;

public class Hand
{
    private static DeckOfCards myDeck = new DeckOfCards(); // must be static
    private ArrayList<Card> cardsInHand = new ArrayList<>();
    
    public Hand() // constructor, creates the deck from DeckOfCards
    {
        //myDeck.initializeDeck();
        this.myDeck = myDeck;
        this.cardsInHand = cardsInHand;
    }
    
    public Card checkCards() //accessor; returns Card objects to BlackJackGame
    {
        return cardsInHand.get(0);
    }
    
    public void dealCard() //mutator; deals cards from teck
    {
        Card newCard = myDeck.nextCard();
        //System.out.println(String.valueOf(newCard));
        cardsInHand.add(newCard);
        //return topCard;
    }
    
    //public int cardValue()
    {
    
    }
}
