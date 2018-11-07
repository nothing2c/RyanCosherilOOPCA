import java.util.ArrayList;

public class Deck{

    private ArrayList<Card> allCards;
    private int maxNoCards;
    private int currentCards;

    public Deck(){
        allCards = new ArrayList<>();

        MonsterCard maria = new MonsterCard("Maria.jpg", "Maria", 12,3);
        allCards.add(maria);

        MonsterCard vicarAmelia = new MonsterCard("VicarAmelia.jpg","Vicar Amelia",6,15);
        allCards.add(vicarAmelia);

        MonsterCard maria2 = new MonsterCard("Maria.jpg", "Maria", 12,3);
        allCards.add(maria2);

        MonsterCard vicarAmelia2 = new MonsterCard("VicarAmelia.jpg","Vicar Amelia",6,15);
        allCards.add(vicarAmelia2);

        MonsterCard maria3 = new MonsterCard("Maria.jpg", "Maria", 12,3);
        allCards.add(maria3);

        MonsterCard vicarAmelia3 = new MonsterCard("VicarAmelia.jpg","Vicar Amelia",6,15);
        allCards.add(vicarAmelia3);

        MonsterCard maria4 = new MonsterCard("Maria.jpg", "Maria", 12,3);
        allCards.add(maria4);

        MonsterCard vicarAmelia4 = new MonsterCard("VicarAmelia.jpg","Vicar Amelia",6,15);
        allCards.add(vicarAmelia4);

        setMaxNoCards(allCards);
        setCurrentCards(maxNoCards);
    }

    public Card get(String name){
        for(Card c : allCards)
        {
            if(c.getName().equals(name))
                return c;
        }
        return null;
    }

    public void setMaxNoCards(ArrayList<Card> allCards) {
        this.maxNoCards = allCards.size();
    }

    public int getMaxNoCards() {
        return maxNoCards;
    }

    public void setCurrentCards(int numberOfCards) {
        this.currentCards = numberOfCards;
    }

    public int getCurrentCards() {
        return currentCards;
    }

    public Card draw(){
        Card nextCard = allCards.get(maxNoCards-currentCards);
        setCurrentCards(currentCards-1);
        return nextCard;
    }
}
