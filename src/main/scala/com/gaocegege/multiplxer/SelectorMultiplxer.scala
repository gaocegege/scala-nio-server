package com.gaocegege.multiplxer

import java.nio.channels.Selector

class SelectorMultiplxer(_selector: Selector, _timeOut: Long) extends Multiplxer {
  var selector: Selector = _selector
  var timeOut: Long = _timeOut

  def getSelector: Selector = selector

  @Override
  def ioPoll: Int = {
    return selector.select(timeOut)
  }
}
