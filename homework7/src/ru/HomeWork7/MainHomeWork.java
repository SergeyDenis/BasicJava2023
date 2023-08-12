package ru.HomeWork7;
import java.util.*;

public class MainHomeWork {
    public static void main(String[] args) {
        try (ResourceConnect res = new ResourceConnect(3,1); Scanner scan = new Scanner(System.in)) {
            res.connectResource();
            HashMap<String,String[]> buff = res.readStream();
            System.out.print("Введите валюту расчёта <RUB,USD,CNY>:");
            String vCurr = scan.next();
            Currency curr = new Currency(vCurr,buff);
            CurrencyCaseEnding currCase = new CurrencyCaseEnding(curr);
            System.out.print("Введите целую стоимость в валюте <"+curr.getNames()+"> за 1 кг картофеля: ");
            int n = scan.nextInt();
            System.out.println("Цена картофеля за 1 кг " + n + " " + currCase.getCurEnding(n));

        } catch (InputMismatchException e){
            System.out.println("Ошибка ввода стоимости");
            e.printStackTrace();

        } catch (RuntimeException e) {
            System.out.println("Ошибка соединения ");
            e.printStackTrace();

        } catch (MyException e){
            System.err.println(e.getMessage());
            e.printStackTrace();

        } catch (Exception e ){
            throw new RuntimeException(e);
        }
    }
        public static int inputStream() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
