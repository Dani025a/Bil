public class CarTest {

    public static void main(String[] args) {
        testSuit();
    }

    private static void testSuit() {
        System.out.println("Testsuiten kører");
        testStartBilWithWrongKey();
        TestStartWithRightKey();
        TestHandbrake();
        TestspeedUpAndBrake();
    }
    // Tester om bilens password virker og hvad der sker hvis man skriver den forkerte kode og rigtige kode
    private static void testStartBilWithWrongKey() {
        Car audi = new Car();
        CarKey key = new CarKey("BMWkey");
        audi.turnEngineOn(key);
    }
    // Her tester vi om med den rigtige password
    private static void TestStartWithRightKey() {
        Car audi = new Car();
        CarKey key = new CarKey("Audikey");
        audi.turnEngineOn(key);
        audi.turnEngineOff();
        audi.turnEngineOff();
        audi.turnEngineOn(key);
        audi.turnEngineOn(key);
    }
    //Vi tester om handbrake virker
    private static void TestHandbrake() {
        Car audi = new Car();
        audi.turnHandBrakeOn();
        audi.turnHandBrakeOn();
        audi.turnHandBrakeOff();
        audi.turnHandBrakeOff();
    }
    //Vi tester om man kan slå det fra igen

    //Her tester vi om du kan give gas, men også hvis vi sætter pedal som 0, da jeg har gjort at farten skal falde
    // Hvis den er på 0.
    //Vi tjekker også om bremserne virker og tester om den gemmer farten fra før.
    private static void TestspeedUpAndBrake() {
        Car audi = new Car();
        CarKey key = new CarKey("Audikey");
        audi.turnEngineOn(key);
        audi.turnHandBrakeOn();
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
        audi.turnBreakOn();

        audi.breakPedalDown = 5;
        audi.timeBreakPedalDown = 200;
        audi.turnBreakOn();

        audi.pedal = 2;
        audi.timeForPedalDown = 1;
        audi.turnspeederup();
    }
}
