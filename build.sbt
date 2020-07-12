Global / onChangedBuildSource := ReloadOnSourceChanges

inThisBuild(
  List(
    name := "log4cats-loglevel",
    organization := "com.rpiaggio",
    scalaVersion := "2.13.2",
    crossScalaVersions := Seq("2.12.11", scalaVersion.value),
    homepage := Some(url("https://github.com/rpiaggio/log4cats-loglevel")),
    licenses += ("BSD 3-Clause", url(
      "http://opensource.org/licenses/BSD-3-Clause"
    )),
    developers := List(
      Developer(
        "rpiaggio",
        "Raúl Piaggio",
        "rpiaggio@gmail.com",
        url("http://github.com/rpiaggio")
      )
    )
  )
)

lazy val root = project
  .in(file("."))
  .settings(
    name := "log4cats-loglevel",
    moduleName := "log4cats-loglevel",
    libraryDependencies ++= Seq(
      "org.typelevel"     %%% "cats-effect"   % "2.1.4",
      "io.chrisdavenport" %%% "log4cats-core" % "1.1.1"
    ),
    useYarn := true,
    npmDependencies in Compile ++= Seq(
      "loglevel" -> "1.6.8"
    ),
    scmInfo := Some(
      ScmInfo(
        url("https://github.com/rpiaggio/log4cats-loglevel"),
        "scm:git:git@github.com:rpiaggio/log4cats-loglevel.git",
        Some("scm:git:git@github.com:rpiaggio/log4cats-loglevel.git")
      )
    ),
    pomIncludeRepository := { _ => false }
  )
  .enablePlugins(ScalaJSBundlerPlugin /*ScalaJSPlugin , ScalablyTypedConverterPlugin*/ )

sonatypeProfileName := "com.rpiaggio"
