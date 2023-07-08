package ru.HomeWork6Bank;

import java.util.ArrayList;

import java.util.List;

public class BankOrganization extends Organization {
    private String nameBank;
    private StorageOrganization bankStorage;
    public BankOrganization (String nameBank){
        this.nameBank=nameBank;
        StorageOrganization dataBase = new StorageOrganization(1);
        this.bankStorage = dataBase;
    }
    public  LinkClientAccount getResult (Client client ){
            ArrayList<Account> accounts = (ArrayList<Account>) getAccounts(client);
            LinkClientAccount linkResult = new LinkClientAccount();
            if (accounts!=null){
                Client client1 = findClient(accounts.get(0));
                linkResult = new LinkClientAccount(client1,accounts);
            }

            return linkResult;
    }
    public void  resultOut ( LinkClientAccount linkCA){
        if (linkCA!=null & linkCA.getClient()!=null) {
        System.out.println("ФИО:"+linkCA.getClient().getNameClient()+" Возраст="+linkCA.getClient().getAgeClient());
        ArrayList<Account> accounts = linkCA.getAccounts();
            for (Account account : accounts) {
                System.out.println("Счёт:" + account.getIdAccount() + " Баланс=" + account.getSum());
            }
        }
        else {
             System.out.println("Данных не найдено");
        }
    }
    public  LinkClientAccount getResult (Account account ){
        Client client  = findClient(account);

        LinkClientAccount linkResult = new LinkClientAccount();
        if (client!=null){
            ArrayList<Account> accounts = (ArrayList<Account>) getAccounts(client);
            linkResult = new LinkClientAccount(client,accounts);
        }

        return linkResult;
    }
    @Override
    public  List<Account> getAccounts(Client client) {
       ArrayList<Account> accounts = this.bankStorage.getDataBD().getLinkClientAccount().get(client);
       return (List<Account>) accounts;
    }

    @Override
    public Client findClient (Account accClient){
        Client client = this.bankStorage.getDataBD().getLinkAccountClient().get(accClient);
        return client;
    }
    public void printBankStorage (){
        this.bankStorage.printStorage();
    }
}
