package street_fighter;

public class Fighter {
    private int code;
    private String name;
    private int health;
    private int attack;

    public Fighter(int code, String name, int health, int attack) {
        this.code = code;
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public int getCode() { return code; }
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getAttack() { return attack; }

    public void takeDamage(int dmg) { this.health -= dmg; }

    public String getFighterInfo() {
        return "[" + code + "] " + name + " (HP: " + health + ", ATK: " + attack + ")";
    }
}
