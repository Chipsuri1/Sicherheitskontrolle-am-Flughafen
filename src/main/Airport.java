package main;

import main.employee.HouseKeeper;
import main.employee.Technician;

import java.util.ArrayList;
import java.util.List;

import static main.configuration.Configuration.*;

public class Airport {

    private List<Passenger> passengerList = new ArrayList<Passenger>();

    private Technician technician = new Technician(6, "Jason Statham", "26.07.1967");
    private HouseKeeper houseKeeper = new HouseKeeper(7, "Jason Clarke", "17.07.1969");

    public Airport(){
        initPassengers();
    }


    private void initPassengers(){
        for(int i = 0; i < NUMBER_OF_PASSENGERS; i++){
            String[] content = fileReader.readContent(i, DATA_FILEPATH);

            String name = content[0];
            int numberOfBaggage = Integer.valueOf(content[1]);
            dataGenerator.generateBaggage(Integer.valueOf(content[1]), content[2]);
        }
    }


}
