package main.employee;

import main.MagnetStripe;
import main.ProfilType;

import static main.Type.staff;

public class Supervisor extends Employee {

    private boolean isSenior;
    private boolean isExecutive;

    public Supervisor(int id, String name, String birthDate, boolean isSenior, boolean isExecutive) {
        super(id, name, birthDate);

        this.isExecutive = isExecutive;
        this.isSenior = isSenior;

        getIdCard().setType(staff);
        getIdCard().setMagnetStripe(new MagnetStripe(ProfilType.S));
    }
}
