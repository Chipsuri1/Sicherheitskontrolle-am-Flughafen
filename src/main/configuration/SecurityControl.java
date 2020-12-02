package main.configuration;

import main.baggageScanner.BaggageScanner;
import main.employee.HouseKeeper;
import main.employee.Technician;
import main.passenger.HandBaggage;
import main.passenger.Passenger;

import java.util.PriorityQueue;
import java.util.Queue;

import static main.configuration.Configuration.*;

public class SecurityControl {

    private Queue<Passenger> passengerList = new PriorityQueue<>();
    private BaggageScanner baggageScanner = new BaggageScanner();

    private Technician technician = new Technician(6, "Jason Statham", "26.07.1967");
    private HouseKeeper houseKeeper = new HouseKeeper(7, "Jason Clarke", "17.07.1969");

    public SecurityControl(){
        initPassengers();
    }

    private void checkPassengers(){
        for(int i = 0; i < NUMBER_OF_PASSENGERS; i++){
            Passenger passenger = passengerList.poll();

            baggageScanner.scanHandBaggage(passenger.getHandBaggage());

        }

    }




    private void initPassengers(){
        for(int i = 0; i < NUMBER_OF_PASSENGERS; i++){
            String[] content = fileReader.readContent(i, DATA_FILEPATH);

            String name = content[0];
            HandBaggage[] handBaggage = dataGenerator.generateBaggage(Integer.valueOf(content[1]), content[2]);

            passengerList.add(new Passenger(name, handBaggage));
        }
    }


}
