package ru.HomeWork7;

public class CurrencyCaseEnding {
     private final Currency currency;
     CurrencyCaseEnding (Currency sCur ) {
         this.currency = sCur;
     }
     public String getCurEnding (int num) throws Exception {
         String ending = "";
         try {
             String[] listCurCaseEnding = this.currency.getListCurCaseEnding();
             //int x = 1 / 0; // для тестирования генерация ошибки
             int money1;
             if (num > 100) {
                 money1 = num % 100;
             } else {
                 money1 = num;
             }
             if (money1 >= 20) {
                 money1 = money1 % 10;
             } else {
                 money1 = num;
             }

             if (money1 == 1) {
                 ending = listCurCaseEnding[0];
             }
             if (money1 >= 2 & money1 < 5) {
                 ending = listCurCaseEnding[1];
             }
             if ((money1 >= 5 & money1 < 20) || money1 == 0) {
                 ending = listCurCaseEnding[2];
             }
             //ending=null;  // для тестирования генерация ошибки
             if ( ending == null ) {
                 System.err.println("Падеж окончания стоимости не найден!!!");
             }
         } catch (Exception e) {
                 throw  new Exception(e);
         }
         return ending;
     }
}
