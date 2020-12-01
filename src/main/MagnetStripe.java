package main;

import static main.configuration.Configuration.mersenneTwister;

public class MagnetStripe {

    private ProfilType profilType;
    private int pin;

    public MagnetStripe(ProfilType profilType){
        this.profilType = profilType;

        this.pin = mersenneTwister.nextInt(1000, 9999);
    }


}
