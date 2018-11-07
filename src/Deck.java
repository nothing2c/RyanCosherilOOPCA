import java.util.ArrayList;

public class Deck{

    ArrayList<Card> allCards;

    public Deck(){
        allCards = new ArrayList<>();

        MonsterCard maria = new MonsterCard("Maria.jpg", "Maria", 12,3);
        allCards.add(maria);

        MonsterCard vicarAmelia = new MonsterCard("VicarAmelia.jpg","Vicar Amelia",6,15);
        allCards.add(vicarAmelia);
    }

    public  Card get(String name){
        for(Card c : allCards)
        {
            if(c.getName().equals(name))
                return c;
        }
        return null;
    }
}
