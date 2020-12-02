package main.baggageScanner;

import main.Status;

import static main.Status.shutdown;
import static main.Status.start;

public class BaggageScanner {

    private OperatingStation operatingStation = new OperatingStation();
    private ManualPostControl manualPostControl = new ManualPostControl();
    private RollerConveyor rollerConveyor = new RollerConveyor();
    private Belt belt = new Belt();
    private Supervision supervision = new Supervision();

    private Track track1 = new Track();
    private Track track2 = new Track();

    public void scanHandBaggage(){
        rollerConveyor.getInspectorL1().pushHandBaggage(rollerConveyor.getTrays(), belt.getTrays());
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

