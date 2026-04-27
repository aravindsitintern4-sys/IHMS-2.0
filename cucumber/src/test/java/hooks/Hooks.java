package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.AfterAll;
import utils.DriverFactory;

public class Hooks {

    private static boolean isStarted = false;

    @Before
    public void setup() {

        if (!isStarted) {
            DriverFactory.initDriver();
            isStarted = true;
        }
    }

    @AfterAll
    public static void tearDown() {
//        DriverFactory.quitDriver();
    }
}