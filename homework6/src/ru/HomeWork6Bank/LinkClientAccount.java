package ru.HomeWork6Bank;

import java.util.ArrayList;
import java.util.HashMap;

public class LinkClientAccount {
        private Client client;
        private ArrayList<Account> account;
        private HashMap <Client, ArrayList<Account>> linkClientAccount;
        private HashMap <Account,Client> linkAccountClient;

    public LinkClientAccount() {

    }
    public LinkClientAccount(Client client, ArrayList<Account> account) {
           this.client=client;
           this.account = account;
    }

    public void setLinked (Client client , Account account){
           ArrayList<Account> accClient = new ArrayList<>();
           try {
                accClient = this.linkClientAccount.get(client);
                if (accClient == null){
                    accClient = new ArrayList<>();
                }
           }
           catch (NullPointerException ignored) {

           }
           accClient.add(account);

           if (this.linkClientAccount==null){
               this.linkClientAccount = new HashMap <Client, ArrayList<Account>>();
           }
           if (this.linkAccountClient==null){
               this.linkAccountClient = new HashMap <Account,Client>();
           }
            this.linkClientAccount.put(client,accClient);
            this.linkAccountClient.put(account,client);
    }

    public HashMap <Client, ArrayList<Account>> getLinkClientAccount() {
            return this.linkClientAccount;
    }
    public HashMap <Account, Client> getLinkAccountClient() {
            return this.linkAccountClient;
    }

    public Client getClient() {
            return client;
    }

    public ArrayList<Account> getAccounts() {
            return account;
    }
}

