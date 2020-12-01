package main.employee;

import main.MagnetStripe;
import main.ProfilType;

import static main.Type.staff;

public class Inspector extends Employee {

    private boolean isSenior;

    public Inspector(int id, String name, String birthDate, boolean isSenior) {
        super(id, name, birthDate);

        this.isSenior = isSenior;

        getIdCard().setType(staff);
        getIdCard().setMagnetStripe(new MagnetStripe(ProfilType.I));
    }

}
