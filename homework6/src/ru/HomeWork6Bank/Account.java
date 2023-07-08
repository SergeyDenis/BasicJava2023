package ru.HomeWork6Bank;

public class Account {
    private Integer idAccount;
    private Integer sum_balance;
    public Account (Integer idAccount , Integer sum_balance){
        this.idAccount   = idAccount;
        this.sum_balance = sum_balance;
    }
    public Account (Integer idAccount ){
        this.idAccount   = idAccount;
        this.sum_balance = 0;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public int getSum() {
        return sum_balance;
    }

    public void setSum(int sum) {
        this.sum_balance = sum;
    }
    @Override
    public int hashCode() {
        return this.idAccount.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return this.idAccount.equals(account.idAccount);
    }
}
