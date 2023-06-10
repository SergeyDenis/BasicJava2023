package ru.HomeWork4Survey;

public class MainSurvey {

    public static void main(String[] args) {
        SurveyLibrary srv = new SurveyLibrary("First Survey");
        CheckSurvey  checkSrv = new CheckSurvey(srv);
        System.out.println(srv.nameOfThisSurvey);
        InputOutputSurvey.printSurvey(srv.arrayQuestionsOfThisSurvey);
        InputOutputSurvey.printStreamOutput("Начинаем опрос "+srv.nameOfThisSurvey);
        runningSurvey(srv,checkSrv);
    }

    private static void runningSurvey (SurveyLibrary survey,CheckSurvey checkSrv)
    {
        getAnswerQuestions(survey,checkSrv);
        getCheckingSurvey(checkSrv);
        outputResultSurvey(survey,checkSrv);
    }

    private static void outputResultSurvey(SurveyLibrary survey,CheckSurvey checkSrv) {
        String strHeader = "Спасибо Вы прошли опрос:'"+survey.getNameSurvey()+"' Всего вопросов: "+ survey.arrayQuestionsOfThisSurvey.length+" Правильных ответов: "+checkSrv.sumRightAnswer;
        InputOutputSurvey.printResultSurvey(strHeader, checkSrv.arrayResultOfThisSurvey);
    }
    private static void getAnswerQuestions (SurveyLibrary survey,CheckSurvey checkSrv)
    {
        for (int numQuestion = 0; numQuestion < survey.arrayQuestionsOfThisSurvey.length ; numQuestion++) {
            InputOutputSurvey.printStreamOutput("Вопрос :" + (numQuestion + 1) + " " + survey.getQuestion(numQuestion));
            for (int i = 0; i < survey.arrayQuestionsOfThisSurvey[numQuestion][SurveyLibrary.constAnswersPosition].length; i++) {
                InputOutputSurvey.printStreamOutput((i + 1) + "-" + SurveyLibrary.getAnswerOptions(survey.arrayQuestionsOfThisSurvey, numQuestion, i));
            }
            InputOutputSurvey.printStreamOutput("Ваш вариант ответа:");
            checkSrv.setArraySelectedAnswer(numQuestion, InputOutputSurvey.inputStream());
        }
    }

    private static void getCheckingSurvey (CheckSurvey checkSrv)
    {
        checkSrv.checkingTheAnswer();
    }

}
