public class car {

    private String password;
    public boolean engineStatus;
    public String engine;
    public int timeForPedalDown;
    public int pedal;
    public int currentspeed;
    public int breakPedalDown;
    public int timeBreakPedalDown;
    public String handBreakOnOrOff;
    public boolean handBreakStatus;
    car(){
        this.password = "Audikey";
        this.engineStatus = false;
        this.handBreakStatus = true;

    }
    public void turnEngineOn(CarKey key) {
        if (key.password.equals(password) && engineStatus == false && engine.equals("on")){
            System.out.println("Bilen er tændt");
            engineStatus = true;
    }
        else if (key.password.equals(password) && engineStatus == true && engine.equals("off")) {
            System.out.printf("Bilen er nu slukket");
            engineStatus = false;
        }
        else if (key.password.equals(password) && engineStatus == false && engine.equals("off")){
            System.out.println("Bilen er allerede slukket");
        }
        else if (key.password.equals(password) && engineStatus == true && engine.equals("on")){
            System.out.println("Bilen er allerede tændt");
        }
        else {
            System.out.println("Forkert nøgle!");
            for (int i = 0; i < 10; i++) {
                System.out.println("BIP BIP BIP... Nogen prøver at stjæle bilen!");
            }
        }
        }
    public void turnHandBrake(){
        if (handBreakOnOrOff.equals("on") && handBreakStatus == false){
            System.out.println("Håndbremsen er nu slået til.");
            handBreakStatus = true;
        }
        else if (handBreakOnOrOff.equals("off") && handBreakStatus == true){
            System.out.println("Håndbremsen er nu slået fra.");
            handBreakStatus = false;
        }
        else if (handBreakOnOrOff.equals("on") && handBreakStatus == true){
            System.out.println("Håndbremsen er allerde slået til.");
        }
        else if (handBreakOnOrOff.equals("off") && handBreakStatus == false){
            System.out.println("Håndbremsen er allerede slået fra.");
        }

    }
        public int turnspeederup(){

            for (int i = 0; i < timeForPedalDown; i++) {

                if (pedal > 0 && pedal <= 5) {

                    int speedup = pedal * 2;
                    currentspeed += speedup;
                } else if (pedal == 0) {
                    int speedup = pedal - 1;
                    currentspeed += speedup;

                }
            }
            if (currentspeed >= 230) {
                currentspeed = 230;
                System.out.println("Du har nået maksimale hastighed ");
            } else if (currentspeed <= 0) {
                currentspeed = 0;
                System.out.println("Du har nu nået den laveste hastighed");
            }

            System.out.println("Din hastighed er på " + currentspeed + " Km/t");
            return currentspeed;
        }
public int turnbreakon() {
    if (currentspeed != 0) {
        for (int i = 0; i < timeBreakPedalDown; i++) {
            int breaking = breakPedalDown * 5;

            currentspeed -= breaking;
        }
    }
    else
        System.out.println("Du kører ikke, men holder foden på bremsen");
    if (currentspeed < 0)
    currentspeed = 0;

    System.out.println("Du bremser nu, og din fart er nu: " + currentspeed + " Km/t");

    return currentspeed;
}
}






