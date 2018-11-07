import javax.swing.*;

public class Card extends JPanel{

    JLabel image;
    ImageIcon picture;
    private String name;
    private boolean selected;
    private boolean inPlay;

    public Card(){
        super();
        picture = new ImageIcon("cardBack.png");
        image= new JLabel(picture);
        add(image);
    }

    public Card(String imagePath){
        super();
        picture = new ImageIcon(imagePath);
        image= new JLabel(picture);
        add(image);
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
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
