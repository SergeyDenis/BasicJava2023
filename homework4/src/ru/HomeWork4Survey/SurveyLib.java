package ru.HomeWork4Survey;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SurveyLib {
    private final String nameSurvey;
    private final Question[] aSurvey;
    private Question[] aResSurvey;

    private int sumTrueChoice = 0 ;
    public SurveyLib(String nameSurvey) {
        this.nameSurvey = nameSurvey;
        this.aSurvey = encodeAnswer(defaultFormationSurvey());
    }

    public SurveyLib(String nameSurvey, Question[] aSurvey) {
        this.nameSurvey = nameSurvey;
        this.aSurvey = aSurvey;
    }

    public static class Question  {
        private final String text;
        private final List<Answer> answers;

        public Question(String text, List<Answer> answers) {
            this.text = text;
            this.answers = answers;
        }

        public String getQuestion() {
            return text;
        }

        public List<Answer> getAnswers (){
             return answers;
        }
    }
    public static class Answer {
        private final String text;
        private final String strResult;


        public Answer(String text, String strResult) {
            this.text = text;
            this.strResult = strResult;
        }

        public String getAnswer() {
            return text;
        }
        public String getAnswerResult() {
            return strResult;
        }

    }
        public Question[] defaultFormationSurvey() {
            return new Question[]{new Question("Что не относится к языкам программирования ?",
                                  Arrays.asList(  new Answer("Java", "false"),
                                                  new Answer("Basic", "false"),
                                                  new Answer("HTML", "true"),
                                                  new Answer("C++", "false")
                                          )),
                              new Question("Что такое HTML ?",
                                  Arrays.asList(  new Answer("Язык гипертекстовой разметки сайта", "true"),
                                                  new Answer("Код программы С++", "false"),
                                                  new Answer("Текстовый редактор", "false")
                                          )),
                              new Question("Продолжите выражение Git это - ?",
                                  Arrays.asList(  new Answer("Язык программирования", "false"),
                                                  new Answer("Мессенжер", "false"),
                                                  new Answer("Система позиционирования", "false"),
                                                  new Answer("Система контроля версий.", "true"),
                                                  new Answer("Модель смартфона", "false")
                                          ))
                              };
        }
        public Question[] getResSurvey() {
            Question[] qstRes =  new Question[aSurvey.length];
            for (int qst = 0; qst < aSurvey.length; qst++) {
                qstRes[qst]= new Question(aSurvey[qst].text,Arrays.asList(new Answer("", "")));
            }
            return qstRes;
        }
        public String getSurveyQuestion(int numQuestion) {
            return aSurvey[numQuestion].text;
        }
        public Question[] getSurveyQuestions() {
            return this.aSurvey;
        }
        public Question[] getSurveyResultQuestions() {
            return this.aResSurvey;
        }
        public int getCountQuestionsSurvey () {
            return aSurvey.length;
        }

        public String getNameSurvey () {
            return nameSurvey;
        }
        public int getSumTrueChoice () {
            return sumTrueChoice ;
        }

        public String getAnswerChoice(int numQuestion, int numAnswer) {
             return aSurvey[numQuestion].answers.get(numAnswer).text;
        }

        public void setResultSurvey (Question[] aResSurvey,int sumTrue){
            Question[] qstRes =  new Question[aResSurvey.length];
            for (int qst = 0; qst < aSurvey.length; qst++) {
                qstRes[qst]= new Question(aResSurvey[qst].text,Arrays.asList(new Answer(aResSurvey[qst].getAnswers().get(0).text,aResSurvey[qst].getAnswers().get(0).strResult)));
            }

            this.aResSurvey    = qstRes;
            this.sumTrueChoice = sumTrue;
        }
        public Question[] encodeAnswer(Question[] aSurvey) {
             for (int qst = 0; qst < aSurvey.length; qst++) {
                 for (int ans = 0; ans < aSurvey[qst].answers.size(); ans++) {
                     String hash = String.valueOf((aSurvey[qst].answers.get(ans).text + aSurvey[qst].answers.get(ans).strResult).hashCode());
                      aSurvey[qst].answers.set(ans,new Answer(aSurvey[qst].answers.get(ans).text,hash));
                 }
             }
             return aSurvey;
         }
         public static String decodeAnswer (Question[] aSurvey , int numQuestion , int numAnswer) {
             return String.valueOf((aSurvey[numQuestion].answers.get(numAnswer).text +"true").hashCode());
         }

}
