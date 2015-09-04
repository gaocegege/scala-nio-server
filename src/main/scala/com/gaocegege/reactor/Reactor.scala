package com.gaocegege.reactor

import com.gaocegege.handle.Handle
import com.gaocegege.handler.Handler

/**
 * Reactor class base, main class
 * @author gaocegege
 */
abstract class Reactor {
  /** event loop */
  def handleEvents
}
