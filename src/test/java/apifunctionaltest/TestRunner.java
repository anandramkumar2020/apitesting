package apifunctionaltest;

import com.intuit.karate.junit5.Karate;

/**
 * Karate TestRunner class for executing API functional tests.
 */
public class TestRunner {

    /**
     * Run a specific feature with a targeted scenario.
     * Shell command: .\mvnw clean test -Dtest="TestRunner#testScenario"
     *
     * @return Karate object representing the executed test scenario.
     */
    @Karate.Test
    Karate testScenario() {
        return Karate.run("004-CRUD").tags("@runonlythis").relativeTo(getClass());
    }

    /**
     * Run a specific feature with a specified tag.
     * Shell command: .\mvnw clean test -Dtest="TestRunner#testTags"
     *
     * @return Karate object representing the executed test scenario.
     */
    @Karate.Test
    Karate testTags() {
        return Karate.run("ConfigDemo").tags("@runonlythis").relativeTo(getClass());
    }

    /**
     * Run all API functional tests.
     * Shell command: .\mvnw clean test -Dtest="TestRunner#testAll"
     *
     * @return Karate object representing the executed test scenarios.
     */
    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }
}