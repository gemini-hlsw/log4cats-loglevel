Global / onChangedBuildSource := ReloadOnSourceChanges

ThisBuild / crossScalaVersions := List("3.2.0")
ThisBuild / tlBaseVersion      := "0.4"

ThisBuild / tlCiReleaseBranches := Seq("master")

lazy val root = project
  .in(file("."))
  .settings(
    name    := "log4cats-loglevel",
    scalacOptions += "-language:implicitConversions",
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "cats-effect"   % "3.4.7",
      "org.typelevel" %%% "log4cats-core" % "2.5.0"
    ),
    useYarn := true,
    Compile / npmDependencies ++= Seq(
      "loglevel" -> "1.7.1"
    )
  )
  .enablePlugins(ScalaJSBundlerPlugin)
