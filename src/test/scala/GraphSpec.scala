package com.pongr.graph

import org.specs2.mutable._

class GraphSpec extends Specification {
  "The Graph factory" should {
    "create a graph using DirectedEdge & UndirectedEdge directly" in {
      val g = Graph(DirectedEdge("a", "b"), UndirectedEdge("a", "b"))
      g must not be null
      g.isInstanceOf[Graph[String]] must_== true
    }
    
    "create a graph using edge operators" in {
      import Implicits._
      val g = Graph("a" --> "b", "b" --- "c")
      g must not be null
      g.isInstanceOf[Graph[String]] must_== true
    }
  }
}