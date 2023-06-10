package ru.HomeWork4Survey;
import java.util.Scanner;
public class InputOutputSurvey {
    public static void printStreamOutput(String s) {
        System.out.println(s);
    }

    public static int inputStream() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void printSurvey( String [][][] arraySurvey) {
        for (int numQuestion = 0; numQuestion < arraySurvey.length; numQuestion++) {
            printStreamOutput("Вопрос N:"+(numQuestion+1)+arraySurvey[numQuestion][SurveyLibrary.constQuestionPosition][SurveyLibrary.constQuestionName]);
            for (int numAnswerOptions = 0; numAnswerOptions < arraySurvey[numQuestion].length;numAnswerOptions++) {
                printStreamOutput("Вариант ответа:"+(numAnswerOptions+1)+arraySurvey[numQuestion][SurveyLibrary.constAnswersPosition][numAnswerOptions]+
                        " результат " + arraySurvey[numQuestion][SurveyLibrary.constResultPosition][numAnswerOptions]);
            }
        }
    }
    public static void printResultSurvey(String surveyHeaderString,String[][][] arrayResultSurvey) {
        printStreamOutput(surveyHeaderString);
        printStreamOutput("===========================================================");
        for (int numQuestion = 0 ; numQuestion < arrayResultSurvey.length;numQuestion++){
            printStreamOutput("Ваш вопрос N"+(numQuestion+1)+":" + arrayResultSurvey[numQuestion][SurveyLibrary.constQuestionPosition][SurveyLibrary.constQuestionName]);
            printStreamOutput("Ваш вариант ответа N"+arrayResultSurvey[numQuestion][SurveyLibrary.constAnswersPosition][SurveyLibrary.constAnswerNum] + "-" + arrayResultSurvey[numQuestion][SurveyLibrary.constAnswersPosition][SurveyLibrary.constAnswerName]);
            printStreamOutput("Ваш результат:" + arrayResultSurvey[numQuestion][SurveyLibrary.constResultPosition][SurveyLibrary.constResultName]);
            printStreamOutput("--------------------------------------------------------");
        }
    }

}
