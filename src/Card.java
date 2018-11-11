import javax.swing.*;
import java.awt.*;

public class Card extends JPanel{

    JLabel image;
    ImageIcon picture;
    private String name;
    private boolean selectable;
    private boolean selected;
    private boolean inPlay;

    public Card(){
        super();
        this.selectable=false;
    }

    public Card(String imagePath, String name){
        super();
        setName(name);
        picture = new ImageIcon(imagePath);
        image= new JLabel(picture);
        add(image);
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
