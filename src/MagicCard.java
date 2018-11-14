public class MagicCard extends Card {

    private int effect;
    private String description;

    public MagicCard(String imagePath, String name, int effect) {
        super(imagePath, name);
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
}
