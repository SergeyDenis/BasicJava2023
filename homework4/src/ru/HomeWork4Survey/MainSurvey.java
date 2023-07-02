package ru.HomeWork4Survey;

public class MainSurvey {

    public static void main(String[] args) {
        SurveyLib survey = new SurveyLib("First Survey");
        CheckSurvey  checkSurvey = new CheckSurvey(survey);
        System.out.println(survey.getNameSurvey());
        IOSurvey.printSurvey(survey.getSurveyQuestions());
        IOSurvey.printStr("Начинаем опрос "+survey.getNameSurvey());
        runningSurvey(survey,checkSurvey);
    }

    private static void runningSurvey (SurveyLib survey, CheckSurvey checkSurvey)
    {
        getAnswerQuestions(survey,checkSurvey);
        getCheckingSurvey(checkSurvey);
        outputResultSurvey(survey);
    }

    private static void outputResultSurvey(SurveyLib survey) {
        String textNameSurvey          = " Спасибо Вы прошли опрос:'"+ survey.getNameSurvey()+"'";
        String textCountQuestionSurvey = " Всего вопросов: "        + survey.getCountQuestionsSurvey();
        String textSumTrueChoice       = " Правильных ответов: "    + survey.getSumTrueChoice();
        String strHeader               = textNameSurvey + textCountQuestionSurvey + textSumTrueChoice;
        IOSurvey.printResultSurvey(strHeader, survey.getSurveyResultQuestions());
    }
    private static void getAnswerQuestions (SurveyLib survey, CheckSurvey checkSurvey)
    {
        for (int qst = 0; qst < survey.getSurveyQuestions().length ; qst++) {
            IOSurvey.printStr("Вопрос :" + (qst + 1) + " " + survey.getSurveyQuestion(qst));
            for (int i = 0; i < survey.getSurveyQuestions()[qst].getAnswers().size(); i++) {
                IOSurvey.printStr((i + 1) + "-" + survey.getAnswerChoice(qst, i));
            }
            IOSurvey.printStr("Ваш вариант ответа:");
            checkSurvey.setSelectedAns(qst, IOSurvey.inputStream());
        }
    }

    private static void getCheckingSurvey (CheckSurvey checkSrv)   {
        checkSrv.checkAnswer();
    }

}
