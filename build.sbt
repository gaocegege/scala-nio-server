lazy val root = (project in file(".")).
  settings(
    name := "typhoon",
    version := "1.0",
    scalaVersion := "2.11.6",
    libraryDependencies += "org.scala-lang" % "scala-compiler" % "2.11.6"
  )