package main;

import main.configuration.Configuration;

public class TestStripe {
    char[][] content = new char[30][10];

    public TestStripe(){
        for(char[] chars : content){
            for(char c : chars){
                c = 'p';
            }
        }
    }

    public void setExp(){
        String string = "exp";

        int randomLength = Configuration.instance.mersenneTwister.nextInt(30);
        int randomPosition = Configuration.instance.mersenneTwister.nextInt(10-1-string.length());

        for(int i = 0; i < string.length(); i++){
            content[randomLength][randomPosition+i] = string.charAt(i);
        }

    }
}
