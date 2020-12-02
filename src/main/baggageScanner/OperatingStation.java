package main.baggageScanner;

import main.button.ButtonLeft;
import main.button.ButtonRectangle;
import main.employee.Inspector;

public class OperatingStation {

    private Inspector inspectorL2 = new Inspector(2, "Natalie Portman", "09.06.1981", true);

    private CardReader cardReader;
    private ButtonLeft buttonLeft;
    private ButtonRectangle buttonRectangle;

    public OperatingStation(Scanner scanner, Belt belt){
        buttonLeft = new ButtonLeft(scanner, belt);
        buttonRectangle = new ButtonRectangle(scanner);
    }


    public Inspector getInspectorL2() {
        return inspectorL2;
    }

    public ButtonLeft getButtonLeft() {
        return buttonLeft;
    }

    public ButtonRectangle getButtonRectangle() {
        return buttonRectangle;
    }
}
