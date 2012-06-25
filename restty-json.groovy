@Grapes([
  @Grab('org.jboss.resteasy:resteasy-jackson-provider:2.3.4.Final'),
  @Grab('org.jboss.resteasy:resteasy-netty:2.3.4.Final'),
])
class Grababbles { }

def deployment = new org.jboss.resteasy.spi.ResteasyDeployment(resources: [ new ResttyJSON() ])

new org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer(port: 3000, deployment: deployment).start()

import javax.ws.rs.*
import javax.ws.rs.core.*

@Path('/hello-json')
@Produces(MediaType.APPLICATION_JSON)
class ResttyJSON {

  @GET
  Hello helloJSON() {

    new Hello(message: 'Hello!!!\n')
  }
}

class Hello {

  String message
}
