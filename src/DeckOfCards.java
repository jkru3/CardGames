import java.util.Random;

public class DeckOfCards
{
    
    private static final Random random = new Random();
    private static final int NUMBER_OF_CARDS = 52;
    
    private Card[] deck = new Card[NUMBER_OF_CARDS];
    private int currentCard = 0;
    
    public DeckOfCards() // constructor that initializes the deck
    {
        char[] faces =
                {'A', '2', '3', '4', '5', '6', '7', '8', '9', '1', // '1' is 10
                 'J', 'Q', 'K'};
        String[] suits       = {"Spades", "Diamonds", "Clovers", "Hearts"};
        
        for (int count = 0; count < deck.length; count++)
        {
            deck[count] = new Card(faces[count % 13], suits[count / 13]);
        }
    }
    
    public void initializeDeck()
    {
        this.currentCard = 0;
        
        for(int first = 0; first < deck.length; first++)
        {
            int second = random.nextInt(NUMBER_OF_CARDS);
            
            Card placeHolder = deck[first];
            deck[first] = deck[second];
            deck[second] = placeHolder;
        }
    }
    
    //priority queue shuffle method instead of randomized initializeDeck method here?
    
    public Card nextCard()
    {
        if (currentCard < deck.length)
        {
            return deck[currentCard++];
        } else {
            return null; //all cards dealt
        }
    }
    
    //public boolean isEmpty() {
      //  return //cards isempty
    //}
}

