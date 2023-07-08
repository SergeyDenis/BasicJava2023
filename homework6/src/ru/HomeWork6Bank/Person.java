package ru.HomeWork6Bank;

abstract class Person {

    private String name;
    private String nameOrganization;

    public Person(String name , String nameOrganization){
       this.name=name;
       this.nameOrganization=nameOrganization;
    }

    public void setName (String name) {
        this.name=name;
    }

    public String getName() {
       return name;
    }

    public String getNameOrganization() {
        return nameOrganization;
    }

}