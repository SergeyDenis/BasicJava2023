package ru.HomeWork4Survey;

public class CheckSurvey
{
    public SurveyLib surveyObj;
    int[] aSelectedAns;
    int sumRightAns = 0 ;
    public CheckSurvey(SurveyLib surveyObj){
     this.surveyObj = surveyObj;
     this.aSelectedAns =new int[this.surveyObj.getCountQuestionsSurvey()];
    }
    public void checkAnswer()
    {
        SurveyLib.Question[] qstRes = surveyObj.getResSurvey();
        String textResultAnswer;
        for (int qst = 0; qst < aSelectedAns.length ; qst++) {
            textResultAnswer="Ответ неправильный";
            if (aSelectedAns[qst]<1 || aSelectedAns[qst] > surveyObj.getSurveyQuestions()[qst].getAnswers().size() )
            {
                String noAnswer="Допустимые вариант ответа от 1 до "+ surveyObj.getSurveyQuestions()[qst].getAnswers().size();
                qstRes[qst].getAnswers().set(0,new SurveyLib.Answer(aSelectedAns[qst]+" Некорректный ответ",noAnswer ));
                continue;
            }
            String ansRes = surveyObj.getSurveyQuestions()[qst].getAnswers().get(aSelectedAns[qst]-1).getAnswerResult();
            if (SurveyLib.decodeAnswer(surveyObj.getSurveyQuestions(), qst, aSelectedAns[qst]-1).equals(ansRes))
            {
                textResultAnswer="Ответ верный";
                sumRightAns++;
            }
            String ans = aSelectedAns[qst]+"-"+surveyObj.getSurveyQuestions()[qst].getAnswers().get(aSelectedAns[qst]-1).getAnswer();
            qstRes[qst].getAnswers().set(0,new SurveyLib.Answer(ans,textResultAnswer));
        }
        surveyObj.setResultSurvey(qstRes,sumRightAns);
    }
    public void setSelectedAns(int numQuestion, int numAnswer)
    {
        aSelectedAns[numQuestion] = numAnswer;
    }
}
