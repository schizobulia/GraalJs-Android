# Polyglot Embedding Demo with GraalVM for JDK 21 
Demonstration repository showing polyglot embedding with GraalVM JDK 21 using Maven and Gradle.
It contains a simple Main and Test class to bootstrap a polyglot embedding project.

For more details on polyglot embedding please see the docs:
https://www.graalvm.org/latest/reference-manual/embed-languages/

## Setup

[Download](https://www.graalvm.org/downloads/) GraalVM and point the `JAVA_HOME` environment variable to it.

## Maven Usage

Download Maven or import as Maven project into your IDE.

* `mvn package` build using javac
* `mvn test` to run the tests
* `mvn exec:exec` to run the Main application
* `mvn -Pnative package` to build a native-image

Please see the [pom.xml](./pom.xml) file for further details on the configuration.

## Gradle Usage

Download Gradle or import as Maven project into your IDE.

* `gradle build` build using javac
* `gradle run` to run the Main application
* `gradle test` to run the tests
* `gradle nativeCompile` to build a native-image 
* `gradle nativeRun` to run the native image
  
Please see the [build.gradle.kts](./build.gradle.kts) file for further details on the configuration.