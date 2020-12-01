package main.baggageScanner;

import main.Status;

import static main.Status.shutdown;
import static main.Status.start;

public class BaggageScanner {

    private Tray tray;
    private Scanner scanner;
    private Belt belt;
    private Supervision supervision;
    private ManualPostControl manualPostControl;
    private OperatingStation operatingStation;
    private RollerConveyor rollerConveyor;

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

