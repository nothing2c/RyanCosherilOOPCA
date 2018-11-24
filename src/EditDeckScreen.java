import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class EditDeckScreen extends JFrame{//start EditDeckScreen

    ButtonEventHandlerEdit handlerE;
    public static Deck deck;
    public static String playDeckName;

    private JButton addCard;
    private JButton removeCard;
    private JButton saveDeck;
    private JButton loadDeck;
    private JButton deleteDeck;
    private JButton back;
    private JTextArea cards;

    public EditDeckScreen(){
        setLayout(new FlowLayout());
        setSize(800,450);
        setLocationRelativeTo(null);
        setTitle("TCG Borne");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        handlerE = new ButtonEventHandlerEdit();

        addCard = new JButton("Add Card");
        addCard.setSize(200,100);
        addCard.addActionListener(handlerE);
        add(addCard);

        removeCard = new JButton("Remove Card");
        removeCard.setSize(200,100);
        removeCard.addActionListener(handlerE);
        add(removeCard);

        saveDeck = new JButton("Save Deck");
        saveDeck.setSize(200,100);
        saveDeck.addActionListener(handlerE);
        add(saveDeck);

        loadDeck = new JButton("Load Deck");
        loadDeck.setSize(200,100);
        loadDeck.addActionListener(handlerE);
        add(loadDeck);

        deleteDeck = new JButton("Delete Deck");
        deleteDeck.setSize(200,100);
        deleteDeck.addActionListener(handlerE);
        add(deleteDeck);

        back = new JButton("Back");
        back.setSize(200,100);
        back.addActionListener(handlerE);
        add(back);

        cards = new JTextArea();
        updateText();
        add(cards);

        setVisible(true);
    }

    private void save(Deck deck, String deckName)
    {
        boolean proceed=true;
        File file = new File(deckName+".dat");
        if(file.exists())// gotten from stack overflow
        {
            int choice=JOptionPane.showConfirmDialog(null,"Deck already exists. Do you want to overwrite it?");

            if(choice==JOptionPane.YES_OPTION)
            {
                proceed = true;
            }
            else
                proceed=false;
        }

        if(proceed)
        {
            try{
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(deck);
                oos.close();
                JOptionPane.showMessageDialog(null,"Deck saved successfully");
                this.deck=deck;
                playDeckName=deckName;
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }

    public static Deck load(String deckName)
    {
        File file = new File(deckName+".dat");
        try{
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            deck=(Deck)ois.readObject();
            ois.close();
            JOptionPane.showMessageDialog(null,"Deck Loaded successfully");
            playDeckName=deckName;
            return deck;
        }
        catch (FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null,"Deck doesn't exist");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null,"Cannot Load Deck");
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public void delete(String name){//gotten from geeksforgeeks.com
        File file = new File(name+".dat");
            if(file.delete())
                JOptionPane.showMessageDialog(null,"Deck deleted successfully");
            else
                JOptionPane.showMessageDialog(null,"Deck could not be deleted");

        if(name.equals(playDeckName))
        {
           deck = new Deck();
           playDeckName=null;
           JOptionPane.showMessageDialog(null,"Deleted current deck. Creating a new default deck");
        }
    }

    private void updateText(){
        cards.setText("Cards\n");
        for(Card c : deck.getAllCards())
        {
            cards.append("\n"+c.toString());
        }
    }

    private class ButtonEventHandlerEdit implements ActionListener {//start ButtonEventHandlerEdit
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==addCard)
            {
                boolean valid=false;
                String choice;

                choice=JOptionPane.showInputDialog("What kind of card do you want to add?('Monster / Magic)");
                choice=choice.toLowerCase();
                if(!(choice.equals("monster")||choice.equals("magic")))
                    valid=false;

                while(!valid)
                {
                    if(!(choice.equals("monster")||choice.equals("magic")))
                    {
                        choice=JOptionPane.showInputDialog("Not a valid card type('Monster / Magic)");
                        choice=choice.toLowerCase();
                    }
                    else
                        valid = true;
                }

                String name = JOptionPane.showInputDialog("Please enter the name of the card");
                String imagePath = JOptionPane.showInputDialog("Please enter the name of the image for the card (cardBack.png)");
                imagePath="cardBack.png"; //cheating to ensure no crashes for invalid image

                if(choice.equals("monster"))
                {
                    String attack = JOptionPane.showInputDialog("Please enter the attack of the card");
                    String health = JOptionPane.showInputDialog("Please enter the health of the card");

                    try{
                        MonsterCard card = new MonsterCard(imagePath, name, Integer.parseInt(attack), Integer.parseInt(health));
                        deck.addCard(card);
                        updateText();
                        JOptionPane.showMessageDialog(null,"Card successfully added");
                    }
                    catch(Exception x){
                        JOptionPane.showMessageDialog(null,"Cannot create card with these parameters");
                        x.printStackTrace();
                    }
                }

                else
                {
                    String type = JOptionPane.showInputDialog("Please enter the type of effect the card has('h' / 'd')");
                    String desc = JOptionPane.showInputDialog("Please enter the description of the card");
                    String effect = JOptionPane.showInputDialog("Please enter the effect of the effect(integer)");

                    try{
                        MagicCard card = new MagicCard(imagePath, name, type.charAt(0),desc,Integer.parseInt(effect));
                        deck.addCard(card);
                        updateText();
                        JOptionPane.showMessageDialog(null,"Card successfully added");
                    }
                    catch (Exception x)
                    {
                        JOptionPane.showMessageDialog(null,"Cannot create card with these parameters");
                    }
                }
            }

            if(e.getSource()==removeCard)
            {
                String name = JOptionPane.showInputDialog("Please enter the name of the card you want to remove");
                if(deck.removeCard(name))
                {
                    JOptionPane.showMessageDialog(null,"Card removed successfully");
                    updateText();
                }
                else
                    JOptionPane.showMessageDialog(null,"Card doesn't exist");
            }

            if(e.getSource()==saveDeck)
            {
                String name = JOptionPane.showInputDialog("Enter the name of the deck");
                save(deck, name);
            }

            if(e.getSource()==loadDeck)
            {
                String name = JOptionPane.showInputDialog("Enter the name of the deck to load");
                load(name);
                playDeckName=name;
                updateText();
            }

            if(e.getSource()==deleteDeck)
            {
                String name = JOptionPane.showInputDialog("Enter the name of the deck to delete");
                delete(name);
                updateText();
            }

            if(e.getSource()==back)
            {
                int choice=JOptionPane.showConfirmDialog(null,"Do you want to save before exit");

                if(choice==JOptionPane.YES_OPTION)
                {
                    String name = JOptionPane.showInputDialog("Enter the name of the deck");
                    save(deck, name);
                }
                setVisible(false);
                StartScreen gui = new StartScreen();
            }
        }
    }//end ButtonEventHandlerEdit
}//end EditDeckScreen