package test

import com.gaocegege.handler.SelectHandler
import com.gaocegege.reactor.SelectReactor
import java.nio.channels.SelectableChannel
import java.nio.channels.ServerSocketChannel
import java.nio.channels.SelectionKey
import java.nio.ByteBuffer
import java.nio.channels.SocketChannel

/**
 * Connected Socket Handler
 * @author gaocegege
 */
class RequestHandler(reactor: SelectReactor, serverSocketChannel: ServerSocketChannel) extends SelectHandler {
  val socketChannel: SocketChannel = serverSocketChannel.accept
  socketChannel.configureBlocking(false);

  @Override
  def getHandle: SelectableChannel = socketChannel

  reactor.registerHandler(socketChannel, SelectionKey.OP_READ, handleRead)

  def handleRead(): Unit = {
    val buffer = ByteBuffer.allocate(256)
    socketChannel.read(buffer)
    val output = new String(buffer.array()).trim();
    println("Message read from client: " + output)
    if (output.equals("Bye.")) {
      socketChannel.close()
      println("Client messages are complete; close.")
    }
  }
}
