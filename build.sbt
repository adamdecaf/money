organization := "com.decaf"

name := "money"

scalacOptions ++= Seq("-Xlog-implicits")

libraryDependencies ++= Seq(
  "org.joda" % "joda-convert" % "1.2",
  "joda-time" % "joda-time" % "2.2",
  "com.typesafe.akka" %% "akka-actor" % "2.2.3"
)
