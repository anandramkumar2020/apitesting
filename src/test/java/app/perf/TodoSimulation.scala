package app.perf

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class TodoSimulation extends Simulation {

  val protocol = karateProtocol(
    
  )

  val main = scenario("main").exec(karateFeature("classpath:apifunctionaltest/006-PerfTest.feature")) 
  
  

  setUp(
    main.inject(rampUsers(5) during (20 seconds)).protocols(protocol)
  )
}