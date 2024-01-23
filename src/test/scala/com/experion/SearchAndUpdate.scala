package com.experion

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class SearchAndUpdate extends Simulation {

	val httpProtocol = http
		.baseUrl("https://computer-database.gatling.io")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.9")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")

	//Search Computers	GET	
	val search = scenario("User on Home Page and search for computer")
		.exec(http("User on Home Page")
			.get("/")
			)
		.pause(5)
		.exec(http("User search for a computer")
			.get("/computers/381")
			)
		.pause(5)	
		
	//Update Computer POST		
	val update = scenario("Admin updates computer details")
		.exec(http("Admin updates computer details")
			.post("/computers/381")
			.formParam("name", "ACE")
			.formParam("introduced", "2001-01-01")
			.formParam("discontinued", "2008-08-08")
			.formParam("company", "1"))
		.pause(5)	

	setUp(
		search.inject(rampUsers(10).during(3)),
		update.inject(atOnceUsers(2))
	).protocols(httpProtocol)
}