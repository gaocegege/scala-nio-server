package com.gaocegege.reactor

import com.gaocegege.handler.SelectHandler
import java.nio.channels.SelectableChannel

/**
 * Select Reactor class base
 * @author gaocegege
 */
abstract class SelectReactor extends Reactor {

  /** register the handler to the reactor */
  def registerHandler(socket: SelectableChannel, eventType: Int, callback: () => Unit)

  /** remove the handler to the reactor */
  // TODO find a way to remove handler
  //  def removeHandler(handle: SelectableChannel)
}
