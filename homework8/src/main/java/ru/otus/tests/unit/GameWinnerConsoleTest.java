package main.java.ru.otus.tests.unit;

import main.java.ru.otus.game.GameWinnerConsolePrinter;
import main.java.ru.otus.game.Player;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameWinnerConsoleTest extends GameWinnerConsolePrinter {
        private Player winPlayer;
        private String textPrintWinner;

        public GameWinnerConsoleTest (Player winPlayer){
            this.winPlayer = winPlayer;

        }
        @Override
        public void printWinner(Player winner) {
            final PrintStream oldStdout = System.out;
            try {
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                System.setOut(new PrintStream(output));
                super.printWinner(winner);
                this.textPrintWinner =  output.toString();
            }
            catch (Throwable e) {
                throw new RuntimeException(e);
            }
            finally {
                System.setOut(oldStdout);
            }
        }

        public String getWinner () {
            return this.winPlayer.getName();
        }
        public String geTextPrintWinner () {
            return this.textPrintWinner;
        }

    }


