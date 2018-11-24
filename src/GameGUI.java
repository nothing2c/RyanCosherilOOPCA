import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/*many methods require you to specify whether its you or the AI performing the action by using the
* boolean parameter 'yours*/
public class GameGUI extends JFrame{//main game

    ButtonEventHandler eventHandlerB;
    MouseEventHandler eventHandlerM;
    AI ai;
    private boolean yourTurn;//used to determine whether or not mouse events can be performed

    private Deck yourDeckOfCards;
    private Deck enemyDeckOfCards;

    private int yourHealth;
    private JLabel yourHealthDisplay;
    private int enemyHealth;
    private JLabel enemyHealthDisplay;

    private JButton endTurn;

    private JPanel graveYard;//used to remove killed monster cards from the field

    private ArrayList<Card> enemyHeldCards;                 //pretty sure half of the arrays are redundant but its to
    private ArrayList<JPanel> enemyEmptyHeldSlots;          //late for me to check (monsterCard arrays contain almost identical elements
    private ArrayList<Card> enemyMonsterCards;              //to heldCard arrays
    private ArrayList<JPanel>emptyMonsterSlots;
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
    private boolean drawnCard;              //these to boolean values are used to make sure
    private boolean playedMonster;          //the player plays by the rules

    private JPanel enemyHand;               //these are 4 broad
    private JPanel enemyField;              //JPanels that contain
    private JPanel yourField;               //each possible
    private JPanel yourHand;                //card slot

    private JLabel padding;//used to add empty space to grid layout

    private JTextArea damageLog;

