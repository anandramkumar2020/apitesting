package com.experion

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation123 extends Simulation {

	val httpProtocol = http
		.baseUrl("https://computer-database.gatling.io")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.9")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")

	val headers_0 = Map(
		"sec-ch-ua" -> """Not_A Brand";v="8", "Chromium";v="120", "Google Chrome";v="120""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "none",
		"sec-fetch-user" -> "?1")

	val headers_1 = Map(
		"sec-ch-ua" -> """Not_A Brand";v="8", "Chromium";v="120", "Google Chrome";v="120""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "same-origin",
		"sec-fetch-user" -> "?1")

	val headers_2 = Map(
		"origin" -> "https://computer-database.gatling.io",
		"sec-ch-ua" -> """Not_A Brand";v="8", "Chromium";v="120", "Google Chrome";v="120""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows",
		"sec-fetch-dest" -> "document",
		"sec-fetch-mode" -> "navigate",
		"sec-fetch-site" -> "same-origin",
		"sec-fetch-user" -> "?1")



	val scn = scenario("RecordedSimulation123")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0))
		.pause(8)
		.exec(http("request_1")
			.get("/computers/381")
			.headers(headers_1))
		.pause(20)
		.exec(http("request_2")
			.post("/computers/381")
			.headers(headers_2)
			.formParam("name", "ACE")
			.formParam("introduced", "2001-01-01")
			.formParam("discontinued", "2008-08-08")
			.formParam("company", "1"))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}