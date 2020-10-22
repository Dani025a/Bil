public class Car {
    private String password;
    public boolean engineStatus;
    int currentspeed = 0;
    public int timeForPedalDown;
    public int pedal;
    public int breakPedalDown;
    public int timeBreakPedalDown;
    public boolean airConStatus = false;
    public boolean handBreakStatus = false;
    public int airConTemp = 0;
    int gear;
    public boolean carStatus = true;

    Car(){
        this.password = "Audikey";
    }


public void turnspeederup(){
        if (handBreakStatus == true && gear < 0 && engineStatus == true) {
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
            if (gear == 1 && currentspeed >= 8 && currentspeed <= 40)
                System.out.println("Gå til 2. gear");
            if (gear == 1 && currentspeed <= 40){
                System.out.println("BILEN ER GÅET I STYKKER!");
                engineStatus = false;
                carStatus = false;
            }
            if (gear == 2 && currentspeed <= 40 && currentspeed >= 80)
                System.out.println("Gå til 3. gear, for du kører " + currentspeed + " Km/t");
            if (gear == 1 && currentspeed < 80){
                System.out.println("BILEN ER GÅET I STYKKER!");
                engineStatus = false;
                carStatus = false;
            }
            if (gear == 3 && currentspeed >= 80 && currentspeed >= 120)
                System.out.println("Gå til 4. gear, for du kører " + currentspeed + " Km/t");
            if (gear == 1 && currentspeed < 120){
                System.out.println("BILEN ER GÅET I STYKKER!");
                engineStatus = false;
                carStatus = false;
            }

            if (gear == 4 && currentspeed >= 8)
                System.out.println("Gå til 5. gear, for du kører " + currentspeed + " Km/t");
            if (gear == 1 && currentspeed <= 40){
                System.out.println("BILEN ER GÅET I STYKKER!");
                engineStatus = false;
                carStatus = false;
            }
            if (gear == 5 && currentspeed >= 8)
                System.out.println("Gå til fjerder gear, for du kører " + currentspeed + " Km/t");
            if (gear == 1 && currentspeed <= 40){
                System.out.println("BILEN ER GÅET I STYKKER!");
                engineStatus = false;
                carStatus = false;
            }



                else
            System.out.println("Din hastighed er på " + currentspeed + " Km/t");
        }
        else if (handBreakStatus == false || gear == 0 || engineStatus == false) {
            if (handBreakStatus== false)
                System.out.println("Husk at hive i håndbremsen");
            if (gear == 0)
                System.out.println("Husk at sætte den i gear");
            if (engineStatus == false)
                System.out.println("bilen er slukket");
        }
    }

public void turnEngineOn(CarKey key) {
        if (key.password.equals(password) && engineStatus == false) {
            System.out.println("Bilen er tændt");
            engineStatus = true;
        }
        else if (key.password.equals(password) && engineStatus == true) {
            System.out.println("Bilen er allerede tændt");
        }
        else {
            System.out.println("Forkert nøgle!");
            for (int i = 0; i < 10; i++) {
                System.out.println("BIP BIP BIP... Nogen prøver at stjæle bilen!");
            }
        }
    }

public void turnEngineOff(){
        if (engineStatus == true) {
            System.out.printf("Bilen er nu slukket");
            engineStatus = false;
        }
        else if (engineStatus == false) {
            System.out.println("\nBilen er allerede slukket");
        }
    }

public void turnHandBrakeOn(){
        if (handBreakStatus == false){
            System.out.println("Håndbremsen er nu slået til.");
            handBreakStatus = true;
        }
        else if (handBreakStatus == true){
            System.out.println("Håndbremsen er allerde slået til.");
        }
    }

public void turnHandBrakeOff() {
        if (handBreakStatus == false) {
            System.out.println("Håndbremsen er allerede slået fra.");
        } else if (handBreakStatus == true) {
            System.out.println("Håndbremsen er nu slået fra.");
            handBreakStatus = false;
        }
    }

public void turnBreakOn() {
    if (currentspeed != 0) {
        for (int i = 0; i < timeBreakPedalDown; i++) {
            int breaking = breakPedalDown * 5;

            currentspeed -= breaking;
        }
    }
    else
        System.out.println("Du kører ikke, men holder foden på bremsen");

    if (currentspeed < 0) {
        currentspeed = 0;
        System.out.println("Du har nu nået den laveste hastighed");
    }

    System.out.println("Du bremser nu, og din fart er nu: " + currentspeed + " Km/t");

}

public void turnOnAircon() {
    if (engineStatus == true && airConStatus == false) {
        airConStatus = true;
        System.out.println("Aircondition er nu tændt, temperaturen er sat til: " + airConTemp);
    }
    else if (airConStatus == true && engineStatus == true)
        System.out.println("Aircondition er allerede tændt og temperaturen er sat til: " + airConTemp);
    else
        System.out.println("bilen er slukket, derfor kan du ikke tænde for aircondition");
}

public void turnOffAircon(){
    if (engineStatus == false && airConStatus == true) {
        airConStatus = true;
        System.out.println("Aircondition er nu slukket");
    }
    else if (airConStatus == false && engineStatus == true)
        System.out.println("Aircondition er allerede slukket");
    else
        System.out.println("bilen er slukket, derfor er Aircondition slukket");
}

public void setAirConTemp(){
    System.out.println("temperaturen er nu sat til:" + airConTemp);
}

public void setGear(){
    System.out.println("du er nu i " + gear + " gear");
}
}






