import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

//try using updateUI to change position of cards

public class GameGUI extends JFrame implements MouseListener{

    private Deck yourDeckOfCards;
    private Deck enemyDeckOfCards;

    private ArrayList<Card> enemyHeldCards;
    private ArrayList<Card> enemyMonsterCards;
    private ArrayList<Card> yourMonsterCards;
    private ArrayList<JPanel> yourMonsterSlots;
    private ArrayList<Card> yourHeldCards;

    private JLabel yourCardCount;
    private JLabel enemyCardCount;

    private MonsterCard attacker;
    private MonsterCard recipient;

    private Container container;

    private JPanel enemyHand;
    private JPanel enemyField;
    private JPanel yourField;
    private JPanel yourHand;
    private JLabel padding;
    private Card enemyDeck;
    private JPanel enemyCardSlot5;
    private Card enemyCard5;
    private JPanel enemyCardSlot4;
    private Card enemyCard4;
    private JPanel enemyCardSlot3;
    private Card enemyCard3;
    private JPanel enemyCardSlot2;
    private Card enemyCard2;
    private JPanel enemyCardSlot1;
    private Card enemyCard1;

    private JPanel enemyMagicSlot;
    private Card enemyMagicCard;
    private JPanel enemyMonsterSlot4;
    private Card enemyMonsterCard4;
    private JPanel enemyMonsterSlot3;
    private Card enemyMonsterCard3;
    private JPanel enemyMonsterSlot2;
    private Card enemyMonsterCard2;
    private JPanel enemyMonsterSlot1;
    private Card enemyMonsterCard1;

    private JPanel yourMonsterSlot1;
    private Card yourMonsterCard1;
    private JPanel yourMonsterSlot2;
    private Card yourMonsterCard2;
    private JPanel yourMonsterSlot3;
    private Card yourMonsterCard3;
    private JPanel yourMonsterSlot4;
    private Card yourMonsterCard4;
    private JPanel yourMagicSlot;
    private Card yourMagicCard;

    private JPanel yourCardSlot1;
    private Card yourCard1;
    private JPanel yourCardSlot2;
    private Card yourCard2;
    private JPanel yourCardSlot3;
    private Card yourCard3;
    private JPanel yourCardSlot4;
    private Card yourCard4;
    private JPanel yourCardSlot5;
    private Card yourCard5;
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

        //start populate enemyHand
        enemyHand = new JPanel(new GridLayout(1,7,5,0));
        enemyHeldCards = new ArrayList<>();

        enemyDeck = new Card();
        enemyCardCount = new JLabel(enemyDeckOfCards.getCurrentCards()+" / "+enemyDeckOfCards.getMaxNoCards());
        enemyDeck.add(enemyCardCount);
        enemyDeck.setBackground(Color.red);
        enemyHand.add(enemyDeck);

        padding = new JLabel();
        enemyHand.add(padding);

        enemyCardSlot5 = new JPanel();
        enemyCard5 = enemyDeckOfCards.draw();
        enemyCardSlot5.add(enemyCard5);
        enemyHeldCards.add(enemyCard5);
        enemyHand.add(enemyCardSlot5);

        enemyCardSlot4 = new JPanel();
        enemyCard4 = enemyDeckOfCards.draw();
        enemyCardSlot4.add(enemyCard4);
        enemyHeldCards.add(enemyCard4);
        enemyHand.add(enemyCardSlot4);

        enemyCardSlot3 = new JPanel();
        enemyCard3 = enemyDeckOfCards.draw();
        enemyCardSlot3.add(enemyCard3);
        enemyHeldCards.add(enemyCard3);
        enemyHand.add(enemyCardSlot3);

        enemyCardSlot2 = new JPanel();
        enemyCard2 = enemyDeckOfCards.draw();
        enemyCardSlot2.add(enemyCard2);
        enemyHeldCards.add(enemyCard2);
        enemyHand.add(enemyCardSlot2);

        enemyCardSlot1 = new JPanel();
        enemyCard1 = enemyDeckOfCards.draw();
        enemyCardSlot1.add(enemyCard1);
        enemyHeldCards.add(enemyCard1);
        enemyHand.add(enemyCardSlot1);

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
        yourMonsterSlot1.setBackground(Color.lightGray);
        yourMonsterSlot1.addMouseListener(this);
        yourMonsterSlots.add(yourMonsterSlot1);
        yourField.add(yourMonsterSlot1);

