package street_fighter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StreetFighter {
    private List<Fighter> fighters = new ArrayList<>();
    private Random random = new Random();

    public void addFighter(Fighter f) {
        fighters.add(f);
    }

    public void getFighters() {
        for (Fighter f : fighters) {
            System.out.println(f.getFighterInfo());
        }
    }

    public void fight(int code1, int code2) throws InterruptedException {
        Fighter f1 = null, f2 = null;

        for (Fighter f : fighters) {
            if (f.getCode() == code1) f1 = f;
            if (f.getCode() == code2) f2 = f;
        }

        if (f1 == null || f2 == null) {
            System.out.println("Боец не найден!");
            return;
        }

        System.out.println("Бой начинается: " + f1.getName() + " VS " + f2.getName());

        Fighter attacker = random.nextBoolean() ? f1 : f2;
        Fighter defender = (attacker == f1) ? f2 : f1;

        while (f1.getHealth() > 0 && f2.getHealth() > 0) {
            defender.takeDamage(attacker.getAttack());
            System.out.println(attacker.getName() + " ударил " + defender.getName() + " на " + attacker.getAttack());
            Thread.sleep(1000);
            Fighter temp =  attacker;
            attacker = defender;
            defender = temp;
        }

        Fighter winner = f1.getHealth() > 0 ? f1 : f2;
        System.out.println("Победитель: " + winner.getName());
    }
}
