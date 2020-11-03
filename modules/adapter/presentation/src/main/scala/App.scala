import com.amazonaws.services.lambda.runtime.{Context, RequestHandler}
import common.layer.{DynamoDBWrapper}
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient

import scala.util.{Failure, Success}

class App extends RequestHandler[Object, Unit] with DynamoDBWrapper {
  override protected val dynamoDBClient: DynamoDbClient = DynamoDbClient
    .builder()
    .region(Region.AP_NORTHEAST_1)
    .build()
  override def handleRequest(input: Object, context: Context): Unit = {
    println(listAllTables)
  }
}
