package main;

import main.baggageScanner.BaggageScanner;
import main.employee.FederalPoliceOfficer;

import java.util.List;

public class FederalPoliceOffice {
    private FederalPoliceOfficer federalPoliceOfficerO1;
    private FederalPoliceOfficer federalPoliceOfficerO2;
    private FederalPoliceOfficer federalPoliceOfficerO3;
    private List<Robot> robots;

    public FederalPoliceOffice() {
        federalPoliceOfficerO1 = new FederalPoliceOfficer(5, "Wesley Snipes", "31.07.1962", this);
        federalPoliceOfficerO2 = new FederalPoliceOfficer(8, "Toto", "01.01.1969", this);
        federalPoliceOfficerO3 = new FederalPoliceOfficer(9, "Harry", "01.01.1969", this);

        robots.add(new Robot());
    }

    public FederalPoliceOfficer getFederalPoliceOfficerO1() {
        return federalPoliceOfficerO1;
    }

    public FederalPoliceOfficer getFederalPoliceOfficerO2() {
        return federalPoliceOfficerO2;
    }

    public FederalPoliceOfficer getFederalPoliceOfficerO3() {
        return federalPoliceOfficerO3;
    }

    public void reqestOfficer1AndOfficer2(BaggageScanner baggageScanner) {
        baggageScanner.getOperatingStation().getInspectorI2().setOfficer1(federalPoliceOfficerO1);
        baggageScanner.getOperatingStation().getInspectorI2().setOfficer2(federalPoliceOfficerO2);
    }

    public List<Robot> getRobots() {
        return robots;
    }
}
