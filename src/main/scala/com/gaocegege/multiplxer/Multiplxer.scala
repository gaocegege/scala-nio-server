package com.gaocegege.multiplxer

/**
 * IO multiplxer, such as select, poll, epoll, kqueue
 * @author gaocegege
 */
abstract class Multiplxer {

  def ioPoll: Int
}
