package test

import com.gaocegege.handler.SelectHandler
import java.nio.channels.ServerSocketChannel
import java.net.InetSocketAddress
import java.net.InetAddress
import java.nio.channels.SelectableChannel
import com.gaocegege.reactor.SelectReactor
import java.nio.channels.SelectionKey

class ListenerHandler(reactor: SelectReactor, hostAddr: InetAddress, port: Int) extends SelectHandler {
  val serverChannel = ServerSocketChannel.open()
  serverChannel.configureBlocking(false);
  val isa = new InetSocketAddress(hostAddr, port)
  serverChannel.socket.bind(isa)

  @Override
  def getHandle: SelectableChannel = serverChannel

  reactor.registerHandler(serverChannel, SelectionKey.OP_ACCEPT, handleAccept)

  def handleAccept(): Unit = {
    println("Accept Connection")
    val requestHandler = new RequestHandler(reactor, serverChannel)
  }
}
