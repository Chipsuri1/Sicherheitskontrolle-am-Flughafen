package main.baggageScanner;

import main.Record;
import main.Status;
import main.passenger.HandBaggage;
import main.passenger.Passenger;

import static main.Status.shutdown;
import static main.Status.start;

public class BaggageScanner {

    private OperatingStation operatingStation = new OperatingStation();
    private ManualPostControl manualPostControl = new ManualPostControl();
    private RollerConveyor rollerConveyor = new RollerConveyor();
    private Belt belt = new Belt();
    private Supervision supervision = new Supervision();
    private Scanner scanner = new Scanner();

    private Track track1 = new Track();
    private Track track2 = new Track();

    private Status status = shutdown;

    public BaggageScanner(){
        this.operatingStation = new OperatingStation(scanner, belt);
        this.scanner = new Scanner(this);
    }

    public void scanHandBaggage(){
        rollerConveyor.getInspectorI1().pushHandBaggage(rollerConveyor.getTrays(), belt.getTrays());
        operatingStation.getInspectorI2().pushButton(operatingStation.getButtonLeft());
        operatingStation.getInspectorI2().pushButton(operatingStation.getButtonRectangle());
    }

    private void doNextStepAfterScanning(Tray tray, Record record){
        if(record.getResult().equals("knife") || record.getResult().equals("weapon") || record.getResult().equals("explosive")
        {
            //manuelle Nachkontrolle durch Inspektor I3 auf Track 01
            track1.putTray(tray);
            manualPostControl.getInspectorI3().doManualPostControl();

        }else{
            //Gib Passagier Handbaggage zurück über Track 02

        }


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
}

