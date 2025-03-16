# json transformation using JOLT FLINK UDF

## Prerequisites
Setup initial maven development environment for build


## Steps to build
```bash
  cd joltTransform/
  mvn clean install
```

## Confluent Cloud CLI Flink Steps
```bash
confluent flink artifact create joltTransform --artifact-file  target/jsonJoltTransform-1.0-SNAPSHOT.jar --cloud cloud-provider --region region-id --environment env-id
confluent flink --cloud cloud-provider --region region-id artifact list
confluent flink artifact describe joltTransform --cloud cloud-provider --region region-id 
```

## Confluent Cloud Flink Compute Pool SQL Steps
```bash
CREATE FUNCTION JoltTransform
  AS 'io.confluent.flink.table.modules.remoteudf.jsonJoltTransform'
  USING JAR 'confluent-artifact://artifact-id/version-id';

SHOW USER FUNCTIONS;

select JoltTransform('{
    "rating": {
        "primary": {
            "value": 3
        },
        "quality": {
            "value": 3
        }
    }
}') as ss;

```

