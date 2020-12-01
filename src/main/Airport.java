package main;

import java.util.ArrayList;
import java.util.List;

import static main.Configuration.*;

public class Airport {

    private FileReader fileReader = new FileReader();

    private List<Passenger> passengerList = new ArrayList<Passenger>();

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
