package main.baggageScanner;

import main.Record;
import main.ScanResult;
import main.Status;
import main.configuration.Configuration;

import java.util.*;

public class Scanner {

    private Queue<Tray> trays = new LinkedList<>();
    private Queue<Record> records = new LinkedList<>();
    private BaggageScanner baggageScanner;

    public Scanner(BaggageScanner baggageScanner){
        this.baggageScanner = baggageScanner;
    }

    public void startScanning(){
        baggageScanner.setStatus(Status.inUse);

        int size = trays.size();
        for(int i = 0; i < size; i++){
            Tray tray = trays.poll();

            StringBuilder stringBuilder = new StringBuilder();

            for(int j = 0; j < Configuration.instance.NUMBER_OF_CONTENT_PER_LAYER; j++){
                stringBuilder.append(tray.getHandBaggage().getLayers()[j]);
            }

            List<String> patterns = new ArrayList<>(Arrays.asList("K", "W", "E"));

            ScanResult resultScan = null;

            for(String pattern : patterns) {
                switch (Configuration.instance.searchType) {
                    case BoyerMoore:
                        resultScan = Configuration.instance.boyerMoore.search(stringBuilder.toString(), pattern);
                    case KnuthMorrisPratt:
                        resultScan = Configuration.instance.knuthMorrisPratt.search(stringBuilder.toString(), pattern);
                }

                records.add(new Record(resultScan));
            }

        }


        baggageScanner.setStatus(Status.activated);
    }


    public Queue<Tray> getTrays() {
        return trays;
    }
}
