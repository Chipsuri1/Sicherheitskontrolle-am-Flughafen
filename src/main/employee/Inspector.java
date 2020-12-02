package main.employee;

import main.MagnetStripe;
import main.ProfilType;
import main.baggageScanner.Tray;
import main.button.Button;

import java.util.Queue;

import static main.Type.staff;

public class Inspector extends Employee {

    private boolean isSenior;

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
        //TODO

    }
}
