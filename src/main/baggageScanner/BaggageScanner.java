package main.baggageScanner;

import main.Record;
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

    public void scanHandBaggage(){
        rollerConveyor.getInspectorL1().pushHandBaggage(rollerConveyor.getTrays(), belt.getTrays());
        operatingStation.getInspectorL2().pushButton(operatingStation.getButtonLeft(), scanner, belt);
    }

    private void doNextStepAfterScanning(Record record){
        if(record.getResult().equals("knife") || record.getResult().equals("weapon") || record.getResult().equals("explosive")
        {
            //manuelle Nachkontrolle durch Inspektor I3 auf Track 01
            manualPostControl.

        }else{
            //Gib Passagier Handbaggage zurück über Track 02

        }


    }



    private Status status = shutdown;

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

