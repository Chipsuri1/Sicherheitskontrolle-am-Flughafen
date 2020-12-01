package main.employee;

import main.IDCard;

public abstract class Employee {

    private IDCard idCard;
    private int id;
    private String name;
    private String birthDate;

    public Employee(int id, String name, String birthDate){
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;

        idCard = new IDCard();
    }

    public IDCard getIdCard() {
        return idCard;
    }
}
