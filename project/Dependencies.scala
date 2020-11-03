import sbt._

object Dependencies {
  lazy val awsLambda = "com.amazonaws" % "aws-java-sdk-lambda" % "1.11.890"
  lazy val awsLambdaJavaCore = "com.amazonaws" % "aws-lambda-java-core" % "1.2.1"
  lazy val myDynamoDBLibrary = "infradynamodb" % "infradynamodb_2.13" % "0.1.0-SNAPSHOT"
  lazy val lambdaDependencies = Seq(awsLambda, awsLambdaJavaCore, myDynamoDBLibrary)
}
