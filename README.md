# spring-function-azure

## Create an application.properties file

```
$> touch ./src/main/resources/application.properties
```

### Contents of application properties

```
azure.cosmosdb.uri=
azure.cosmosdb.key=
azure.cosmosdb.secondaryKey=
azure.cosmosdb.database=
org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.example.demo.configuration

```

## Create a local.settings.json

```
$> touch ./src/main/azure/local.settings.json
```

### Contents of local settings

```
{
  "IsEncrypted": false,
  "Values": {
    "AzureWebJobsStorage": "",
    "FUNCTIONS_WORKER_RUNTIME": "java",
    "AzureWebJobsDashboard": "",
    "MAIN_CLASS": "com.example.demo.DemoApplication",
    "azure.cosmosdb.uri": "",
    "azure.cosmosdb.key": "",
    "azure.cosmosdb.secondaryKey": "",
    "azure.cosmosdb.database": "",
    "org.springframework.boot.autoconfigure.EnableAutoConfiguration": "com.example.demo.configuration"
  }
}
```
