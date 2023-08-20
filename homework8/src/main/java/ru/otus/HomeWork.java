package main.java.ru.otus;


import main.java.ru.otus.game.*;
import main.java.ru.otus.tests.unit.DiceImplTest;
import main.java.ru.otus.tests.unit.GameTest;

public class HomeWork {

    /*
        Заготовка для ДЗ представляет собой игру в кости.
        При вызове game.playGame(), два игрока кидают кости.
        Выигрывает игрок, у кого результат (1-6) больше

        Написать тесты (минимум 4) на классы DiceImpl и Game.
        Тесты должны найти не менее двух ошибок.

        Информацию о пройденном тесте предлагается выводить в System.out, а об упавшем в System.err
     */
    public static void main(String[] args) {
        DiceImplTest dice = new DiceImplTest();
        dice.testRoll();
        System.out.println("\n----------------------\n");
        GameTest gametest = new GameTest();
        gametest.testGameWinPlayer1();
        System.out.println("\n----------------------\n");
        gametest.testGameWinPlayer2();
        System.out.println("\n----------------------\n");
        gametest.testGamePlayADraw();
        System.out.println("\n----------------------\n");
        gametest.testGameRollMoreThan6();
        System.out.println("\n----------------------\n");
    }
    
}