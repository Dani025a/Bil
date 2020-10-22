public class CarTest {
    private static Object EngineStatus;

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
        EngineStatus engineStatus = new EngineStatus(false);
        audi.engine = String.valueOf(CarState.on);
        audi.turnEngineOn(key, engineStatus);
    }
    // Her tester vi om med den rigtige password
    private static void TestStartWithRightKey() {
        Car audi = new Car();
        CarKey key = new CarKey("Audikey");
        EngineStatus engineStatus = new EngineStatus(false);
        audi.engine = String.valueOf(CarState.on);
        audi.turnEngineOn(key, engineStatus);
        audi.engine = String.valueOf(CarState.on);
        audi.turnEngineOn(key, engineStatus);
    }
    //Vi tester om handbrake virker
    private static void TestHandbrake() {
        Car audi = new Car();
        handBrakeStatus handbrake = new handBrakeStatus(false);
        audi.turnHandBrakeOn(handbrake);
    }
    //Vi tester om man kan slå det fra igen

    //Her tester vi om du kan give gas, men også hvis vi sætter pedal som 0, da jeg har gjort at farten skal falde
    // Hvis den er på 0.
    //Vi tjekker også om bremserne virker og tester om den gemmer farten fra før.
    private static void TestspeedUpAndBrake() {
        Car audi = new Car();
        Currentspeed currentspeed = new Currentspeed(0);
        audi.pedal = 5;
        audi.timeForPedalDown = 10;
        audi.turnspeederup(currentspeed);

        audi.pedal = 0;
        audi.timeForPedalDown = 4;
        audi.turnspeederup(currentspeed);

        audi.pedal = 5;
        audi.timeForPedalDown = 100;
        audi.turnspeederup(currentspeed);

        audi.breakPedalDown = 5;
        audi.timeBreakPedalDown = 2;
        audi.turnBreakOn(currentspeed);

        audi.breakPedalDown = 5;
        audi.timeBreakPedalDown = 200;
        audi.turnBreakOn(currentspeed);

        audi.pedal = 2;
        audi.timeForPedalDown = 1;
        audi.turnspeederup(currentspeed);
    }
}
