package main.employee;

import main.*;
import main.Record;
import main.baggageScanner.BaggageScanner;
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

    public IDCard swipeCard(){
        return getIdCard();
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

        //Knife
        if (record.getResult().getScanResult().equals(ScanResult.knife)) {
            baggageScanner.getOperatingStation().getInspectorI2().tellOtherInspector(baggageScanner.getManualPostControl().getInspectorI3(), record);
            passengerInPresence = tray.getHandBaggage().getPassenger();
            baggageScanner.getManualPostControl().getInspectorI3().openBaggageGetKnifeAndThrowAway(tray.getHandBaggage().getPassenger());
            baggageScanner.getManualPostControl().getInspectorI3().putTrayToBelt(tray, baggageScanner);
            baggageScanner.scanHandBaggage();
            passengerInPresence = null;

        }
        //Weapon or Explosive
        else if (record.getResult().getScanResult().equals(ScanResult.weapon) || record.getResult().getScanResult().equals(ScanResult.explosive)) {
            baggageScanner.getOperatingStation().getInspectorI2().setAlarm(baggageScanner);
            baggageScanner.getFederalPoliceOffice().getFederalPoliceOfficerO1().arrest(tray.getHandBaggage().getPassenger());
            baggageScanner.getFederalPoliceOffice().reqestOfficer1AndOfficer2(baggageScanner);
            if (record.getResult().getScanResult().equals(ScanResult.explosive)) {
                getOfficer2().workWithRobot();
            } else {
                //weapon
                if (record.getResult().getScanResult().equals(ScanResult.weapon)){

                    passengerInPresence = tray.getHandBaggage().getPassenger();
                    supervisorInPresence = baggageScanner.getSupervision().getSupervisor();
                    getOfficer1().openHandBaggageGetWeaponAndGiveToOfficer03(tray);
                    for (HandBaggage handBaggage : tray.getHandBaggage().getPassenger().getHandBaggage()) {
                        getOfficer1().openHandBaggageGetWeaponAndGiveToOfficer03(handBaggage.getTray());
                        getOfficer1().getFederalPoliceOffice().getFederalPoliceOfficerO3().getBaggagesOfArrested().add(handBaggage);
                    }

                }
                else if (record.getResult().getScanResult().equals(ScanResult.explosive)){

                }
            }
        } else {

        }


    }

    private void setAlarm(BaggageScanner baggageScanner) {
        baggageScanner.setStatus(Status.locked);
    }

    public void tellOtherInspector(Inspector inspector, Record record){
        inspector.hearSentence(record);
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
