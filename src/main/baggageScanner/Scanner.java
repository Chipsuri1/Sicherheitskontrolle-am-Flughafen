package main.baggageScanner;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Scanner {
    private Queue<Tray> trays = new LinkedList<>();

    public Queue<Tray> getTrays() {
        return trays;
    }
}
