organization := "com.pongr"

name := "graph-literal-example"

version := "1.0"

scalaVersion := "2.9.0-1"

 libraryDependencies ++= Seq(
    "org.specs2" %% "specs2" % "1.5" % "test",
    "org.specs2" %% "specs2-scalaz-core" % "6.0.RC2" % "test"
  )

  resolvers ++= Seq("snapshots" at "http://scala-tools.org/repo-snapshots")

