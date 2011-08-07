package com.pongr.graph

trait Graph[N] {
  def nodes: Set[N]
  def out(n: N): Set[N]
  def in(n: N): Set[N]
  def undirected(n: N): Set[N]
  
  def +(n: N)
  def -(n: N)
  def +(edge: Edge[N])
  def -(edge: Edge[N])
}

class GraphImpl[N](edges: Edge[N]*) extends Graph[N] {
  def nodes: Set[N] = Set()
  def out(n: N): Set[N] = Set()
  def in(n: N): Set[N] = Set()
  def undirected(n: N): Set[N] = Set()
  
  def +(n: N) {}
  def -(n: N) {}
  def +(edge: Edge[N]) {}
  def -(edge: Edge[N]) {}
}

sealed trait Edge[N]
case class DirectedEdge[N](n1: N, n2: N) extends Edge[N]
case class UndirectedEdge[N](n1: N, n2: N) extends Edge[N]

//TODO replace this with com.pongr.graph package object?  so users just import com.pongr.graph._
object Implicits {
  final class DirectedAssoc[N](val n1: N) {
    @inline def -->(n2: N): DirectedEdge[N] = DirectedEdge(n1, n2)
  }
  implicit def any2DirectedAssoc[N](n1: N): DirectedAssoc[N] = new DirectedAssoc(n1)
  
  final class UndirectedAssoc[N](val n1: N) {
    @inline def ---(n2: N): UndirectedEdge[N] = UndirectedEdge(n1, n2)
  }
  implicit def any2UndirectedAssoc[N](n1: N): UndirectedAssoc[N] = new UndirectedAssoc(n1)
}

object Graph {
  def apply[N](edges: Edge[N]*): Graph[N] = new GraphImpl(edges: _*)
}
