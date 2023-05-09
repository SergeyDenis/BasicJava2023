//package ru.otus.java.homework;

import java.util.Scanner;

/**
 * Заготовка для выполнения ДЗ "Система тестирования".
 */
public class HomeWork3Survey {
    public static void main(String[] args) {
        // Переменные для хранения количества правильных и неправильных ответов
        int correctCount = 0, wrongCount = 0;

        // Ниже вместо null надо написать реализацию,
        // написано так, чтобы просто компилировалось

        // Массив вопросов (вместо null надо написать определение массива)
        String[] questions = {"Что не относится к языкам программирования ?",        // 1 Вопрос
                              "Что такое HTML ?",                                    // 2 Вопрос
                              "Продолжите выражение Git это - ",                     // 3 Вопрос
                              };

        // Массив вариантов ответов
        String[][] answerOptions = {{"Java",
                                     "Basic",
                                     "HTML",
                                     "C++"},                                        // 1 Вопрос
                                    {"Язык гипертекстовой разметки сайта",
                                     "Код программы С++",
                                     "Текстовый редактор"},                         // 2 Вопрос
                                    {"Язык программирования",
                                     "Мессенжер",
                                     "Система позиционирования",
                                     "Система контроля версий.",
                                     "Модель смартфона"}                            // 3 Вопрос
                                   };

        // Массив правильных ответов
        int[] correctAnswers = {3,    // 1 Вопрос
                                1,    // 2 Вопрос
                                4     // 3 Вопрос
                               };
        int[] answers =new int[correctAnswers.length];
        Scanner scanner = new Scanner(System.in);
        String resultAnswer ;
        System.out.println("В тесте "+questions.length+" вопросов");
        // TODO: Цикл по всем вопросам - исправить, написать правильно
        for(int i = 0; i < questions.length; i++) {
            // TODO: Вывод вопроса на экран
            System.out.println("Вопрос:" + (i + 1)+" "+questions [i] );
            // TODO: Вывод вариантов ответов на экран
            System.out.println(" Вариант ответов:");
            for(int j = 0; j < answerOptions[i].length; j++)
            {
                System.out.println((j + 1)+" - "+answerOptions[i][j] );
            }
            System.out.print("Ваш ответ:=> ");
            // Считываем с консоли ответ пользователя
             answers[i] = scanner.nextInt();

            // Проверяем ответ и выводим результат
            // а также увеличиваем счетчики правильных и неправильных ответов
             if (answers[i]  == correctAnswers[i])
             {
                 correctCount++;
             }
             else {
                   wrongCount++;
             }
            System.out.println();
        }

        //Выводим общий результат
        System.out.println("Результат: правильно " + correctCount + ", неправильно " + wrongCount);
        //Выводим детальный результат
        for(int i = 0; i < questions.length; i++)
        {
            resultAnswer="Вопрос N"+(i+1)+" '"+questions[i]+ "' Ваш ответ: " + answers[i]+"-";
            if  (answers[i] == correctAnswers[i])
              {
                  resultAnswer=resultAnswer+ answerOptions[i][answers[i]-1]+" Правильный";
              }
           else {
                  if (answers[i]>=1 & answers[i]<=answerOptions[i].length)
                  {
                      resultAnswer=resultAnswer + answerOptions[i][answers[i]-1]+" Не правильный";
                  }
                  else {
                      resultAnswer=resultAnswer + " Некорректный.Допустимые вариант ответа от 1 до "+answerOptions[i].length ;
                  }
           }
            System.out.println (resultAnswer);
        }
    }
}
