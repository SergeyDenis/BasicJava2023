package ru.HomeWork6Bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class StorageOrganization {

    private LinkClientAccount dataBD;
    public StorageOrganization (int typeStorage) {
        if (typeStorage == 1)
        {
            this.dataBD = loadSBankStorage();
        }

    }
    private  LinkClientAccount loadSBankStorage(){
         return getBankStorage();
    }
    private  LinkClientAccount getBankStorage() {
        LinkClientAccount linkData = new LinkClientAccount();

        linkData.setLinked(new Client(LocalDate.of(2002, 6, 30),"Петров","Bank"),
                           new Account(1,1000));
        linkData.setLinked(new Client( LocalDate.of(2002, 6, 30),"Петров","Bank"),
                           new Account(2,2000));

        linkData.setLinked(new Client( LocalDate.of(2000, 6, 30),"Иванов","Bank"),
                           new Account(100,3000));

        linkData.setLinked(new Client( LocalDate.of(2004, 6, 30),"Сидоров","Bank"),
                           new Account(3,4000));
        linkData.setLinked(new Client(LocalDate.of(2004, 6, 30),"Сидоров","Bank"),
                           new Account(4,5000));
        linkData.setLinked(new Client(LocalDate.of(2004, 6, 30),"Сидоров","Bank"),
                           new Account(5,6000));
        return linkData;
    }
    public LinkClientAccount getDataBD(){
        return  this.dataBD;
    }
    public void printStorage(){
        HashMap<Client, ArrayList<Account>> db = this.dataBD.getLinkClientAccount();
        for (Client name: db.keySet()) {
            String key = name.getNameClient();
            ArrayList<Account> value = db.get(name);
            System.out.print("ФИО:"+key+"[");
            for (Account account : value) {
                System.out.print("Счёт N:" + account.getIdAccount() + " ");
            }
            System.out.print("]\n");
        }
    }

}
