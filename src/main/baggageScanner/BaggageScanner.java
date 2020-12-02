package main.baggageScanner;

import main.*;
import main.Record;
import main.configuration.SecurityControl;

import javax.swing.*;

import static main.Status.shutdown;
import static main.Status.start;

public class BaggageScanner {

    private OperatingStation operatingStation;
    private ManualPostControl manualPostControl = new ManualPostControl();
    private RollerConveyor rollerConveyor = new RollerConveyor();
    private Belt belt = new Belt();
    private Supervision supervision = new Supervision();
    private Scanner scanner;
    private FederalPoliceOffice federalPoliceOffice;

    private Track track1 = new Track();
    private Track track2 = new Track();

    private Status status = shutdown;

    public BaggageScanner(){
        this.operatingStation = new OperatingStation(scanner, belt);
        this.scanner = new Scanner(this);
        this.federalPoliceOffice = new FederalPoliceOffice();
    }

    public void scanHandBaggage(){
        rollerConveyor.getInspectorI1().pushHandBaggage(rollerConveyor.getTrays(), belt.getTrays());
        operatingStation.getInspectorI2().pushButton(operatingStation.getButtonLeft());
        operatingStation.getInspectorI2().pushButton(operatingStation.getButtonRectangle());

        while (scanner.getTrays().size() != 0){
            doNextStepAfterScanning(scanner.getTrays().poll());
        }

    }

    private void doNextStepAfterScanning(Tray tray){
        Record record = tray.getRecord();

        if(record.getResult().equals(ScanResult.knife) || record.getResult().equals(ScanResult.weapon) || record.getResult().equals(ScanResult.explosive))
        {
            //manuelle Nachkontrolle durch Inspektor I3 auf Track 01
            manualPostControl.getInspectorI3().putOnTrack1(this, tray);
            manualPostControl.getInspectorI3().doManualPostControl(this, tray);


        }else{
            //Gib Passagier Handbaggage zurück über Track 02
            track2.putTray(tray);
        }


    }

    public OperatingStation getOperatingStation() {
        return operatingStation;
    }

    public ManualPostControl getManualPostControl() {
        return manualPostControl;
    }

    public Belt getBelt() {
        return belt;
    }

    public Supervision getSupervision() {
        return supervision;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public Track getTrack1() {
        return track1;
    }

    public Track getTrack2() {
        return track2;
    }

    public Status getStatus() {
        return status;
    }

    public void start(){
        setStatus(start);
    }

    public void shutdown(){
        setStatus(shutdown);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public RollerConveyor getRollerConveyor() {
        return rollerConveyor;
    }

    public FederalPoliceOffice getFederalPoliceOffice() {
        return federalPoliceOffice;
    }
}

