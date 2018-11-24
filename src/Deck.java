import java.io.Serializable;
import java.util.ArrayList;

public class Deck implements Serializable {

    private ArrayList<Card> allCards;
    private int maxNoCards;
    private int currentCards;

    /**instantiates a new deck with pre-made cards*/
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

        MagicCard bloodVial = new MagicCard("BloodVial.jpg","Blood Vial",'h',"Heals the user for 10 points",10);
        allCards.add(bloodVial);

        MagicCard molotov = new MagicCard("Molotov.jpg","molotov",'d',"Damage the enemy for 10 points",10);
        allCards.add(molotov);

        setMaxNoCards();
        setCurrentCards(maxNoCards);
    }

    /**Returns all cards in the deck
     * @return all cards in the deck
     */
    public ArrayList<Card> getAllCards() {
        return allCards;
    }

    /**Sets the maximum number of cards in a deck*/
    public void setMaxNoCards() {
        this.maxNoCards = allCards.size();
    }

    /**Returns maximum number of cards for a deck
     * @return maximum number of cards for a deck
     */
    public int getMaxNoCards() {
        return maxNoCards;
    }

    /**Sets the current amount of cards in a deck*/
    public void setCurrentCards(int numberOfCards) {
        this.currentCards = numberOfCards;
    }

    /**Returns the current amount of cards in a deck
     * @return the current amount of cards in a deck
     */
    public int getCurrentCards() {
        return currentCards;
    }

    /**Adds a card to the deck and updates the maximum and current cards in the deck
     * @param card card to be added to the deck
     */
    public void addCard(Card card){
        if(card instanceof MonsterCard)
            allCards.add((MonsterCard)card);
        else
            allCards.add((MagicCard)card);

        setMaxNoCards();
        setCurrentCards(getMaxNoCards());
    }

    /**Removes a card from the deck and updates the maximum and current cards in the deck
     * @param name the name of the card to be removed
     * @return returns whether or not the card was removed
     */
    public boolean removeCard(String name){
        Card card;

        for(Card c : allCards)
        {
            if(c.getName().equals(name))
            {
                card=c;
                allCards.remove(card);
                setMaxNoCards();
                setCurrentCards(getMaxNoCards());
                return true;
            }
        }
        return false;
    }

    /**Returns the next card in the deck
     * @return the next card in the deck
     */
    public Card draw(){
        Card nextCard = allCards.get(maxNoCards-currentCards);
        setCurrentCards(currentCards-1);
        return nextCard;
    }

    /**Randomizes the index of all cards in the deck*/
    public void shuffle()
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
