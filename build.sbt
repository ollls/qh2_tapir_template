ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "3.3.3"

Runtime / unmanagedClasspath += baseDirectory.value / "src" / "main" / "resources"

assembly / assemblyMergeStrategy := {
  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
  case _                                   => MergeStrategy.first
}

assembly / assemblyJarName := "qh2-http-run.jar"

lazy val root = (project in file(".")).settings(
  name := "json-template-qh2",
  libraryDependencies ++= Seq(
    "io.github.ollls" %% "quartz-h2" % "0.8.1",
    "io.github.ollls" %% "tapir-quartz-h2" % "0.8.1",
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core" % "2.19.1",
    "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % "2.19.1" % "compile-internal",
    "com.softwaremill.sttp.tapir" %% "tapir-jsoniter-scala" % "1.10.5"
  )
)

scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-Wunused:all"
)