public class GameTable
{
    protected Hand handDealer = new Hand();
    protected Hand handPlayer = new Hand();
    
    public GameTable()
    {
        this.handDealer = handDealer;
        this.handPlayer = handPlayer;
    }
    
    public void printTable(int deals, boolean hideCard)
    {
        int spacing = 0;
        if(deals > 2)
            spacing = (deals - 4) * 8 + 3;
        System.out.print("Player's Hand");
        for(int s = 0; s < spacing; s++)
            System.out.print(" ");
        System.out.print("Dealer's Hand");
        System.out.println();
        
        for(int i = 0; i < deals; i++)
            System.out.printf(" ___    ");
        System.out.println();
        
        for(int j = 0; j < deals; j++)
        {
            hideCard = hideCardCheck(j, deals);
            char   face = String.valueOf(handDealer.checkCards(j)).charAt(0);
            String upperFace;
            if(hideCard) {
                upperFace = "  ";
            } else if(face == 49) {
                upperFace = "10";
            } else {
                upperFace = face + " ";
            }
            System.out.printf("|%s |   ", upperFace);
        }
        System.out.println();
        for(int k = 0; k < deals; k++)
        {
            hideCard = hideCardCheck(k, deals);
            char   suit       = String.valueOf(handDealer.checkCards(k)).charAt(1);
            String suitSymbol = "";
            switch(suit){
                case 'S':
                    suitSymbol = "♤";
                    break;
                case 'D':
                    suitSymbol = "♢";
                    break;
                case 'C':
                    suitSymbol = "♧";
                    break;
                case 'H':
                    suitSymbol = "♡";
                    break;
            }
            if(hideCard)
                suitSymbol = "?";
            System.out.printf("| %s |   ", suitSymbol);
        }
        System.out.println();
        for(int l = 0; l < deals; l++)
        {
            hideCard = hideCardCheck(l, deals);
            char face = String.valueOf(handDealer.checkCards(l)).charAt(0);
            String lowerFace;
            if(hideCard) {
                lowerFace = "__";
            } else if(face == 49) {
                lowerFace = "10";
            } else {
                lowerFace = "_" + face;
            }
            System.out.printf("|_%s|   ", lowerFace);
        }
        System.out.println();
    }
    
    public boolean hideCardCheck(int hiddenCard, int deals)
    {
        if(hiddenCard == deals - 1)
            return true;
        else
            return false;
    }
}
