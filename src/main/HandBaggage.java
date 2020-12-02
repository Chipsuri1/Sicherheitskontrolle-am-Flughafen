package main;

public class HandBaggage {

    private Layer[] layers = new Layer[5];

    public HandBaggage(){
        for(int i = 0; i < layers.length; i++){
            layers[i] = new Layer();
        }
    }

    public Layer[] getLayers() {
        return layers;
    }
}
