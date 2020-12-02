package main;

import main.configuration.Configuration;


public class MagnetStripe {

    private ProfilType profilType;
    private String pin;

    public MagnetStripe(ProfilType profilType, String secretKey){
        this.profilType = profilType;
//        int pinInt = Configuration.instance.mersenneTwister.nextInt(1000, 9999);
        int pinInt = 5000;
        this.pin = Configuration.instance.aes.encrypt(String.valueOf(pinInt), secretKey);

    }


    public ProfilType getProfilType() {
        return profilType;
    }

    public String getPin() {
        return pin;
    }
}
