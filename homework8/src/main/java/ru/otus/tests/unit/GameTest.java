package main.java.ru.otus.tests.unit;

import main.java.ru.otus.assertions.Assertions;
import main.java.ru.otus.game.Game;
import main.java.ru.otus.game.Player;

public class GameTest {

    public void testGameWinPlayer1() {
        String scenario = "testGameWinPlayer1";
        try {
        DiceImplTest dice = new DiceImplTest(5,3);
        GameWinnerConsoleTest winnerPrinter = new GameWinnerConsoleTest(new Player("Вася"));
        Game game = new Game(dice, winnerPrinter);
        game.playGame(new Player("Вася"), new Player("Игорь"));
        Assertions.assertEquals("Победитель: " + winnerPrinter.getWinner() + "\r\n", winnerPrinter.geTextPrintWinner());
        System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testGameWinPlayer2() {
        String scenario = "testGameWinPlayer2";
        try {
        DiceImplTest dice = new DiceImplTest(1,3);
        GameWinnerConsoleTest winnerPrinter = new GameWinnerConsoleTest(new Player("Игорь"));
        Game game = new Game(dice, winnerPrinter);
        game.playGame(new Player("Вася"), new Player("Игорь"));
            Assertions.assertEquals("Победитель: " + winnerPrinter.getWinner() + "\r\n", winnerPrinter.geTextPrintWinner());
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testGamePlayADraw() {
        String scenario = "testGamePlayADraw";
        try {
            DiceImplTest dice = new DiceImplTest(3,3);
            GameWinnerConsoleTest winnerPrinter = new GameWinnerConsoleTest(new Player("Ничья"));
            Game game = new Game(dice, winnerPrinter);
            game.playGame(new Player("Вася"), new Player("Игорь"));
            Assertions.assertEquals("Победитель: " + winnerPrinter.getWinner() + "\r\n", winnerPrinter.geTextPrintWinner());
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
    public void testGameRollMoreThan6() {
        String scenario = "testGameRollMoreThan6";
        try {
            DiceImplTest dice = new DiceImplTest(10,3);
            GameWinnerConsoleTest winnerPrinter = new GameWinnerConsoleTest(new Player("Вася"));
            Game game = new Game(dice, winnerPrinter);
            game.playGame(new Player("Вася"), new Player("Игорь"));
            Assertions.assertEquals("Победитель: " + winnerPrinter.getWinner() + "\r\n", winnerPrinter.geTextPrintWinner());
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, winnerPrinter.geTextPrintWinner()+"Ошибка победителя не должно быть . Выпало число больше 6");
        } catch (Throwable e) {
            System.out.printf("\"%s\" passed %n", scenario);
        }
    }

}
