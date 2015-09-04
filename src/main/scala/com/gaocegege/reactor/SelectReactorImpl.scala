package com.gaocegege.reactor

import java.nio.channels.Selector
import com.gaocegege.multiplxer.SelectorMultiplxer
import com.gaocegege.handle.Handle
import com.gaocegege.handler.Handler
import scala.collection.mutable.HashMap
import scala.collection.Map
import scala.collection.Set
import scala.language.implicitConversions
import java.nio.channels.SelectionKey
import com.gaocegege.handler.SelectHandler
import scala.collection.JavaConversions
import java.nio.channels.SelectableChannel

/**
 * Reactor Implementation for select
 * @author gaocegege
 */
class SelectReactorImpl(_timeOut: Long) extends SelectReactor {

  val selectorMultiplxer: SelectorMultiplxer = new SelectorMultiplxer(Selector.open(), _timeOut)

  /**
   * register the handle function for a specific selectableChannel
   * use the register(), attach the callback function to the channel
   */
  @Override
  def registerHandler(socket: SelectableChannel, eventType: Int, callback: () => Unit) = {
    println("Register channel...")
    socket.configureBlocking(false)
    socket.register(selectorMultiplxer.getSelector, eventType, callback)
  }

  /** event loop */
  @Override
  def handleEvents = {
    println("reactor working...")
    while (true) {
      run
    }
  }

  /** IO multiplexer */
  def run() = {
    println("Waiting for select...")
    val selector = selectorMultiplxer.getSelector
    selector.select()
    val jKeys: java.util.Set[SelectionKey] = selector.selectedKeys
    val keys = JavaConversions.asScalaSet(jKeys).toList
    selector.selectedKeys.clear()
    //    keys.foreach { key => key.interestOps(0) }
    val callbacks = keys.map { key => key.attachment().asInstanceOf[Function0[Unit]] }
    callbacks.foreach(f => f())
  }
}
