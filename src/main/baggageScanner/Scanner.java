package main.baggageScanner;

import main.Status;

import java.util.PriorityQueue;
import java.util.Queue;

public class Scanner {

    private Queue<Tray> trays = new PriorityQueue<>();
    private BaggageScanner baggageScanner;

    public Scanner(BaggageScanner baggageScanner){
        this.baggageScanner = baggageScanner;
    }

    public void startScanning(){
        baggageScanner.setStatus(Status.inUse);
    }


    public Queue<Tray> getTrays() {
        return trays;
    }
}
