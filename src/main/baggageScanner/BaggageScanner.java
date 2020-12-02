package main.baggageScanner;

import main.Record;
import main.Result;
import main.Status;

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

    public void scanHandBaggage(){
        rollerConveyor.getInspectorI1().pushHandBaggage(rollerConveyor.getTrays(), belt.getTrays());
        operatingStation.getInspectorI2().pushButton(operatingStation.getButtonLeft(), scanner, belt);
    }

    private void doNextStepAfterScanning(Tray tray, Record record){
        if(record.getResult().equals(Result.knife) || record.getResult().equals(Result.weapon) || record.getResult().equals(Result.explosive)
        {
            //manuelle Nachkontrolle durch Inspektor I3 auf Track 01
            track1.putTray(tray);
            manualPostControl.getInspectorI3().doManualPostControl();

        }else{
            //Gib Passagier Handbaggage zurück über Track 02
            track2.putTray(tray);
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

