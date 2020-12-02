package main.baggageScanner;

import main.passenger.HandBaggage;

public class Tray {
    private HandBaggage handBaggage;

    public Tray(HandBaggage handBaggage){
        this.handBaggage = handBaggage;
    }

    public HandBaggage getHandBaggage() {
        return handBaggage;
    }
}
