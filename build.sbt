name := "saddle"

scalaVersion := "2.9.3"

version :="0.1.0"

resolvers ++= Seq(
  "Akka Repository" at "http://repo.akka.io/releases/")

libraryDependencies += "com.typesafe.akka" % "akka-actor" % "2.0"