    private JPanel enemyDeck;               //The following JLabels are used to set each possible slot for a card
    private JPanel enemyCardSlot5;          //(not sure if they all need unique references but not going to check)
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
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {// gotten from https://coderanch.com/t/632603/java/Prompt-Exit-Single-Frame-Application
            @Override
            public void windowClosing(WindowEvent event) {
                int choice=JOptionPane.showConfirmDialog(null,"Are you sure you want to exit");

                if(choice==JOptionPane.YES_OPTION)
                {
                    setVisible(false);
                    StartScreen gui = new StartScreen();
                }
            }
        });

        setResizable(false);
        setLayout(new GridLayout(4,1,0,5));

        container = getContentPane();

        if(EditDeckScreen.playDeckName==null)//checks if a deck is loaded to play. if not, instantiates a new Deck
            yourDeckOfCards=new Deck();
        else
            yourDeckOfCards = EditDeckScreen.load(EditDeckScreen.playDeckName);//loads deck based on the name of the last deck selected in EditDeckScreen

        yourDeckOfCards.shuffle();
        enemyDeckOfCards = new Deck();
        enemyDeckOfCards.shuffle();
        graveYard = new JPanel();
        eventHandlerB = new ButtonEventHandler();
        eventHandlerM = new MouseEventHandler();
        ai=new AI();

        yourHealth = 50;
        enemyHealth = 50;

        //start populate enemyHand
        enemyHand = new JPanel(new GridLayout(1,7,5,0));
        enemyHeldCards = new ArrayList<>();
        enemyEmptyHeldSlots = new ArrayList<>();

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
        emptyMonsterSlots = new ArrayList<>();

        padding = new JLabel();
        enemyField.add(padding);

        enemyMagicSlot = new JPanel();
        enemyField.add(enemyMagicSlot);

        enemyMonsterSlot4 = new JPanel();
        emptyMonsterSlots.add(enemyMonsterSlot4);
        enemyField.add(enemyMonsterSlot4);

        enemyMonsterSlot3 = new JPanel();
        emptyMonsterSlots.add(enemyMonsterSlot3);
        enemyField.add(enemyMonsterSlot3);

        enemyMonsterSlot2 = new JPanel();
        emptyMonsterSlots.add(enemyMonsterSlot2);
        enemyField.add(enemyMonsterSlot2);

        enemyMonsterSlot1 = new JPanel();
        emptyMonsterSlots.add(enemyMonsterSlot1);
        enemyField.add(enemyMonsterSlot1);

        damageLog = new JTextArea();
        damageLog.setBackground(Color.lightGray);
        damageLog.setEditable(false);
        damageLog.setText("Damage log\n");
        enemyField.add(damageLog);

        container.add(enemyField);
        //end populate enemyField

        //start populate yourField
        yourField = new JPanel(new GridLayout(1,7,5,0));
        yourMonsterCards = new ArrayList<>();
        yourMonsterSlots = new ArrayList<>();

        padding = new JLabel();
        yourField.add(padding);

        yourMonsterSlot1 = new JPanel();
        yourMonsterSlot1.addMouseListener(eventHandlerM);
        yourMonsterSlots.add(yourMonsterSlot1);
        yourField.add(yourMonsterSlot1);

        yourMonsterSlot2 = new JPanel();
        yourMonsterSlot2.addMouseListener(eventHandlerM);
        yourMonsterSlots.add(yourMonsterSlot2);
        yourField.add(yourMonsterSlot2);

        yourMonsterSlot3 = new JPanel();
        yourMonsterSlot3.addMouseListener(eventHandlerM);
        yourMonsterSlots.add(yourMonsterSlot3);
        yourField.add(yourMonsterSlot3);

        yourMonsterSlot4 = new JPanel();
        yourMonsterSlot4.addMouseListener(eventHandlerM);
        yourMonsterSlots.add(yourMonsterSlot4);
        yourField.add(yourMonsterSlot4);

        yourMagicSlot = new JPanel();
        yourMagicSlot.addMouseListener(eventHandlerM);
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
        card.addMouseListener(eventHandlerM);
        yourHeldCards.add(card);
        yourCardSlot1.add(card);
        yourHand.add(yourCardSlot1);

        yourCardSlot2 = new JPanel();
        card = yourDeckOfCards.draw();
        card.addMouseListener(eventHandlerM);
        yourHeldCards.add(card);
        yourCardSlot2.add(card);
        yourHand.add(yourCardSlot2);

        yourCardSlot3 = new JPanel();
        card = yourDeckOfCards.draw();
        card.addMouseListener(eventHandlerM);
        yourHeldCards.add(card);
        yourCardSlot3.add(card);
        yourHand.add(yourCardSlot3);

        yourCardSlot4 = new JPanel();
        card = yourDeckOfCards.draw();
        card.addMouseListener(eventHandlerM);
        yourHeldCards.add(card);
        yourCardSlot4.add(card);
        yourHand.add(yourCardSlot4);

        yourCardSlot5 = new JPanel();
        card = yourDeckOfCards.draw();
        card.addMouseListener(eventHandlerM);
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

        endTurn = new JButton("End Turn");
        endTurn.setSize(100,50);
        endTurn.addActionListener(eventHandlerB);
        yourDeck.add(endTurn);

        yourDeck.addMouseListener(eventHandlerM);
        yourDeck.setBackground(Color.green);
        yourHand.add(yourDeck);

        container.add(yourHand);
        //end populate your hand

        initializeYourTurn();

        setVisible(true);
    }

    public boolean canDrawCard(Deck deck, ArrayList emptySlots){//checks if slot is available in your hand and if there are cards left in the deck
        if(deck.getCurrentCards() > 0 && emptySlots.size() >0)
            return true;
        else
            return false;
    }

    public void drawCard(boolean yours){//removes card from deck and adds it to the respective heldCards Array
        if(yours)
        {
            JPanel temp = yourEmptyHeldSlots.get(0);
            yourEmptyHeldSlots.remove(temp);
            card = yourDeckOfCards.draw();
            card.addMouseListener(eventHandlerM);
            yourHeldCards.add(card);
            temp.add(card);
            drawnCard=true;
        }

        else
        {
            JPanel temp = enemyEmptyHeldSlots.get(0);
            enemyEmptyHeldSlots.remove(temp);
            card = enemyDeckOfCards.draw();
            card.addMouseListener(eventHandlerM);
            enemyHeldCards.add(card);
            temp.add(card);
        }
        updateCardCount(yours);//sets the card count display based on the boolean parameter of this method
    }

    public void updateCardCount(boolean yours){
        if(yours)
            yourCardCount.setText(yourDeckOfCards.getCurrentCards()+" / "+yourDeckOfCards.getMaxNoCards());
        else
            enemyCardCount.setText(enemyDeckOfCards.getCurrentCards()+" / "+enemyDeckOfCards.getMaxNoCards());
    }

    public void setAttacker(MonsterCard attacker) {
        this.attacker = attacker;
    }

    public void setRecipient(MonsterCard recipient) {
        this.recipient = recipient;
    }


    public void destroy (MonsterCard deadCard, boolean yours){//removes a dead card from the field and adds it to an empty JLabel off screen

        graveYard.add(deadCard);
        deadCard.setInPlay(false);

        if(!yours)
            yourHeldCards.remove(deadCard);
        else
            enemyHeldCards.remove(deadCard);
    }

    public void attack(MonsterCard attacker, MonsterCard recipient, boolean yours){//begin attack
        recipient.setHealth(recipient.getHealth()-attacker.getAttack());
        damageLog.append("\n"+attacker.getName()+" attacked \n"+recipient.getName());

        if(yours)
        {
            if(recipient.getHealth()<=0)
            {
                for(Card c : enemyMonsterCards)                                     //This odd contraption is used to scan through the enemysCards Array
                {                                                                   //and find the one that equals the recipient. It the sets the background
                    if(c.equals(recipient))                                         //color to container.getBackground(). This is used in the AI code to
                        c.getParent().setBackground(container.getBackground());     //determine if his monster slots contain a card or not
                }
                destroy(recipient, false);
                updateHealth(recipient.getHealth(), false);
            }
            else
                recipient.setToolTipText(recipient.toString());//updates card health

            attacker.setHasAttacked(true);//used to ensure card cannot attack more than once
            attacker.setSelected(false);
            this.attacker=null;
            this.recipient=null;
            enemyField.updateUI();
        }
        else
        {
            if(recipient.getHealth()<=0)
            {
                destroy(recipient, true);
                updateHealth(recipient.getHealth(), true);
            }
            else
                recipient.setToolTipText(recipient.toString());//updates card health

            attacker.setSelected(false);
            this.attacker=null;
            this.recipient=null;
            yourField.updateUI();
        }
    }//end attack

    public boolean canDirectAttack(boolean yours){//begin canDirectAttack
        if(yours)                                 //This method scans through the monster slots to see if there's
        {                                         //a card in play. if not, return true
            for(Card c : enemyMonsterCards)
            {
                if(c.isInPlay())
                    return false;
            }
            return true;
        }
        else
        {
            for(Card c : yourMonsterCards)
            {
                if(c.isInPlay())
                    return false;
            }
            return true;
        }
    }//end canDirectAttack

    public void directAttack(boolean yours){//attacks with recipients health equal to 0 to simulate a direct attack
        JOptionPane.showMessageDialog(null, "Direct Attack");
        recipient = new MonsterCard("", "directly", 0, 0);
        attack(attacker, recipient, yours);
    }

    public void activateEffect(MagicCard c, boolean yours){//begin ActivateEffect
        if(yours)
        {
            switch (c.getType()){//determines if a card heals or damages a player
                case 'h':yourHealth+=c.getEffect();
                    yourHealthDisplay.setText("HP: "+yourHealth);
                    damageLog.append("\nYou healed for "+c.getEffect());
                    JOptionPane.showMessageDialog(null,c.getDescription());
                    break;

                case 'd':updateHealth(c.getEffect()*-1,false);
                    damageLog.append("\nYou used "+c.getName());
                    JOptionPane.showMessageDialog(null,c.getDescription());
                    break;
            }
        }
        else
        {
            switch (c.getType()){//determines if a card heals or damages a player
                case 'h':enemyHealth+=c.getEffect();
                    damageLog.append("\nEnemy healed for "+c.getEffect());
                    enemyHealthDisplay.setText("HP: "+enemyHealth);
                    break;

                case 'd':updateHealth(c.getEffect()*-1,true);
                    damageLog.append("\nEnemy used "+c.getName());
                    break;
            }
        }
    }//end activateEffect

    public void updateHealth(int damage, boolean yours){//begin updateHealth
        if(!yours)
        {
            enemyHealth += damage;
            damageLog.append("\nEnemy took "+damage*-1+" damage");
            if(enemyHealth<=0)//ends game if true
            {
                enemyHealth=0;
                JOptionPane.showMessageDialog(null,"You Win!");
                setVisible(false);
                StartScreen gui = new StartScreen();
            }
            enemyHealthDisplay.setText("HP: "+enemyHealth);
        }

        else
        {
            yourHealth += damage;
            damageLog.append("\nYou took "+damage*-1+" damage");
            if (yourHealth <= 0)//ends game if true
            {
                yourHealth = 0;
                JOptionPane.showMessageDialog(null, "You Lose!");
                setVisible(false);
                StartScreen gui = new StartScreen();
            }
            yourHealthDisplay.setText("HP: " + yourHealth);
        }
    }//end updateHealth

    public void initializeYourTurn(){// called at start and end of AI.play
        drawnCard=false;
        playedMonster=false;
        for(Card c : yourMonsterCards) {
            if (((MonsterCard) c).getHasAttacked()) ;
            ((MonsterCard) c).setHasAttacked(false);
        }
        damageLog.setText("Damage Log\n");
        yourTurn=true;
    }

    private class MouseEventHandler implements MouseListener {//begin MouseEventHandler
        @Override
        public void mouseClicked(MouseEvent e) {//begin mouseClicked
            if (yourTurn) {//used to ensure no clicking can be done while AI is running
                for (Card c : yourHeldCards)//start card select event handling
                {
                    if (e.getSource() == c) {
                        for (Card x : yourHeldCards)//used to deselect any cards that may have been previously selected
                        {
                            if (x.isSelected()) {
                                x.setSelected(false);
                            }
                        }//end card deselect process

                        c.setSelected(true);

                        if (c instanceof MagicCard) {//immediately activates a magic card if its clicked
                            yourEmptyHeldSlots.add((JPanel) c.getParent());
                            yourMagicSlot.add(c);
                            yourHand.updateUI();
                            activateEffect((MagicCard) c, true);
                            c.setSelected(false);
                            graveYard.add(c);
                            yourField.updateUI();
                        }//end magic card event handling
                        else if (!c.isInPlay()) {//highlights monster zones
                            for (JPanel j : yourMonsterSlots) {
                                j.setBackground(Color.green);
                            }
                        }
                    }
                }//end card select event handling

                for (JPanel j : yourMonsterSlots)//start card play event handling
                {
                    if (e.getSource() == j) {
                        for (Card c : yourHeldCards) {
                            if (c.isSelected() && !c.isInPlay()) {//checks if the card you clicked on is in your hand
                                if(!playedMonster)//checks if you have already played a monster this turn
                                {
                                    yourEmptyHeldSlots.add((JPanel) c.getParent());     //adds the parent container of the selected card to an array that stores empty slots.
                                    c.setSelected(false);                               //used in canDrawCard method
                                    c.setInPlay(true);
                                    j.add(c);
                                    yourMonsterCards.add(c);
                                    yourField.updateUI();
                                    yourHand.updateUI();
                                    playedMonster=true;
                                }
                                else
                                    JOptionPane.showMessageDialog(null, "Can only play 1 monster per turn");

                                for (JPanel p : yourMonsterSlots) {//unhighlight monster zones
                                    p.setBackground(container.getBackground());
                                }
                            }
                        }
                    }
                }//end card play event handling

                for (Card c : yourMonsterCards)//start attack event handling
                {
                    if (e.getSource() == c && c.isInPlay()) {
                        if(!((MonsterCard) c).getHasAttacked())//checks to see if card has already attacked
                        {
                            setAttacker((MonsterCard) c);

                            if (canDirectAttack(true))
                                directAttack(true);
                        }
                        else
                            JOptionPane.showMessageDialog(null,"Card can only attack once");
                    }
                }

                for (Card c : enemyMonsterCards) {
                    if (e.getSource() == c && attacker != null) {//checks if one of your monsters was clicked first
                        setRecipient((MonsterCard)c);
                        attack(attacker, recipient,true);
                    }
                }//end card attack handling

                if (e.getSource() == yourDeck)//start deck event handling
                {
                    if(canDrawCard(yourDeckOfCards, yourEmptyHeldSlots)&&!drawnCard)
                        drawCard(true);
                     else
                        JOptionPane.showMessageDialog(null, "You cannot draw a card");
                }//end deck event handling
            }//end if(yourTurn)
        }//end mouseClicked

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {//highlights your cards when you hover over them
            for (Card c : yourHeldCards) {
                if (e.getSource() == c) {
                    if (!c.isSelected()) {
                        c.setBackground(Color.green);
                    }
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {//unhighlight your cards when you stop hovering over them
            for (Card c : yourHeldCards) {
                if (e.getSource() == c) {
                    if (!c.isSelected()) {
                        c.setBackground(container.getBackground());
                    }
                }
            }
        }
    }//end mouseEventHandler

    private class ButtonEventHandler implements ActionListener{//ends your turn and calls AI.play
        @Override
        public void actionPerformed(ActionEvent e) {
            if(yourTurn)
            {
                JOptionPane.showMessageDialog(null,"Opponents turn");
                yourTurn=false;
                ai.play();
            }
        }
    }

    private class AI{
        Timer timer = new Timer();//Timer and timer.schedule gotten from https://www.youtube.com/watch?v=MjGnLRt6M6w

        public void play(){//calls other methods for performing game tasks and schedules them so the tasks are distinguishable
            damageLog.setText("Damage Log\n");

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if(canDrawCard(enemyDeckOfCards, enemyEmptyHeldSlots))
                        drawCard(false);
                }
            },0);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    playCard();
                }
            },2000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    prepareAttacks();
                }
            },4000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    playMagic();
                }
            },8000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    initializeYourTurn();
                    JOptionPane.showMessageDialog(null, "Your Turn");
                }
            },9000);
        }

        public void playCard(){//plays a monster card if possible
            for(Card c : enemyHeldCards)
            {
                if(c instanceof MonsterCard)
                {
                    MonsterCard monsterToPlay = (MonsterCard)c;
                    if(monsterToPlay.getHealth()>0 && !monsterToPlay.isInPlay())//used to ensure card is not in graveyard
                    {
                        for(JPanel j : emptyMonsterSlots)
                        {
                            if(j.getBackground()!=Color.red)                                            //if a monster card is to be played in a slot
                            {                                                                           //the background must not be red.
                                c.setInPlay(true);                                                      //the only way the background can become red
                                c.addMouseListener(eventHandlerM);                                      //is if a card gets played on it
                                enemyEmptyHeldSlots.add((JPanel)c.getParent());                         //when the card is destroyed its color is set back to
                                JPanel temp = emptyMonsterSlots.get(emptyMonsterSlots.indexOf(j));      //container.getBackground().
                                temp.setBackground(Color.red);                                          //it works and its completely rational
                                temp.add(c);
                                enemyMonsterCards.add(c);
                                enemyField.updateUI();
                                enemyHand.updateUI();
                                break;
                            }
                        }//end inner for
                        break;
                    }
                }
            }//end outer for
        }

        public void prepareAttacks(){
            for(Card c : enemyMonsterCards)//begin to select enemy MonsterCard
            {
                attacker=(MonsterCard)c;
                if(attacker.getHealth()>0)//makes sure its not in the graveyard
                {
                    if(canDirectAttack(false))
                    {
                        directAttack(false);
                        if(yourHealth<=0)//stops attacking if you die
                            break;
                    }
                    else
                    {
                        for(Card x : yourMonsterCards)//begin to select your MonsterCard
                        {
                            if(x.isInPlay())
                            {
                                recipient=(MonsterCard)x;
                                attack(attacker, recipient, false);
                                break;
                            }
                        }//end selecting your monster card
                    }
                }
            }//end for
        }

        public void playMagic(){
            for(Card c : enemyHeldCards)
            {
                if(c instanceof MagicCard && !c.isInPlay())
                {
                    c.setInPlay(true);
                    enemyEmptyHeldSlots.add((JPanel)c.getParent());
                    enemyMagicSlot.add(c);
                    enemyHand.updateUI();
                    activateEffect((MagicCard)c,false);
                    graveYard.add(c);
                    enemyField.updateUI();
                }
            }
        }
    }//end AI
}
