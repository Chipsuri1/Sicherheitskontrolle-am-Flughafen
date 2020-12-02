package main.baggageScanner;

import main.IDCard;
import main.ProfilType;
import main.configuration.Configuration;


public class CardReader {


    public boolean scanCard(IDCard idCard, String pin){
        if(idCard.getMagnetStripe().getProfilType().equals(ProfilType.O) || idCard.getMagnetStripe().getProfilType().equals(ProfilType.K)){
            return false;
        }

        int amountOfTries = 0;
        while (amountOfTries <=2){
            String validPin = Configuration.instance.aes.encrypt(idCard.getMagnetStripe().getPin(), idCard.getSecretKey());
            if(validPin.equals(pin)){
                return true;
            }else{
                amountOfTries++;
            }
        }
        return false;
    }
}
