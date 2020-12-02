package main;

import static main.configuration.Configuration.aes;
import static main.configuration.Configuration.mersenneTwister;

public class MagnetStripe {

    private ProfilType profilType;
    private String pin;

    public MagnetStripe(ProfilType profilType, String secretKey){
        this.profilType = profilType;
        int pinInt = mersenneTwister.nextInt(1000, 9999);
        this.pin = aes.decrypt(String.valueOf(pinInt), secretKey);

    }


    public ProfilType getProfilType() {
        return profilType;
    }

    public String getPin() {
        return pin;
    }
}
