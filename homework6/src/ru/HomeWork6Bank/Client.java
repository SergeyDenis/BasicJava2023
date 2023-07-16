package ru.HomeWork6Bank;

import java.time.LocalDate;
import java.time.Period;

public class Client extends Person {
    private LocalDate birthDayClient;

    public Client(String nameClient) {
        super (nameClient , "Default");
        this.birthDayClient = LocalDate.now();
    }
    public Client(LocalDate birthDayClient, String nameClient , String nameOrganization ) {
        super (nameClient , nameOrganization);
        this.birthDayClient = birthDayClient;
    }
    public String getNameClient() {
        return super.getName();
    }

    public int getAgeClient() {
        LocalDate birthDay = birthDayClient;
        LocalDate current = LocalDate.now();
        return Period.between(birthDay,current).getYears();
    }
    @Override
    public int hashCode() {
        return this.getNameClient().hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return this.getNameClient().equals(client.getNameClient());
    }
}
