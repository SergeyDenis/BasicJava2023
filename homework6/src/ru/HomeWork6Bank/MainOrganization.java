package ru.HomeWork6Bank;
import java.util.Scanner;

public class MainOrganization {

    public static void main(String[] args) {
        BankOrganization bank = new BankOrganization("VTB");
        bank.printBankStorage();
        System.out.print("Номер счёта для поиска:");
        Account account = new Account(inputAccount());
        bank.resultOut(bank.getResult(account));
        System.out.print("ФИО Клиента:");
        Client client   =  new Client( inputNameClient());
        bank.resultOut(bank.getResult(client));

    }

    public static int inputAccount() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String inputNameClient() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }


}
