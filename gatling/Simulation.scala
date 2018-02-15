
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class ServiceSimulation extends Simulation {
    var name="async"
    var users=1
    var rampupTime=30 seconds
    var delay=1
    var repeatTimes=1

	var url="http://localhost:8080"
    

    def startup(){
        val httpProtocol = http.baseURL(url)

        val page = repeat(repeatTimes, "n") {
            exec(http(name)
                .get("/user/"+name+"?delay="+delay)
            )
        }
        
        val scn = scenario("page").exec(page)
        
        setUp(scn.inject(rampUsers(users).over(rampupTime))).protocols(httpProtocol)
    }
}

class AsyncSimulation extends ServiceSimulation {
    name="async"
	//netty
	url="http://34.239.109.181:8080"
}
class SyncSimulation extends ServiceSimulation {
    name="sync"
	//tomcat
	url="http://52.90.193.73:8080"
}

class Async500d1u extends AsyncSimulation {
    users=1
    delay=500
    repeatTimes=240
    startup()
}

class Async500d10u extends AsyncSimulation {
    users=10
    delay=500
    repeatTimes=240
    startup()
}

class Async500d100u extends AsyncSimulation {
    users=100
    delay=500
    repeatTimes=240
    startup()
}

class Async500d200u extends AsyncSimulation {
    users=200
    delay=500
    repeatTimes=240
    startup()
}

class Async500d500u extends AsyncSimulation {
    users=500
    delay=500
    repeatTimes=240
    startup()
}

class Async500d1000u extends AsyncSimulation {
    users=1000
    delay=500
    repeatTimes=240
    startup()
}

class Async500d2000u extends AsyncSimulation {
    users=2000
    delay=500
    repeatTimes=240
    startup()
}


//SYNC 500d
class Sync500d1u extends SyncSimulation {
    users=1
    delay=500
    repeatTimes=240
    startup()
}

class Sync500d10u extends SyncSimulation {
    users=10
    delay=500
    repeatTimes=240
    startup()
}

class Sync500d100u extends SyncSimulation {
    users=100
    delay=500
    repeatTimes=240
    startup()
}

class Sync500d200u extends SyncSimulation {
    users=200
    delay=500
    repeatTimes=240
    startup()
}

class Sync500d500u extends SyncSimulation {
    users=500
    delay=500
    repeatTimes=240
    startup()
}

class Sync500d1000u extends SyncSimulation {
    users=1000
    delay=500
    repeatTimes=240
    startup()
}

class Sync500d2000u extends SyncSimulation {
    users=2000
    delay=500
    repeatTimes=240
    startup()
}




// ASYNC 2000D
class Async2000d500u extends AsyncSimulation {
    users=500
    delay=2000
    repeatTimes=60
    startup()
}

class Async2000d1000u extends AsyncSimulation {
    users=1000
    delay=2000
    repeatTimes=60
    startup()
}

class Async2000d2000u extends AsyncSimulation {
    users=2000
    delay=2000
    repeatTimes=60
    startup()
}

// SYNC 2000D
class Sync2000d500u extends SyncSimulation {
    users=500
    delay=2000
    repeatTimes=60
    startup()
}

class Sync2000d1000u extends SyncSimulation {
    users=1000
    delay=2000
    repeatTimes=60
    startup()
}

class Sync2000d2000u extends SyncSimulation {
    users=2000
    delay=2000
    repeatTimes=60
    startup()
}

