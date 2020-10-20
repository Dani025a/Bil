public class car {

    private String password;
    public boolean engineOn = false;
    public int timeForPedalDown;
    public int pedal;
    public int currentspeed = 0;
    public int breakPedalDown;
    public int timeBreakPedalDown;
    car(){
        this.password = "Password1234";

    }
    public void turnEngineOn(CarKey key) {
        if (key.password.equals("Password1234")){
            System.out.println("Bilen er tændt");
            engineOn = true;
    }
        else
        System.out.println("Bilen er slukket");
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
public void turnbreakon() {
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

}
}






