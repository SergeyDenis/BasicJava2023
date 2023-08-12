package ru.HomeWork7;
import java.util.HashMap;
public class Currency {
    private String name;
    private String[] listCurCaseEnding;
    Currency(String name, HashMap<String,String[]> lCur) throws MyException {
            this.name = name;
            getListCurrency(name , lCur);
    }
        public String getNames () {
            return name;
        }
        public void getListCurrency(String name , HashMap<String, String[]> map) throws MyException {
            String [] arrayList = null;
            try {
                //int x = 1/0; // для тестирования генерация ошибки
                arrayList= map.get(name);
                if (arrayList==null ) {
                    throw new MyException();
                }
            } catch (NullPointerException e) {
                throw new MyException("Нет данных",e);
            } catch (MyException e) {
                throw new MyException("Ошибка. Валюта "+name+" в словаре не найдена",e);
            } catch (Exception e){
                throw new MyException("Непредвиденная ошибка",e);
            }
            this.listCurCaseEnding = arrayList;
    }
       public String[] getListCurCaseEnding (){
           return this.listCurCaseEnding ;
       }
}
