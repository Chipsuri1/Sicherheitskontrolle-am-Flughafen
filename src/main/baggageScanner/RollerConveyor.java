package main.baggageScanner;

import main.employee.Inspector;

import java.util.PriorityQueue;
import java.util.Queue;

public class RollerConveyor {

    private Inspector inspectorL1 = new Inspector(1, "Clint Eastwood", "31.05.1930", true);
    private Queue<Tray> trays = new PriorityQueue<>();


    public Queue<Tray> getTrays() {
        return trays;
    }

    public Inspector getInspectorL1() {
        return inspectorL1;
    }
}
