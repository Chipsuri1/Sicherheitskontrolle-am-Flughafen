package main.employee;

import main.FederalPoliceOffice;
import main.MagnetStripe;
import main.ProfilType;
import main.Robot;
import main.baggageScanner.Tray;
import main.configuration.Configuration;
import main.passenger.Passenger;

import java.awt.*;

import static main.Type.external;

public class FederalPoliceOfficer extends Employee {

    private FederalPoliceOffice federalPoliceOffice;

    public FederalPoliceOfficer(int id, String name, String birthDate, FederalPoliceOffice federalPoliceOffice) {
        super(id, name, birthDate);

        this.federalPoliceOffice = federalPoliceOffice;
        getIdCard().setType(external);
        getIdCard().setMagnetStripe(new MagnetStripe(ProfilType.O, getIdCard().getSecretKey()));
    }


    public void arrest(Passenger passenger) {

    }

    public void workWithRobot() {
        Robot robot = federalPoliceOffice.getRobots().get(Configuration.instance.mersenneTwister.nextInt(2));
        robot.defuse();
    }

    public void openHandBaggageGetWeaponAndGiveToOfficer03(Tray tray) {

    }
}
