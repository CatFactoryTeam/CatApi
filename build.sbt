name := """CatRest"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .dependsOn(shelter)

lazy val shelter = RootProject(uri("git://github.com/CatFactoryTeam/CatShelter.git#master"))

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  ws
)

fork in run := true
