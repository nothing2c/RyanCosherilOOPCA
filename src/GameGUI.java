import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GameGUI extends JFrame implements MouseListener{

    private Deck yourDeckOfCards;
    private Deck enemyDeckOfCards;

    private int yourHealth;
    private JLabel yourHealthDisplay;
    private int enemyHealth;
    private JLabel enemyHealthDisplay;

    private JPanel graveYard;//used to remove killed monster cards from the field

    private ArrayList<Card> enemyHeldCards;
    private ArrayList<Card> enemyMonsterCards;
    private ArrayList<Card> yourMonsterCards;
    private ArrayList<JPanel> yourMonsterSlots;
    private ArrayList<Card> yourHeldCards;
    private ArrayList<JPanel> yourEmptyHeldSlots;

    private JLabel yourCardCount;
    private JLabel enemyCardCount;

    private MonsterCard attacker;
    private MonsterCard recipient;

    private Container container;

    private Card card;

    private JPanel enemyHand;
    private JPanel enemyField;
    private JPanel yourField;
    private JPanel yourHand;

    private JLabel padding;

    private JPanel enemyDeck;
    private JPanel enemyCardSlot5;
    private JPanel enemyCardSlot4;
    private JPanel enemyCardSlot3;
    private JPanel enemyCardSlot2;
    private JPanel enemyCardSlot1;

    private JPanel enemyMagicSlot;
    private JPanel enemyMonsterSlot4;
    private JPanel enemyMonsterSlot3;
    private JPanel enemyMonsterSlot2;
    private JPanel enemyMonsterSlot1;

    private JPanel yourMonsterSlot1;
    private JPanel yourMonsterSlot2;
    private JPanel yourMonsterSlot3;
    private JPanel yourMonsterSlot4;
    private JPanel yourMagicSlot;

    private JPanel yourCardSlot1;
    private JPanel yourCardSlot2;
    private JPanel yourCardSlot3;
    private JPanel yourCardSlot4;
    private JPanel yourCardSlot5;
    private JPanel yourDeck;

    public GameGUI(){
        setSize(1300,950);
        setLocationRelativeTo(null);
        setTitle("TCG Borne");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,1,0,5));

        container = getContentPane();

        yourDeckOfCards = new Deck();
        enemyDeckOfCards = new Deck();
        graveYard = new JPanel();

        yourHealth = 50;
        enemyHealth = 50;

        //start populate enemyHand
        enemyHand = new JPanel(new GridLayout(1,7,5,0));
        enemyHeldCards = new ArrayList<>();

        enemyDeck = new JPanel();
        enemyHealthDisplay = new JLabel("HP: "+enemyHealth);
        enemyDeck.add(enemyHealthDisplay);
        enemyDeck.setBackground(Color.red);
        enemyHand.add(enemyDeck);

        padding = new JLabel();
        enemyHand.add(padding);

        enemyCardSlot5 = new JPanel();
        card = enemyDeckOfCards.draw();
        enemyCardSlot5.add(card);
        enemyHeldCards.add(card);
        enemyHand.add(enemyCardSlot5);

        enemyCardSlot4 = new JPanel();
        card = enemyDeckOfCards.draw();
        enemyCardSlot4.add(card);
        enemyHeldCards.add(card);
        enemyHand.add(enemyCardSlot4);

        enemyCardSlot3 = new JPanel();
        card = enemyDeckOfCards.draw();
        enemyCardSlot3.add(card);
        enemyHeldCards.add(card);
        enemyHand.add(enemyCardSlot3);

        enemyCardSlot2 = new JPanel();
        card = enemyDeckOfCards.draw();
        enemyCardSlot2.add(card);
        enemyHeldCards.add(card);
        enemyHand.add(enemyCardSlot2);

        enemyCardSlot1 = new JPanel();
        card = enemyDeckOfCards.draw();
        enemyCardSlot1.add(card);
        enemyHeldCards.add(card);
        enemyHand.add(enemyCardSlot1);

        enemyCardCount = new JLabel(enemyDeckOfCards.getCurrentCards()+" / "+enemyDeckOfCards.getMaxNoCards());
        enemyDeck.add(enemyCardCount);

        container.add(enemyHand);
        //end populate enemyHand

        //start populate enemyField
        enemyField = new JPanel(new GridLayout(1,7,5,0));
        enemyMonsterCards = new ArrayList<>();

        padding = new JLabel();
        enemyField.add(padding);

        enemyMagicSlot = new JPanel();
        enemyField.add(enemyMagicSlot);

        enemyMonsterSlot4 = new JPanel();
        enemyField.add(enemyMonsterSlot4);

        enemyMonsterSlot3 = new JPanel();
        enemyField.add(enemyMonsterSlot3);

        enemyMonsterSlot2 = new JPanel();
        enemyField.add(enemyMonsterSlot2);

        enemyMonsterSlot1 = new JPanel();
        card = enemyDeckOfCards.draw();
        card.addMouseListener(this);
        enemyMonsterCards.add(card);
        enemyMonsterSlot1.add(card);
        enemyField.add(enemyMonsterSlot1);

        padding = new JLabel();
        enemyField.add(padding);

        container.add(enemyField);
        //end populate enemyField

        //start populate yourField
        yourField = new JPanel(new GridLayout(1,7,5,0));
        yourMonsterCards = new ArrayList<>();
        yourMonsterSlots = new ArrayList<>();

        padding = new JLabel();
        yourField.add(padding);

        yourMonsterSlot1 = new JPanel();
        yourMonsterSlot1.addMouseListener(this);
        yourMonsterSlots.add(yourMonsterSlot1);
        yourField.add(yourMonsterSlot1);

        yourMonsterSlot2 = new JPanel();
        yourMonsterSlot2.addMouseListener(this);
        yourMonsterSlots.add(yourMonsterSlot2);
        yourField.add(yourMonsterSlot2);

        yourMonsterSlot3 = new JPanel();
        yourMonsterSlot3.addMouseListener(this);
        yourMonsterSlots.add(yourMonsterSlot3);
        yourField.add(yourMonsterSlot3);

        yourMonsterSlot4 = new JPanel();
        yourMonsterSlot4.addMouseListener(this);
        yourMonsterSlots.add(yourMonsterSlot4);
        yourField.add(yourMonsterSlot4);

        yourMagicSlot = new JPanel();
        yourMagicSlot.addMouseListener(this);
        yourField.add(yourMagicSlot);

        padding = new JLabel();
        yourField.add(padding);

        container.add(yourField);
        //end populate yourField

        //start populate your hand
        yourHand = new JPanel(new GridLayout(1,7,5,0));
        yourHeldCards = new ArrayList<>();
        yourEmptyHeldSlots = new ArrayList<>();

        yourCardSlot1 = new JPanel();
        card = yourDeckOfCards.draw();
        card.addMouseListener(this);
        yourHeldCards.add(card);
        yourCardSlot1.add(card);
        yourHand.add(yourCardSlot1);

        yourCardSlot2 = new JPanel();
        card = yourDeckOfCards.draw();
        card.addMouseListener(this);
        yourHeldCards.add(card);
        yourCardSlot2.add(card);
        yourHand.add(yourCardSlot2);

        yourCardSlot3 = new JPanel();
        card = yourDeckOfCards.draw();
        card.addMouseListener(this);
        yourHeldCards.add(card);
        yourCardSlot3.add(card);
        yourHand.add(yourCardSlot3);

        yourCardSlot4 = new JPanel();
        card = yourDeckOfCards.draw();
        card.addMouseListener(this);
        yourHeldCards.add(card);
        yourCardSlot4.add(card);
        yourHand.add(yourCardSlot4);

        yourCardSlot5 = new JPanel();
        card = yourDeckOfCards.draw();
        card.addMouseListener(this);
        yourHeldCards.add(card);
        yourCardSlot5.add(card);
        yourHand.add(yourCardSlot5);

        padding = new JLabel();
        yourHand.add(padding);

        yourDeck = new JPanel();
        yourCardCount = new JLabel(yourDeckOfCards.getCurrentCards()+" / "+yourDeckOfCards.getMaxNoCards());
        yourDeck.add(yourCardCount);
        yourHealthDisplay = new JLabel("HP: "+yourHealth);
        yourDeck.add(yourHealthDisplay);
        yourDeck.addMouseListener(this);
        yourDeck.setBackground(Color.green);
        yourHand.add(yourDeck);

        container.add(yourHand);
        //end populate your hand

        setVisible(true);
    }

    public void updateCardCount(JLabel cardCount){
        if(cardCount == yourCardCount)
            yourCardCount.setText(yourDeckOfCards.getCurrentCards()+" / "+yourDeckOfCards.getMaxNoCards());
    }

    public void attack(MonsterCard attacker, MonsterCard recipient){
        recipient.setHealth(recipient.getHealth()-attacker.getAttack());

        if(recipient.getHealth()<=0)
        {
            graveYard.add(recipient);
            updateEnemyHealth();
            if(enemyHealth<=0)
                JOptionPane.showMessageDialog(null,"You Win!");
        }
        else
            recipient.setToolTipText(recipient.toString());

        attacker.setSelected(false);
        this.attacker=null;
        this.recipient=null;
        enemyField.updateUI();
    }

    public void updateEnemyHealth()
    {
        enemyHealth += recipient.getHealth();
        if(enemyHealth<0)
            enemyHealth=0;
        enemyHealthDisplay.setText("HP: "+enemyHealth);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(Card c : yourHeldCards)//start card select event handling
        {
            if(e.getSource()==c)
            {
                for(Card x : yourHeldCards)//used to deselect any cards that may have been previously selected
                {
                    if(x.isSelected())
                    {
                        x.setSelected(false);
                    }
                }
                c.setSelected(true);

                if(c instanceof MagicCard)
                {
                    yourEmptyHeldSlots.add((JPanel)c.getParent());
                    System.out.print(c.toString());
                    yourMagicSlot.add(c);
                    yourHand.updateUI();
                    JOptionPane.showMessageDialog(null,"wait");
                    c.setSelected(false);
                    graveYard.add(c);
                    yourField.updateUI();
                }

                else if(!c.isInPlay())
                {
                    for(JPanel j : yourMonsterSlots)
                    {
                        j.setBackground(Color.green);
                    }
                }
            }
        }//end card select event handling

        for(JPanel j : yourMonsterSlots)//start card play event handling
        {
            if(e.getSource()==j)
            {
                for(Card c : yourHeldCards)
                {
                    if(c.isSelected()&&!c.isInPlay())
                    {
                        yourEmptyHeldSlots.add((JPanel)c.getParent());
                        c.setSelected(false);
                        c.setInPlay(true);
                        j.add(c);
                        yourMonsterCards.add(c);
                        yourField.updateUI();
                        yourHand.updateUI();

                        for(JPanel p: yourMonsterSlots)
                        {
                            p.setBackground(container.getBackground());
                        }

                    }
                }
            }
        }//end card play event handling

        for(Card c : yourMonsterCards)//start attack event handling
        {
            if(e.getSource()==c && c.isInPlay())
            {
                attacker = (MonsterCard)c;

                if(enemyMonsterCards.size()==0)
                {
                    JOptionPane.showMessageDialog(null,"Direct Attack");
                    recipient = new MonsterCard("","",0,0);
                    attack(attacker,recipient);
                }
            }
        }

        for(Card c : enemyMonsterCards)
        {
            if(e.getSource()==c && attacker!=null)
            {
                recipient=(MonsterCard)c;
                attack(attacker,recipient);
            }
        }//end card attack handling

        if(e.getSource()==yourDeck)//start deck event handling
        {
            if(yourDeckOfCards.getCurrentCards()>0)
            {
                if(yourEmptyHeldSlots.size()>0)
                {
                    JPanel temp = yourEmptyHeldSlots.get(0);
                    yourEmptyHeldSlots.remove(temp);
                    card = yourDeckOfCards.draw();
                    card.addMouseListener(this);
                    yourHeldCards.add(card);
                    temp.add(card);
                    updateCardCount(yourCardCount);
                }
                else
                    JOptionPane.showMessageDialog(null,"Your Hand Is Full");
            }
            else
                JOptionPane.showMessageDialog(null,"No Cards Remaining");
        }//end deck event handling
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        for(Card c : yourHeldCards)
        {
            if(e.getSource()==c)
            {
                if(!c.isSelected())
                {
                    c.setBackground(Color.green);
                }
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        for(Card c : yourHeldCards)
        {
            if(e.getSource()==c)
            {
                if(!c.isSelected())
                {
                    c.setBackground(container.getBackground());
                }
            }
        }
    }
}
