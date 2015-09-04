package com.gaocegege.handler

import java.nio.channels.SelectionKey
import java.nio.channels.SocketChannel
import java.nio.channels.SelectableChannel

/**
 * SelectHandler
 * @author gaocegege
 */
@deprecated
abstract class SelectHandler extends Handler {

  def getHandle: SelectableChannel
}
