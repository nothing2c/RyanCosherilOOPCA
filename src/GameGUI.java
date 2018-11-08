import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

//try using updateUI to change position of cards

public class GameGUI extends JFrame implements MouseListener{

    private Deck yourDeckOfCards = new Deck();
    private Deck enemyDeckOfCards = new Deck();
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
    private JPanel enemyDeck;
    private JPanel enemyCard5;
    private JPanel enemyCard4;
    private JPanel enemyCard3;
    private JPanel enemyCard2;
    private JPanel enemyCard1;
    private JPanel enemyMagicZone;
    private JPanel enemyMonsterZone4;
    private JPanel enemyMonsterZone3;
    private JPanel enemyMonsterZone2;
    private JPanel enemyMonsterZone1;
    private MonsterCard enemyCardZone1;
    private JPanel yourMonsterZone1;
    private MonsterCard cardZone1;
    private JPanel yourMonsterZone2;
    private Card cardZone2;
    private JPanel yourMonsterZone3;
    private Card cardZone3;
    private JPanel yourMonsterZone4;
    private Card cardZone4;
    private JPanel yourMagicZone;
    private Card cardMagic;
    private JPanel yourCard1;
    private Card card1;
    private JPanel yourCard2;
    private Card card2;
    private JPanel yourCard3;
    private Card card3;
    private JPanel yourCard4;
    private Card card4;
    private JPanel yourCard5;
    private Card card5;
    private JPanel yourDeck;


    public GameGUI(){
        setSize(1300,950);
        setLocationRelativeTo(null);
        setTitle("TCG Borne");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,1,0,5));

        container = getContentPane();

        //start populate enemyHand
        enemyHand = new JPanel(new GridLayout(1,7,5,0));

        enemyDeck = new Card();
        enemyCardCount = new JLabel(enemyDeckOfCards.getCurrentCards()+" / "+enemyDeckOfCards.getMaxNoCards());
        enemyDeck.add(enemyCardCount);
        enemyDeck.setBackground(Color.red);
        enemyHand.add(enemyDeck);

        padding = new JLabel();
        enemyHand.add(padding);

        enemyCard5 = new JPanel();
        enemyHand.add(enemyCard5);

        enemyCard4 = new JPanel();
        enemyHand.add(enemyCard4);

        enemyCard3 = new JPanel();
        enemyHand.add(enemyCard3);

        enemyCard2 = new JPanel();
        enemyHand.add(enemyCard2);

        enemyCard1 = new JPanel();
        enemyHand.add(enemyCard1);

        container.add(enemyHand);
        //end populate enemyHand

        //start populate enemyField
        enemyField = new JPanel(new GridLayout(1,7,5,0));

        padding = new JLabel();
        enemyField.add(padding);

        enemyMagicZone = new JPanel();
        enemyField.add(enemyMagicZone);

        enemyMonsterZone4 = new JPanel();
        enemyField.add(enemyMonsterZone4);

        enemyMonsterZone3 = new JPanel();
        enemyField.add(enemyMonsterZone3);

        enemyMonsterZone2 = new JPanel();
        enemyField.add(enemyMonsterZone2);

        enemyMonsterZone1 = new JPanel();
        enemyCardZone1 = (MonsterCard)enemyDeckOfCards.draw();
        enemyCardZone1.addMouseListener(this);
        enemyMonsterZone1.add(enemyCardZone1);
        enemyField.add(enemyMonsterZone1);

        padding = new JLabel();
        enemyField.add(padding);

        container.add(enemyField);
        //end populate enemyField

        //start populate yourField
        yourField = new JPanel(new GridLayout(1,7,5,0));

        padding = new JLabel();
        yourField.add(padding);

        yourMonsterZone1 = new JPanel();
        cardZone1 = (MonsterCard)yourDeckOfCards.draw();
        cardZone1.addMouseListener(this);
        yourMonsterZone1.add(cardZone1);
        yourField.add(yourMonsterZone1);

        yourMonsterZone2 = new JPanel();
        yourField.add(yourMonsterZone2);

        yourMonsterZone3 = new JPanel();
        yourField.add(yourMonsterZone3);

        yourMonsterZone4 = new JPanel();
        yourField.add(yourMonsterZone4);

        yourMagicZone = new JPanel();
        yourField.add(yourMagicZone);

        padding = new JLabel();
        yourField.add(padding);

        container.add(yourField);
        //end populate yourField

        //start populate your hand
        yourHand = new JPanel(new GridLayout(1,7,5,0));

        yourCard1 = new JPanel();
        card1 = yourDeckOfCards.draw();
        card1.addMouseListener(this);
        yourCard1.add(card1);
        yourHand.add(yourCard1);

        yourCard2 = new JPanel();
        card2 = yourDeckOfCards.draw();
        yourCard2.add(card2);
        yourHand.add(yourCard2);

        yourCard3 = new JPanel();
        card3 = yourDeckOfCards.draw();
        yourCard3.add(card3);
        yourHand.add(yourCard3);

        yourCard4 = new JPanel();
        card4 = yourDeckOfCards.draw();
        yourCard4.add(card4);
        yourHand.add(yourCard4);

        yourCard5 = new JPanel();
        card5 = yourDeckOfCards.draw();
        yourCard5.add(card5);
        yourHand.add(yourCard5);

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
        {
            yourCardCount.setText(yourDeckOfCards.getCurrentCards()+" / "+yourDeckOfCards.getMaxNoCards());
        }
    }

    public void attack(MonsterCard attacker, MonsterCard recipient){
        recipient.setHealth(recipient.getHealth()-attacker.getAttack());

        if(recipient.getHealth()<=0)
        {
            enemyMonsterZone1.remove(enemyCardZone1);
            enemyMonsterZone1.updateUI();
        }
        else
            recipient.setToolTipText(recipient.toString());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        /*if(e.getSource()==card1)
        {
            card1.setSelected(true);
            yourCard1.setBackground(Color.yellow);
            yourMonsterZone1.setBackground(Color.green);
        }

        if(e.getSource()==yourMonsterZone1)
        {
            if(card1.isSelected()) {
                cardZone1 = card1;
                yourMonsterZone1.add(cardZone1);
               // card1 = new Card();
               // card1.setSelected(false);
               // yourCard1.remove(card1);
                yourCard1.setBackground(container.getBackground());
                card1 = yourDeckOfCards.draw();
                yourCard1.repaint();
                yourCard1.add(card1);
                System.out.print(card1.toString());
                //yourCard1.repaint();
            }
        }*/

        if(e.getSource()==cardZone1){
            attacker = cardZone1;
            System.out.println(attacker.toString());
        }

        if(e.getSource()==enemyCardZone1)
        {
            recipient = enemyCardZone1;
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
        if(e.getSource()==card1)
        {
            if(!card1.isSelected())
                yourCard1.setBackground(Color.green);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==card1)
        {
            if(!card1.isSelected())
                yourCard1.setBackground(container.getBackground());
        }
    }
}
