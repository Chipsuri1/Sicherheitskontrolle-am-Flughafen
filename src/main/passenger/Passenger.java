package main.passenger;

public class Passenger {

    private String name;
    private HandBaggage[] handBaggage;

    public Passenger(String name, HandBaggage[] handBaggage){
        this.handBaggage = handBaggage;
    }

    public HandBaggage[] getHandBaggage() {
        return handBaggage;
    }
}
