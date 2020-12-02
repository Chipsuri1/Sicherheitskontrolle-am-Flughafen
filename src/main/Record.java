package main;

import java.sql.Timestamp;
import java.util.UUID;

public class Record {

    private UUID id;
    private Timestamp timeStamp;
    private ResultScan resultScan;

    public Record(ResultScan resultScan){
        this.resultScan = resultScan;
        this.id = UUID.randomUUID();
        this.timeStamp = new Timestamp(System.currentTimeMillis());
    }

    public ResultScan getResult() {
        return resultScan;
    }

    public UUID getId() {
        return id;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }
}
