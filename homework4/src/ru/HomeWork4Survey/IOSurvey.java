package ru.HomeWork4Survey;
import java.util.Scanner;
public class IOSurvey {
    public static void printStr(String s) {
        System.out.println(s);
    }

    public static int inputStream() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void printSurvey( SurveyLib.Question[] aSurvey) {
        for (int qst = 0; qst < aSurvey.length; qst++) {
            printStr("Вопрос N:"+(qst+1)+aSurvey[qst].getQuestion());
            for (int answ = 0; answ < aSurvey[qst].getAnswers().size();answ++) {
                printStr("Вариант ответа:"+(answ+1)+aSurvey[qst].getAnswers().get(answ).getAnswer()+
                        " результат " + aSurvey[qst].getAnswers().get(answ).getAnswerResult());
            }
        }
    }
    public static void printResultSurvey(String sHeader, SurveyLib.Question[] aResSurvey) {
        printStr(sHeader);
        printStr("===========================================================");
        for (int qst = 0 ; qst < aResSurvey.length;qst++){
            printStr("Ваш вопрос N"+(qst+1)+":" + aResSurvey[qst].getQuestion());
            printStr("Ваш вариант ответа: N"+aResSurvey[qst].getAnswers().get(0).getAnswer());
            printStr("Ваш результат:" + aResSurvey[qst].getAnswers().get(0).getAnswerResult());
            printStr("--------------------------------------------------------");
        }
    }

}
