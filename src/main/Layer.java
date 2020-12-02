package main;

import static main.configuration.Configuration.NUMBER_OF_CONTENT_PER_LAYER;
import static main.configuration.Configuration.mersenneTwister;

public class Layer {

    private char[] content = new char[NUMBER_OF_CONTENT_PER_LAYER];

    public Layer(){
        fillLayers();
    }

    private void fillLayers(){
        final String string = "abcdefghijklmnopqrstuvwxyz";

        for(int i = 0; i < content.length; i++){
            int randomChar = mersenneTwister.nextInt(string.length());
            content[i] = string.charAt(randomChar);
        }
    }

    public char[] getContent() {
        return content;
    }

}
