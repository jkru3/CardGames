import java.util.ArrayList;

public class Hand
{
    private static DeckOfCards myDeck = new DeckOfCards(); // must be static to make
    private ArrayList<Card> cardsInHand = new ArrayList<>();
    
    public Hand()
    {
        myDeck.initializeDeck();
        this.myDeck = myDeck;
        this.cardsInHand = cardsInHand;
    }
    
    public ArrayList<Card> checkCards()
    {
        cardsInHand.get(0);
        return cardsInHand;
    }
    //accessor to see size
    
    public Card dealCard()
    {
        Card topCard = myDeck.nextCard();
        cardsInHand.add(topCard);
        return topCard;
    }
    //your cards, dealers cards
}
