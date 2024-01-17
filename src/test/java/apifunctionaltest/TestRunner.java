package apifunctionaltest;

import com.intuit.karate.junit5.Karate;

public class TestRunner {

//	Run a specific feature
//  Shell cmd --> .\mvnw clean test -Dtest="TestRunner#testScenario"	
	@Karate.Test
	Karate testScenario() {
		return Karate.run("002-Match").tags("@runonlythis").relativeTo(getClass());
	}
	
	

//	Run a specific feature having tag
//  Shell cmd --> .\mvnw clean test -Dtest="TestRunner#testTags"
	@Karate.Test
	Karate testTags() {
		return Karate.run("ConfigDemo").tags("@runonlythis").relativeTo(getClass());
	}

//	Run all tests
//  Shell cmd --> .\mvnw clean test -Dtest="TestRunner#testAll"	
	@Karate.Test
	Karate testAll() {
		return Karate.run().relativeTo(getClass());
	}
}