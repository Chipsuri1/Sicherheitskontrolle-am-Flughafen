package main.baggageScanner;

import java.util.PriorityQueue;
import java.util.Queue;

public class Scanner {
    private Queue<Tray> trays = new PriorityQueue<>();

    public Queue<Tray> getTrays() {
        return trays;
    }
}
