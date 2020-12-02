package main.configuration;

import main.passenger.HandBaggage;

import static main.configuration.Configuration.NUMBER_OF_CONTENT_PER_LAYER;
import static main.configuration.Configuration.mersenneTwister;

public class DataGenerator {

    public void generateBaggage(int numberOfBaggage, String content){

        HandBaggage[] handBaggage = new HandBaggage[numberOfBaggage];

        for(int i = 0; i < numberOfBaggage; i++){
            handBaggage[i] = new HandBaggage();
        }

        if(!content.equals("-")){
            content = content.substring(1, content.length()-1);
            String[] parts = content.split(";");

            for(int i = 0; i < parts.length; i++){
                String[] strings = parts[i].split(",");

                int randomPosition = mersenneTwister.nextInt(NUMBER_OF_CONTENT_PER_LAYER);

                char prohibitedItem = strings[0].charAt(0);

                handBaggage[Integer.valueOf(strings[1])-1].getLayers()[2].getContent()[randomPosition] = prohibitedItem;
            }
        }

    }
}
