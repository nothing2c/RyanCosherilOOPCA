public class MonsterCard extends Card {

    private int health;
    private int attack;
    private String name;

    public MonsterCard(String name, int attack, int health){
        setAttack(attack);
        setHealth(health);
        setToolTipText(this.toString());
    }

    public String toString(){
        return "Attack: " + getAttack() + "    Health: " + getHealth();
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
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
