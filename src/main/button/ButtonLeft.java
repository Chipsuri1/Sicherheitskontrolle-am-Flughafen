package main.button;

import main.baggageScanner.Belt;
import main.baggageScanner.Scanner;

public class ButtonLeft extends Button {

    public void buttonAction(Scanner scanner, Belt belt){
        int sizeOfBeltHandBaggage = belt.getTrays().size();
        for(int i = 0; i < sizeOfBeltHandBaggage; i++){
            scanner.getTrays().offer(belt.getTrays().poll());
        }
    }
}
