public class MagicCard extends Card {

    private int effect;
    private String description;
    private char type; //represent function of the effect ('h' for heal, 'd' for damage etc)

    public MagicCard(String imagePath, String name, char type, String description, int effect) {
        super(imagePath, name);
        setType(type);
        setDescription(description);
        setEffect(effect);
    }

    public String toString(){
        return getDescription();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getEffect() {
        return effect;
    }

    public void setEffect(int effect) {
        this.effect = effect;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }
}
