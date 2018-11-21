import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class StartScreen extends JFrame{

    ButtonEventHandlerStart handlerS;

    private JButton start;
    private JButton editDeck;
    public Deck deck;

    public StartScreen(){
        setLayout(new FlowLayout());
        setSize(800,450);
        setLocationRelativeTo(null);
        setTitle("TCG Borne");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

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
