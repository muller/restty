@Grab('org.jboss.resteasy:resteasy-netty:2.3.4.Final')
class Grababbles { }

def deployment = new org.jboss.resteasy.spi.ResteasyDeployment(resources: [ new Restty() ])

new org.jboss.resteasy.plugins.server.netty.NettyJaxrsServer(port: 3000, deployment: deployment).start()

import javax.ws.rs.*
import javax.ws.rs.core.*

@Path('/hello')
class Restty {

  @GET
  String hello() {

    'Hello!!!\n'
  }
}
