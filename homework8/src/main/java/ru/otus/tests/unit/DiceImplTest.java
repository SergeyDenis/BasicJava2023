package main.java.ru.otus.tests.unit;

import main.java.ru.otus.game.Dice;
import main.java.ru.otus.game.DiceImpl;
public class DiceImplTest implements Dice {
    int numFirstRoll;
    int numSecondRoll;
    boolean firstRoll;

    public DiceImplTest(int f, int s) {
        this.numFirstRoll = f;
        this.numSecondRoll =s;
        this.firstRoll=true;
    }

    public DiceImplTest() {

    }

    @Override
    public int roll() {
        int numRoll;
        if (firstRoll) {
            this.firstRoll = false;
            numRoll= this.numFirstRoll;
        } else {
            numRoll= this.numSecondRoll;
        }
        return numRoll;
    }
    public void testRoll () {
        String scenario = "testRoll";
        DiceImpl dice = new DiceImpl();
        int numRoll = dice.roll();
        if (numRoll < 1 || numRoll > 6) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, "не корректное значение кубика= "+numRoll);
        }
        else {
            System.out.printf("\"%s\" passed %n", scenario);
        }
    }
}
