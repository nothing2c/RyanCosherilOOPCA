import javax.swing.*;
import java.awt.*;

public class Card extends JPanel{

    JLabel image;
    ImageIcon picture;
    private String name;
    private boolean selected;//used to highlight your cards
    private boolean inPlay;//used to determine whether a card is on the field or in tour hand

    public Card(String imagePath, String name){
        super();
        setName(name);
        picture = new ImageIcon(imagePath);//creates image from path
        image= new JLabel(picture);        //adds image to label
        add(image);                        //adds label
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        if(this.isSelected())
            this.setBackground(Color.yellow);
        else
            this.setBackground(Color.white);
    }

    public void setInPlay(boolean inPlay) {
        this.inPlay = inPlay;
    }

    public boolean isInPlay() {
        return inPlay;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
