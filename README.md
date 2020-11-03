# scalajs-sample

### LambdaLayerでデプロイする場合

1. sbt clean;package
2. presentation_2.13-0.1.0-SNAPSHOT.jarをLambdaにアップロード
3. ハンドラに "App::handleRequest" を指定
