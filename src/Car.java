public class Car {
    private String password;
    public String engine;
    public int timeForPedalDown;
    public int pedal;
    public int breakPedalDown;
    public int timeBreakPedalDown;
    public String handBreakOnOrOff;
    public boolean handBreakStatus;

    Car(){
        this.password = "Audikey";
    }


    public int turnspeederup(Currentspeed currentspeed){
        for (int i = 0; i < timeForPedalDown; i++) {

            if (pedal > 0 && pedal <= 5) {

                int speedup = pedal * 2;
                currentspeed.currentspeed += speedup;
            } else if (pedal == 0) {
                int speedup = pedal - 1;
                currentspeed.currentspeed += speedup;

            }
        }
        if (currentspeed.currentspeed >= 230) {
            currentspeed.currentspeed = 230;
            System.out.println("Du har nået maksimale hastighed ");
        } else if (currentspeed.currentspeed <= 0) {
            currentspeed.currentspeed = 0;
            System.out.println("Du har nu nået den laveste hastighed");
        }

        System.out.println("Din hastighed er på " + currentspeed.currentspeed + " Km/t");
        return currentspeed.currentspeed;
    }

    public void turnEngineOn(CarKey key, EngineStatus engineStatus) {
        if (key.password.equals(password) && engineStatus.engineStatus == false && engine.equals("on")) {
            System.out.println("Bilen er tændt");
            engineStatus.engineStatus = true;
        }
        else if (key.password.equals(password) && engineStatus.engineStatus == true && engine.equals("on")) {
            System.out.println("Bilen er allerede tændt");
        }
        else {
            System.out.println("Forkert nøgle!");
            for (int i = 0; i < 10; i++) {
                System.out.println("BIP BIP BIP... Nogen prøver at stjæle bilen!");
            }
        }
    }

    public boolean turnEngineOff(EngineStatus engineStatus){
        if (engineStatus.engineStatus == true) {
            System.out.printf("Bilen er nu slukket");
            engineStatus.engineStatus = false;
        }
        else if (engineStatus.engineStatus == false) {
            System.out.println("Bilen er allerede slukket");
        }
        return engineStatus.engineStatus;
    }

    public boolean turnHandBrakeOn(handBrakeStatus handBrakeStatus){
        if (handBreakOnOrOff.equals("on") && handBrakeStatus.handbrakeStatus == false){
            System.out.println("Håndbremsen er nu slået til.");
            handBreakStatus = true;
        }
        else if (handBreakOnOrOff.equals("on") && handBrakeStatus.handbrakeStatus == true){
            System.out.println("Håndbremsen er allerde slået til.");
        }
        return handBrakeStatus.handbrakeStatus;
    }

    public boolean turnHandBrakeOff(handBrakeStatus handBrakeStatus) {
        if (handBrakeStatus.handbrakeStatus == false) {
            System.out.println("Håndbremsen er allerede slået fra.");
        } else if (handBrakeStatus.handbrakeStatus == true) {
            System.out.println("Håndbremsen er nu slået fra.");
            handBreakStatus = false;
        }
        return handBrakeStatus.handbrakeStatus;
    }

public int turnBreakOn(Currentspeed currentspeed) {
    if (currentspeed.currentspeed != 0) {
        for (int i = 0; i < timeBreakPedalDown; i++) {
            int breaking = breakPedalDown * 5;

            currentspeed.currentspeed -= breaking;
        }
    }
    else
        System.out.println("Du kører ikke, men holder foden på bremsen");

    if (currentspeed.currentspeed < 0) {
        currentspeed.currentspeed = 0;
        System.out.println("Du har nu nået den laveste hastighed");
    }

    System.out.println("Du bremser nu, og din fart er nu: " + currentspeed.currentspeed + " Km/t");

    return currentspeed.currentspeed;
}
}






