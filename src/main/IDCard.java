package main;

import java.util.UUID;

public class IDCard {

    private UUID id;
    private String validUntil;
    private MagnetStripe magnetStripe;
    private boolean isLocked;
    private Type type;

    public IDCard(){
        id = UUID.randomUUID();
        validUntil = "26.07.2025";
        magnetStripe = null;
        isLocked = false;
        type = null;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public void setMagnetStripe(MagnetStripe magnetStripe) {
        this.magnetStripe = magnetStripe;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
