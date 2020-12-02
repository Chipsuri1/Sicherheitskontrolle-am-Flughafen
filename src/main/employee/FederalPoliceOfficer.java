package main.employee;

import main.MagnetStripe;
import main.ProfilType;

import static main.Type.external;

public class FederalPoliceOfficer extends Employee {

    public FederalPoliceOfficer(int id, String name, String birthDate) {
        super(id, name, birthDate);

        getIdCard().setType(external);
        getIdCard().setMagnetStripe(new MagnetStripe(ProfilType.O, getIdCard().getSecretKey()));
    }


}
