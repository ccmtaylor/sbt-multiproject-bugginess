import sbtrelease.ReleasePlugin.autoImport._
import ReleaseTransformations._

lazy val scala_211 = "2.11.7"
lazy val scala_210 = "2.10.6"

lazy val commonSettings = Seq(
  organization := "whatever",
  version := "0.0.1-SNAPSHOT",
  releaseCrossBuild := true,
  // minimal "release process", so that we don't affect the repo.
  releaseProcess := Seq(
    runTest,
    publishArtifacts 
  ),
  publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))
)

lazy val root = (project in file(".")).
  aggregate(ten, eleven, both).
  enablePlugins(CrossPerProjectPlugin).
  settings(commonSettings:_*).
  settings(name := "root",
           scalaVersion := scala_211,
           crossScalaVersions := Seq(scala_211, scala_210)
  )

lazy val both = project.
  settings(commonSettings:_*).
  settings(scalaVersion := scala_211,
           crossScalaVersions := Seq(scala_210, scala_211))

lazy val eleven = project.
  settings(commonSettings:_*).
  settings(scalaVersion := scala_211,
           crossScalaVersions := Seq(scala_211))

lazy val ten = project.
  settings(commonSettings:_*).
  settings(scalaVersion := scala_210,
           crossScalaVersions := Seq(scala_210))
