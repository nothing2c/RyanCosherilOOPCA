import javax.swing.*;

public class MonsterCard extends Card {

    private int health;
    private int attack;

    public MonsterCard(String imagePath, String name, int attack, int health){
        super(imagePath, name);

        setAttack(attack);
        setHealth(health);
        setToolTipText(this.toString());
    }

    public String toString(){
        return "Name: " + super.getName() + "    Attack: " + getAttack() + "    Health: " + getHealth();
    }


    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }


}
