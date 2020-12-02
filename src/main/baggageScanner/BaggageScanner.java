package main.baggageScanner;

import main.Status;
import main.passenger.HandBaggage;

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

    public void scanHandBaggage(HandBaggage[] handBaggage){
//        rollerConveyor.
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
}

