import java.net.URI

import common.layer.DynamoDBWrapper
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient

object Main extends App with DynamoDBWrapper {
  override val dynamoDBClient = DynamoDbClient
    .builder()
    .region(Region.AP_NORTHEAST_1)
    .endpointOverride(new URI("http://localhost:4569"))
    .build()
  print(listAllTables)
}
