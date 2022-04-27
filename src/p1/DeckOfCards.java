// Joseph "Joey" Krueger
// 04/25/2022
// CS145
//
// The only difference in this class from the one shown in class is cardsRemaining(),
// which is a Getter that returns the remaining number of cards in the deck and
// shuffleDeck, which uses Queues to split the deck into 2 "hands", and layer them,
// one on top of the other.

package p1;
import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DeckOfCards
{
    private static final Random random = new Random();
    private static int NUMBER_OF_DECKS = 1;
    private static final int NUMBER_OF_CARDS = 52;
    
    private Card[] deck = new Card[NUMBER_OF_CARDS * NUMBER_OF_DECKS];
    private int currentCard = 0;
    
    public DeckOfCards() //constructor that initializes all the cards in the deck
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
        this.currentCard = 0; //"clean slate" if the player plays a new game
        
        for(int first = 0; first < deck.length; first++)
        {
            int second = random.nextInt(NUMBER_OF_CARDS);
            
            Card placeHolder = deck[first];
            deck[first] = deck[second];
            deck[second] = placeHolder;
        }
    }
    
    public Card nextCard() //used for dealing
    {
        if(currentCard < deck.length) {
            return deck[currentCard++];
        } else {
            return null; //all cards dealt
        }
    }
    
    public int remainingCards() //returns the integer of remaining cards in the deck left
    {
        return currentCard;
    }
    
    public void shuffleDeck() //shuffles the deck with queues, not randomly!
    {
        this.currentCard = 0;
        Queue<Card> leftHand = new LinkedList<>();
        Queue<Card> rightHand = new LinkedList<>();
        for(int left = 0; left < 26; left++)
        {
            leftHand.offer(deck[left]);
        }
        for(int right = 26; right < 52; right++)
        {
            rightHand.offer(deck[right]);
        }
        for(int count = 0; count < (deck.length / 2); count++)
        {
            deck[0] = leftHand.poll();
            deck[count + 1] = rightHand.poll();
        }
    }
}

