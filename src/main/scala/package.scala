package com.pongr
package object graph {
  //can't get these to work :(
  implicit val any2DirectedAssocFwd = Implicits.any2DirectedAssoc _
  implicit val any2UnirectedAssocFwd = Implicits.any2UndirectedAssoc _
}