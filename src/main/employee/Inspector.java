package main.employee;

import main.MagnetStripe;
import main.ProfilType;
import main.Record;
import main.Result;
import main.baggageScanner.Belt;
import main.baggageScanner.Scanner;
import main.baggageScanner.Tray;
import main.button.Button;

import java.util.Queue;

import static main.Type.staff;

public class Inspector extends Employee {

    private boolean isSenior;
    private Record record;

    public Inspector(int id, String name, String birthDate, boolean isSenior) {
        super(id, name, birthDate);

        this.isSenior = isSenior;

        getIdCard().setType(staff);
        getIdCard().setMagnetStripe(new MagnetStripe(ProfilType.I, getIdCard().getSecretKey()));
    }

    public void pushHandBaggage(Queue<Tray> rollerConveyor , Queue<Tray> belt){
        int sizeOfRollerConveyor = rollerConveyor.size();
        for(int i = 0; i < sizeOfRollerConveyor; i++){
            Tray tray = rollerConveyor.poll();
            belt.offer(tray);
        }
    }

    public void pushButton(Button button){
        button.buttonAction();
    }

    public void doManualPostControl() {
        if(record.getResult().equals(Result.knife))
        {
            operatingStation.getInspectorI2().tellOtherInspektor(manualPostControl.getInspectorI3(), String.valueOf(record.getResult()));

        }
        else if(record.getResult().equals(Result.weapon)){

        }
        else {

        }

    }

    public void tellOtherInspektor(Inspector inspektor, String sentence){
        inspektor.hearSentence(sentence);
    }

    public void hearSentence(String sentence){
    }
}
