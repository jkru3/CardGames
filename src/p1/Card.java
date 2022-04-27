// Joseph "Joey" Krueger
// 04/25/2022
// CS145
//
// This class is the main card object

package p1;

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