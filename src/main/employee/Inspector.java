package main.employee;

import main.MagnetStripe;
import main.ProfilType;
import main.Record;
import main.Result;
import main.baggageScanner.BaggageScanner;
import main.baggageScanner.Belt;
import main.baggageScanner.Scanner;
import main.baggageScanner.Tray;
import main.button.Button;
import main.passenger.HandBaggage;
import main.passenger.Layer;
import main.passenger.Passenger;

import java.util.Queue;

import static main.Type.staff;

public class Inspector extends Employee {

    private boolean isSenior;

    private Record record;
    private FederalPoliceOfficer officer1;
    private FederalPoliceOfficer officer2;
    private Passenger passengerInPresence;
    private Supervisor supervisorInPresence;

    public Inspector(int id, String name, String birthDate, boolean isSenior) {
        super(id, name, birthDate);

        this.isSenior = isSenior;

        getIdCard().setType(staff);
        getIdCard().setMagnetStripe(new MagnetStripe(ProfilType.I, getIdCard().getSecretKey()));
    }

    public void pushHandBaggage(Queue<Tray> rollerConveyor , Queue<Tray> belt){
        int sizeOfRollerConveyor = rollerConveyor.size();
        for(int i = 0; i < sizeOfRollerConveyor; i++){
            Tray tray = rollerConveyor.poll();
            belt.offer(tray);
        }
    }

    public void pushButton(Button button){
        button.buttonAction();
    }

    public void doManualPostControl(BaggageScanner baggageScanner, Tray tray) {
        if(record.getResult().equals(Result.knife)){
            baggageScanner.getOperatingStation().getInspectorI2().tellOtherInspektor(baggageScanner.getManualPostControl().getInspectorI3(), record);
            passengerInPresence = tray.getHandBaggage().getPassenger();
            baggageScanner.getManualPostControl().getInspectorI3().openBaggageGetKnifeAndThrowAway(tray.getHandBaggage().getPassenger());
            baggageScanner.getManualPostControl().getInspectorI3().putTrayToBelt(tray, baggageScanner);
            baggageScanner.scanHandBaggage();
            passengerInPresence = null;
        }else if(record.getResult().equals(Result.weapon) || record.getResult().equals(Result.explosive) ){
            baggageScanner.getOperatingStation().getInspectorI2().setAlarm(baggageScanner);
            baggageScanner.getFederalPoliceOffice().getFederalPoliceOfficerO1().arrest(tray.getHandBaggage().getPassenger());
            baggageScanner.getFederalPoliceOffice().reqestOfficer1AndOfficer2(baggageScanner);
            if(record.getResult().equals(Result.explosive)){
                getOfficer2().workWithRobot();
            }else{
                //weapon
                getOfficer1().openHandBaggageGetWeaponAndGiveToOfficer03(tray);
            }
        }else{

        }
        else {

        }

    private void setAlarm(BaggageScanner baggageScanner) {
        baggageScanner.setStatus(Status.locked);
    }

    public void tellOtherInspektor(Inspector inspektor, Record record){
        inspektor.hearSentence(record);
    }

    public void hearSentence(Record record){
        this.record = record;
    }

    public void openBaggageGetKnifeAndThrowAway(Passenger passenger) {
        for (HandBaggage handBaggage : passenger.getHandBaggage()
             ) {
            for (Layer layer : handBaggage.getLayers()
                 ) {
                for (int i = 0; i < layer.getContent().length; i++) {
                    if(layer.getContent()[i] == 'K'){
                        // if there is the knife, "throw" it away and put an 'a' in
                        layer.getContent()[i] = 'a';
                    }
                }
            }
        }
    }

    private void putTrayToBelt(Tray tray, BaggageScanner baggageScanner) {
        baggageScanner.getBelt().getTrays().offer(tray);
    }

    public void putOnTrack1(BaggageScanner baggageScanner, Tray tray) {
        baggageScanner.getTrack1().putTray(tray);
    }

    public FederalPoliceOfficer getOfficer1() {
        return officer1;
    }

    public FederalPoliceOfficer getOfficer2() {
        return officer2;
    }

    public void setOfficer1(FederalPoliceOfficer officer1) {
        this.officer1 = officer1;
    }

    public void setOfficer2(FederalPoliceOfficer officer2) {
        this.officer2 = officer2;
    }
}
