package main.baggageScanner;

import main.Record;
import main.Result;
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
            Tray tray = trays.peek();

            StringBuilder stringBuilder = new StringBuilder();

            for(int j = 0; j < Configuration.instance.NUMBER_OF_CONTENT_PER_LAYER; j++){
                stringBuilder.append(tray.getHandBaggage().getLayers()[j]);
            }

            List<String> patterns = new ArrayList<>(Arrays.asList("K", "W", "E"));

            String position = null;

            for(String pattern : patterns) {
                switch (Configuration.instance.searchType) {
                    case BoyerMoore:
                        position = Configuration.instance.boyerMoore.search(stringBuilder.toString(), pattern);
                    case KnuthMorrisPratt:
                        position = Configuration.instance.knuthMorrisPratt.search(stringBuilder.toString(), pattern);
                }

                Record record = null;

                if(position.equals("clean")){
                    record = new Record(new Result(ScanResult.clean, position));
                }else{
                    ScanResult scanResult = null;
                    String result = null;

                    switch (pattern){
                        case "K":
                            scanResult = ScanResult.knife;
                            result = "knife";
                        case "W":
                            scanResult = ScanResult.weapon;
                            result = "weapon - glock7";
                        case "E":
                            scanResult = ScanResult.explosive;
                            result = "explosive";
                    }
                    record = new Record(new Result(scanResult, "prohibited item | " + result + "detected at position " + position));
                }

                records.add(record);
                tray.setRecord(record);

            }
        }

        baggageScanner.setStatus(Status.activated);
    }

    public Queue<Record> getRecords() {
        return records;
    }

    public Queue<Tray> getTrays() {
        return trays;
    }
}
