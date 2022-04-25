public class Card
{
    private final String faceAndSuit; // two variables here!!
    
    public Card(char face, String suit)
    {
        this.faceAndSuit = face + " " + suit;
    }
    
    public String toString()
    {
        return faceAndSuit; // migrate blackjack game switchcase method over here
    }
}
