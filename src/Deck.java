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

        MonsterCard bloodStarvedBeast = new MonsterCard("BSB.jpg", "Blood Starved Beast", 10,5);
        allCards.add(bloodStarvedBeast);

        MonsterCard ebrietas = new MonsterCard("Ebrietas.png","Ebrietas",12,10);
        allCards.add(ebrietas);

        MonsterCard ludwig = new MonsterCard("Ludwig.jpg", "Ludwig", 15,15);
        allCards.add(ludwig);

        MonsterCard orphan = new MonsterCard("Orphan.jpg","Orphan Of Kos",20,20);
        allCards.add(orphan);

        MonsterCard shadowOfYharnam = new MonsterCard("Shadow.png", "Shadow Of Yharnam", 5,5);
        allCards.add(shadowOfYharnam);

        MagicCard bloodVial = new MagicCard("Shadow.png","Blood Vial",CardEffect.heal);
        allCards.add(bloodVial);

        setMaxNoCards(allCards);
        setCurrentCards(maxNoCards);
        shuffle();
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

    private void shuffle()
    {
        for(int i=0; i<allCards.size(); i++)
        {
            int index = (int)(Math.random()*allCards.size());
            Card temp = allCards.get(index);
            Card temp2 = allCards.get(i);
            allCards.set(i,temp);
            allCards.set(index,temp2);
        }
    }
}
