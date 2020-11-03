import Dependencies._

name := "scalajs-sample"

lazy val commonSettings = Seq(
  organization := "jp.lanscopean",
  scalaVersion := "2.13.3",
  scalacOptions := Seq(
    "-deprecation",
    "-feature",
    "-Ywarn-dead-code",
    "-Xfatal-warnings",
    "-target:jvm-1.8"
  ),
  test in assembly := {}
)

val assemblySettings = Seq(
  assemblyMergeStrategy in assembly := {
    case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
    case _ => MergeStrategy.first
  },
  assemblyJarName in assembly := s"${name.value}.jar"
)

lazy val root = (project in file("."))
  .aggregate(
    presentation
  )
  .settings(commonSettings: _*)
  .settings(
    commonSettings,
    publishArtifact := false
  )
  .settings(
    commands += Command.command("assemblyAll") { state =>
      "presentation / assembly" ::
        state
    }
  )

lazy val presentation = (project in file("modules/adapter/presentation"))
  .settings(commonSettings: _*)
  .settings(assemblySettings: _*)
  .settings(
    libraryDependencies ++= lambdaDependencies
  )

lazy val main = (project in file("modules/adapter/presentation/main"))
  .settings(commonSettings: _*)
  .settings(assemblySettings: _*)
  .settings(
    libraryDependencies ++= lambdaDependencies
  )
