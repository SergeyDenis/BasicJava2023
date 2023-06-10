package ru.HomeWork4Survey;

public class SurveyLibrary {
    String nameOfThisSurvey;
    String[][][] arrayQuestionsOfThisSurvey;
    private static final String[][][] defaultAnswerOptions = {
                                         {{"Что не относится к языкам программирования ?"},
                                                 {"Java","Basic","HTML","C++"},
                                                 {"false","false","true","false"}},
                                         {{"Что такое HTML ?"},
                                                 {"Язык гипертекстовой разметки сайта",
                                                  "Код программы С++",
                                                  "Текстовый редактор"},
                                                 {"true","false","false"}},
                                          {{"Продолжите выражение Git это - ",},
                                                 {"Язык программирования",
                                                   "Мессенжер",
                                                   "Система позиционирования",
                                                   "Система контроля версий.",
                                                   "Модель смартфона"},
                                                 {"false","false","false","true","false"}}

                                          };
    public static final int constQuestionPosition =0;
    public static final int constQuestionName =0;
    public static final int constAnswersPosition =1;
    public static final int constAnswerName=0;
    public static final int constAnswerNum=1;
    public static final int constResultPosition =2;
    public static final int constResultName =0;
    public SurveyLibrary(String nameSurvey)
    {
        this.nameOfThisSurvey=nameSurvey;
        this.arrayQuestionsOfThisSurvey = encodeAnswerSurvey(defaultAnswerOptions);
    }
    public SurveyLibrary(String nameSurvey, String[][][] arraySurvey)
    {
        this.nameOfThisSurvey=nameSurvey;
        this.arrayQuestionsOfThisSurvey = arraySurvey;
    }
         public String getQuestion (int numQuestion) {
            return arrayQuestionsOfThisSurvey[numQuestion][constQuestionPosition][constQuestionPosition];
         }
         public String getNameSurvey () {
            return nameOfThisSurvey;
    }
        public static String getAnswerOptions (String[][][] arraySurvey, int numQuestion , int numAnswer) {
             return arraySurvey[numQuestion][constAnswersPosition][numAnswer];
        }

        public static String[][][] encodeAnswerSurvey (String[][][] arraySurvey)
         {
             for (int numQuestion = 0; numQuestion < arraySurvey.length; numQuestion++) {
                 for (int numAnswerPosition = 0; numAnswerPosition < arraySurvey[numQuestion][constAnswersPosition].length; numAnswerPosition++) {
                      arraySurvey[numQuestion][constResultPosition][numAnswerPosition] = String.valueOf((arraySurvey[numQuestion][constAnswersPosition][numAnswerPosition]+ arraySurvey[numQuestion][constResultPosition][numAnswerPosition]).hashCode());
                 }
             }
             return arraySurvey;
         }
         public static String decodeAnswer (String[][][] massAns , int numQuestion , int numAnswer)
         {
             return String.valueOf((massAns[numQuestion][constAnswersPosition][numAnswer]+"true").hashCode());
         }

}
