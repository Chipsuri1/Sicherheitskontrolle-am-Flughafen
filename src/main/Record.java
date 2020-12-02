package main;

import java.sql.Timestamp;

public class Record {

    private String id;
    private Timestamp timeStamp;
    private Result result;

    public Record(String id, Result result){
        this.id = id;
        this.result = result;
        timeStamp = new Timestamp(System.currentTimeMillis());
    }

    public Result getResult() {
        return result;
    }

    public String getId() {
        return id;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }
}
