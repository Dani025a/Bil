public class CarTest {
    public static void main(String[] args) {
        testSuit();
    }

    private static void testSuit() {
        System.out.println("Testsuiten kører");
        testStartBilWithWrongKey();
        TestStartWithRightKey();
        TestHandbrakeOn();
        TestHandBrakeOff();
        TestspeedUpAndBrake();
    }
    // Tester om bilens password virker og hvad der sker hvis man skriver den forkerte kode og rigtige kode
    private static void testStartBilWithWrongKey() {
        car audi = new car();
        CarKey key = new CarKey("BMWkey");
        audi.engine = "on";
        audi.turnEngineOn(key);
    }
    // Her tester vi om med den rigtige password
    private static void TestStartWithRightKey() {
        car audi = new car();
        CarKey key = new CarKey("Audikey");
        audi.engine = "on";
        audi.turnEngineOn(key);
    }
    //Vi tester om handbrake virker
    private static void TestHandbrakeOn() {
        car audi = new car();
        audi.handBreakOnOrOff = "on";
        audi.turnHandBrake();
    }
    //Vi tester om man kan slå det fra igen
    private static void TestHandBrakeOff() {
        car audi = new car();
        audi.handBreakOnOrOff = "off";
        audi.turnHandBrake();

    }
    //Her tester vi om du kan give gas, men også hvis vi sætter pedal som 0, da jeg har gjort at farten skal falde
    // Hvis den er på 0.
    //Vi tjekker også om bremserne virker og tester om den gemmer farten fra før.
    private static void TestspeedUpAndBrake() {
        car audi = new car();
        audi.pedal = 5;
        audi.timeForPedalDown = 10;
        audi.turnspeederup();

        audi.pedal = 0;
        audi.timeForPedalDown = 4;
        audi.turnspeederup();

        audi.pedal = 5;
        audi.timeForPedalDown = 100;
        audi.turnspeederup();

        audi.breakPedalDown = 5;
        audi.timeBreakPedalDown = 2;
        audi.turnbreakon();

        audi.breakPedalDown = 5;
        audi.timeBreakPedalDown = 200;
        audi.turnbreakon();

        audi.pedal = 2;
        audi.timeForPedalDown = 1;
        audi.turnspeederup();
    }
}
