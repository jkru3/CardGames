public class Card
{
    private final char face;
    private final String suit;
    
    public Card(char face, String suit)
    {
        this.face = face;
        this.suit = suit;
    }
    
    public String toString()
    {
        return face + suit;
    }
}