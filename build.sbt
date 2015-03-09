name := """CatApi"""

version := "1.0.0"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .dependsOn(shelter)

lazy val shelter = RootProject(uri("git://github.com/CatFactoryTeam/CatShelter.git#master"))

scalaVersion := "2.11.5"

libraryDependencies ++= Seq(
  cache,
  ws
)

fork in run := true
