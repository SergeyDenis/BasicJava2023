package ru.HomeWork6Bank;

import java.util.List;

public abstract class Organization {
    private String nameOrganisation;
    public abstract Client findClient(Account account);
    public abstract List<Account> getAccounts(Client client);
    }

