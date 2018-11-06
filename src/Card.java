import javax.swing.*;

public class Card extends JLabel{

    ImageIcon picture;

    public Card(){
        super();
        picture = new ImageIcon("cardBack.png");
        setIcon(picture);
    }
}
