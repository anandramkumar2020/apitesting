package com.experion

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class DeleteComputer extends Simulation {

	val httpProtocol = http
		.baseUrl("https://computer-database.gatling.io")
		.disableFollowRedirect
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.5")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:121.0) Gecko/20100101 Firefox/121.0")

	val headers_0 = Map(
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "none",
		"Sec-Fetch-User" -> "?1")

	val headers_1 = Map(
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Sec-Fetch-User" -> "?1")

	val headers_2 = Map(
		"Origin" -> "https://computer-database.gatling.io",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Sec-Fetch-User" -> "?1")



	val scn = scenario("DeleteComputer")
		.exec(http("request_0")
			.get("/computers")
			.headers(headers_0))
		.pause(2)
		.exec(http("request_1")
			.get("/computers/382")
			.headers(headers_1))
		.pause(2)
		.exec(http("request_2")
			.post("/computers/382/delete")
			.headers(headers_2)
			.resources(http("request_3")
			.get("/computers")
			.headers(headers_1))
			.check(status.is(303)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}