        yourMonsterSlot2 = new JPanel();
        yourMonsterSlot2.setBackground(Color.lightGray);
        yourMonsterSlot2.addMouseListener(this);
        yourMonsterSlots.add(yourMonsterSlot2);
        yourField.add(yourMonsterSlot2);

        yourMonsterSlot3 = new JPanel();
        yourMonsterSlot3.setBackground(Color.lightGray);
        yourMonsterSlot3.addMouseListener(this);
        yourMonsterSlots.add(yourMonsterSlot3);
        yourField.add(yourMonsterSlot3);

        yourMonsterSlot4 = new JPanel();
        yourMonsterSlot4.setBackground(Color.lightGray);
        yourMonsterSlot4.addMouseListener(this);
        yourMonsterSlots.add(yourMonsterSlot4);
        yourField.add(yourMonsterSlot4);

        yourMagicSlot = new JPanel();
        yourMagicSlot.setBackground(Color.gray);
        yourMagicSlot.addMouseListener(this);
        yourField.add(yourMagicSlot);

        padding = new JLabel();
        yourField.add(padding);

        container.add(yourField);
        //end populate yourField

        //start populate your hand
        yourHand = new JPanel(new GridLayout(1,7,5,0));
        yourHeldCards = new ArrayList<>();

        yourCardSlot1 = new JPanel();
        yourCard1 = yourDeckOfCards.draw();
        yourCard1.addMouseListener(this);
        yourHeldCards.add(yourCard1);
        yourCardSlot1.add(yourCard1);
        yourHand.add(yourCardSlot1);

        yourCardSlot2 = new JPanel();
        yourCard2 = yourDeckOfCards.draw();
        yourCard2.addMouseListener(this);
        yourHeldCards.add(yourCard2);
        yourCardSlot2.add(yourCard2);
        yourHand.add(yourCardSlot2);

        yourCardSlot3 = new JPanel();
        yourCard3 = yourDeckOfCards.draw();
        yourCard3.addMouseListener(this);
        yourHeldCards.add(yourCard3);
        yourCardSlot3.add(yourCard3);
        yourHand.add(yourCardSlot3);

        yourCardSlot4 = new JPanel();
        yourCard4 = yourDeckOfCards.draw();
        yourCard4.addMouseListener(this);
        yourHeldCards.add(yourCard4);
        yourCardSlot4.add(yourCard4);
        yourHand.add(yourCardSlot4);

        yourCardSlot5 = new JPanel();
        yourCard5 = yourDeckOfCards.draw();
        yourCard5.addMouseListener(this);
        yourHeldCards.add(yourCard5);
        yourCardSlot5.add(yourCard5);
        yourHand.add(yourCardSlot5);

        padding = new JLabel();
        yourHand.add(padding);

        yourDeck = new JPanel();
        yourCardCount = new JLabel(yourDeckOfCards.getCurrentCards()+" / "+yourDeckOfCards.getMaxNoCards());
        yourDeck.add(yourCardCount);
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
            enemyField.remove(recipient);
        else
            recipient.setToolTipText(recipient.toString());

        enemyField.updateUI();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==yourCard1)
        {
            yourCard1.setSelected(true);
            yourCard1.setBackground(Color.yellow);
        }

        if(e.getSource()==yourMonsterSlot1)
        {
            if(yourCard1.isSelected()) {
                System.out.println("Hi");
                yourCard1.setSelected(false);
                yourMonsterSlot1.add(yourCard1);
                yourField.updateUI();
                yourCardSlot1.remove(yourCard1);
                yourCard1.setBackground(container.getBackground());
                yourHand.updateUI();
            }
        }

        if(e.getSource()==yourMonsterCard1){
            attacker = (MonsterCard)yourCard1;
            System.out.println(attacker.toString());
        }

        if(e.getSource()==enemyMonsterCard1)
        {
            recipient = (MonsterCard)enemyMonsterCard1;
            System.out.println(recipient.toString());
            attack(attacker, recipient);
        }




        if(e.getSource()==yourDeck)
        {
            if(yourDeckOfCards.getCurrentCards()>0)
            {
                Card x = yourDeckOfCards.draw();
                updateCardCount(yourCardCount);
            }
            else
                JOptionPane.showMessageDialog(null,"No Cards Remaining");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==yourCard1)
        {
            if(!yourCard1.isSelected())
                yourCard1.setBackground(Color.green);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==yourCard1)
        {
            if(!yourCard1.isSelected())
                yourCard1.setBackground(container.getBackground());
        }
    }
}
