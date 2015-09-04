package test

import java.net.InetAddress
import com.gaocegege.reactor.SelectReactor
import com.gaocegege.reactor.SelectReactorImpl

object Server {
  def main(args: Array[String]) {
    val reactor: SelectReactor = new SelectReactorImpl(0)
    val hostAddr: InetAddress = null //listen on local connection
    val port = 1237
    val listener = new ListenerHandler(reactor, hostAddr, port)
    reactor.handleEvents
  }
}
