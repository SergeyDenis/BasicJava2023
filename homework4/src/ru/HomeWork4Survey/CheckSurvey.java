package ru.HomeWork4Survey;

public class CheckSurvey
{
    public SurveyLibrary surveyObject;
    int[] arraySelectedAnswerOfThisSurvey;
    String[][][] arrayResultOfThisSurvey;
    int sumRightAnswer = 0 ;
    public CheckSurvey(SurveyLibrary surveyObject){
     this.surveyObject=surveyObject;
     this.arraySelectedAnswerOfThisSurvey=new int[this.surveyObject.arrayQuestionsOfThisSurvey.length];
     this.arrayResultOfThisSurvey = new String[this.surveyObject.arrayQuestionsOfThisSurvey.length][3][2] ;
    }
    public void checkingTheAnswer ()
    {
        for (int questionNum = 0; questionNum < arraySelectedAnswerOfThisSurvey.length ; questionNum++) {
            arrayResultOfThisSurvey[questionNum][SurveyLibrary.constQuestionPosition][SurveyLibrary.constQuestionName] = surveyObject.arrayQuestionsOfThisSurvey[questionNum][SurveyLibrary.constQuestionPosition][SurveyLibrary.constQuestionPosition];
            if (arraySelectedAnswerOfThisSurvey[questionNum]<1 || arraySelectedAnswerOfThisSurvey[questionNum] > surveyObject.arrayQuestionsOfThisSurvey[questionNum][SurveyLibrary.constAnswersPosition].length )
            {
                arrayResultOfThisSurvey[questionNum][SurveyLibrary.constAnswersPosition][SurveyLibrary.constAnswerName]="Некорректный";
                arrayResultOfThisSurvey[questionNum][SurveyLibrary.constAnswersPosition][SurveyLibrary.constAnswerNum] = String.valueOf(arraySelectedAnswerOfThisSurvey[questionNum]);
                arrayResultOfThisSurvey[questionNum][SurveyLibrary.constResultPosition][SurveyLibrary.constResultName] ="Допустимые вариант ответа от 1 до "+surveyObject.arrayQuestionsOfThisSurvey[questionNum][SurveyLibrary.constAnswersPosition].length;
                continue;
            }
            arrayResultOfThisSurvey[questionNum][SurveyLibrary.constAnswersPosition][SurveyLibrary.constAnswerName]    = surveyObject.arrayQuestionsOfThisSurvey[questionNum][SurveyLibrary.constAnswersPosition][arraySelectedAnswerOfThisSurvey[questionNum]-1];
            arrayResultOfThisSurvey[questionNum][SurveyLibrary.constAnswersPosition][SurveyLibrary.constAnswerNum]     = String.valueOf(arraySelectedAnswerOfThisSurvey[questionNum]);

            if (SurveyLibrary.decodeAnswer(surveyObject.arrayQuestionsOfThisSurvey, questionNum,arraySelectedAnswerOfThisSurvey[questionNum]-1).equals(surveyObject.arrayQuestionsOfThisSurvey[questionNum][SurveyLibrary.constResultPosition][arraySelectedAnswerOfThisSurvey[questionNum]-1]))
            {
                arrayResultOfThisSurvey[questionNum][SurveyLibrary.constResultPosition][SurveyLibrary.constResultName]="Ответ верный";
                sumRightAnswer++;
            }
            else {
                arrayResultOfThisSurvey[questionNum][SurveyLibrary.constResultPosition][SurveyLibrary.constResultName]="Ответ неправильный";
            }

        }
    }
    public void setArraySelectedAnswer(int numQuestion, int numAnswer)
    {
        arraySelectedAnswerOfThisSurvey[numQuestion] = numAnswer;
    }
}
