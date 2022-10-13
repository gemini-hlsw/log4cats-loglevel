Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / crossScalaVersions := List("3.2.0")
ThisBuild / tlBaseVersion      := "0.4"

lazy val root = project
  .in(file("."))
  .settings(
    name    := "log4cats-loglevel",
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats-effect"   % "3.3.14",
      "org.typelevel" %%% "log4cats-core" % "2.5.0"
    ),
    useYarn := true,
    Compile / npmDependencies ++= Seq(
      "loglevel" -> "1.7.1"
    )
  )
  .enablePlugins(ScalaJSBundlerPlugin)
