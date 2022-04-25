public class BlackJackGame extends GameTable
{
    public void playGame()
    {
        boolean hideCard = false;
        int deals = 0;
        int score = 0;
        for(int i = 0; i < 6; i++)
        {
            handDealer.dealCard(); // do a ternary operation
            deals++;
        }
        printTable(deals, hideCard);
        score = findScore(deals);
        //System.out.println(score);
        //System.out.println(handDealer.checkCards(0));
        //String cardsDealer = String.valueOf(handDealer.checkCards());
        //System.out.println(cardsPlayer + cardsDealer);
    }
    
    public void menu()
    {
        //nothing
    }
    
    
    public int findScore(int deals)
    {
        int ace = 0;
        int score = 0;
        char value = 0;
        for(int cardNumber = 0; cardNumber < deals; cardNumber++) //for each
        {
            value = String.valueOf(handDealer.checkCards(cardNumber)).charAt(0);
            switch(value)
            {
                case 'A':
                    ace++;
                    break;
                case '2':
                    score += 2;
                    break;
                case '3':
                    score += 3;
                    break;
                case '4':
                    score += 4;
                    break;
                case '5':
                    score += 5;
                    break;
                case '6':
                    score += 6;
                    break;
                case '7':
                    score += 7;
                    break;
                case '8':
                    score += 8;
                    break;
                case '9':
                    score += 9;
                    break;
                case '1':
                case 'J':
                case 'Q':
                case 'K':
                    score += 10;
                    break;
                default:
                    score += 0;
            }
        }
        for(int i = 1; i <= ace; ace--)
        {
            if(score < 11)
                score += 11;
            else
                score += 1;
        }
        return score; //hit stand surrender
    }
    
    public boolean hideCardCheck(int deals)
    {
        if(deals == 1)
            return true;
        else
            return false;
    }
}

