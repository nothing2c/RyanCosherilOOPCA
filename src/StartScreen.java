import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends JFrame{//loads first and allows user to access other 2 screens

    ButtonEventHandlerStart handlerS;

    private JButton start;
    private JButton editDeck;

    public StartScreen(){
        setLayout(new FlowLayout());
        setSize(800,450);
        setLocationRelativeTo(null);
        setTitle("TCG Borne");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        if(EditDeckScreen.playDeckName==null)                                       //these lines are used to ensure that the decks that are currently being
            EditDeckScreen.deck=new Deck();                                         //used are not 'tampered' ie. if the deck was recently in play it might have
        else                                                                        //half it cards removed from being played, so this either loads the same
            EditDeckScreen.deck=EditDeckScreen.load(EditDeckScreen.playDeckName);   //deck in full condition or instantiates a new one if there is nothing to load

        handlerS = new ButtonEventHandlerStart();

        start = new JButton("Start");
        start.setSize(200,100);
        start.addActionListener(handlerS);
        add(start);

        editDeck = new JButton("Edit deck");
        editDeck.setSize(200,100);
        editDeck.addActionListener(handlerS);
        add(editDeck);

        setVisible(true);
    }

    private class ButtonEventHandlerStart implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==start)
            {
                setVisible(false);
                GameGUI gui = new GameGUI();
            }

            if(e.getSource()==editDeck)
            {
                setVisible(false);
                EditDeckScreen gui = new EditDeckScreen();
            }
        }
    }
}
