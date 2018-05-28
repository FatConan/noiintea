name := """noiintea"""
organization := "de.themonstrouscavalca"
version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

resolvers += "Aspose Releases" at "http://maven.aspose.com/repository/ext-release-local/"
resolvers += "Atlassian Releases" at "https://maven.atlassian.com/public/"
resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
resolvers += "Local Maven" at Path.userHome.asFile.toURI.toURL + ".m2/repository"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  guice,
  "de.themonstrouscavalca" % "dbaser" % "2018.04.30.a1",
  "de.themonstrouscavalca" % "formicaside" % "2018.05.28.1"
)

