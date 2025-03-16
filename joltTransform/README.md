# XML to JSON FLINK UDF

## Prerequisites
Setup initial maven development environment for build


## Steps to build
```bash
  git clone https://github.com/confluentinc/sts-reusable-assets.git
  cd sts-reusable-assets/flink/udf/XMLtoJSON/
  mvn clean install
```

## Confluent Cloud CLI Flink Steps
```bash
confluent flink artifact create xmljson --artifact-file  target/XMLtoJSON-1.0-SNAPSHOT.jar --cloud cloud-provider --region region-id --environment env-id
confluent flink --cloud cloud-provider --region region-id artifact list
confluent flink artifact describe xmljson --cloud cloud-provider --region region-id 
```

## Confluent Cloud Flink Compute Pool SQL Steps
```bash
CREATE FUNCTION XML_TO_JSON
  AS 'io.confluent.flink.table.modules.remoteudf.XMLtoJSON'
  USING JAR 'confluent-artifact://artifact-id/version-id';

SHOW USER FUNCTIONS;

select XML_TO_JSON('<?xml version="1.0" ?><root><test attribute="text1">flinkudf</test><test attribute="text2">UDF</test></root>') as JS;

```

