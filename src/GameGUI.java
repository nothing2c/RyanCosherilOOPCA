import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameGUI extends JFrame implements MouseListener{

    Container container;
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
    private JPanel yourMonsterZone1;
    private JPanel yourMonsterZone2;
    private JPanel yourMonsterZone3;
    private JPanel yourMonsterZone4;
    private JPanel yourMagicZone;
    private JPanel yourCard1;
    private JPanel yourCard2;
    private JPanel yourCard3;
    private JPanel yourCard4;
    private JPanel yourCard5;
    private JPanel yourDeck;


    public GameGUI(){
        setSize(1300,950);
        setLocationRelativeTo(null);
        setTitle("TCG Borne");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,1,0,5));

        container = getContentPane();
        container.setBackground(Color.lightGray);

        //start populate enemyHand
        enemyHand = new JPanel(new GridLayout(1,7,5,0));

        enemyDeck = new JPanel();
        enemyDeck.setBackground(Color.red);
        enemyHand.add(enemyDeck);

        padding = new JLabel();
        enemyHand.add(padding);

        enemyCard5 = new JPanel();
        enemyCard5.add(new MonsterCard("Cleric Beast",10,5));
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
        MonsterCard card1 = new MonsterCard("Cleric Beast",10,5);
        card1.addMouseListener(this);
        yourCard1.add(card1);
        yourHand.add(yourCard1);

        yourCard2 = new JPanel();
        yourHand.add(yourCard2);

        yourCard3 = new JPanel();
        yourHand.add(yourCard3);

        yourCard4 = new JPanel();
        yourHand.add(yourCard4);

        yourCard5 = new JPanel();
        yourHand.add(yourCard5);

        padding = new JLabel();
        yourHand.add(padding);

        yourDeck = new JPanel();
        yourDeck.setBackground(Color.green);
        yourHand.add(yourDeck);

        container.add(yourHand);
        //end populate your hand

        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        yourField.setBackground(Color.green);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        yourCard1.setBackground(Color.green);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        yourCard1.setBackground(container.getBackground());
    }
}
