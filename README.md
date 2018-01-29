# SNS-producer-SQS-consumer

Spring Boot application that sends messages to an Amazon SNS topic and consumes those messages from an Amazon SQS queue.

## Checking out and building

To check out the project and build it from source, do the following:

```
git clone https://github.com/Cs4r/SNS-producer-SQS-consumer.git
cd SNS-producer-SQS-consumer
./gradlew build
```

## Application properties

Before running the project, please ensure that you fill in the missing property values in the appplication.properties file.

```
aws.sns.accessKey=<put-here-your-access-key>
aws.sns.secretKey=<put-here-your-secret-key>
aws.sns.region=eu-west-1
aws.sns.topicArn=<put-here-your-topic-arn>
aws.sns.topicName=echo-topic

aws.sqs.accessKey=<put-here-your-access-key>
aws.sqs.secretKey=<put-here-your-secret-key>
aws.sqs.region=eu-west-1
aws.sqs.destinationQueue=echo
```

## Running 

In order to run the project please execute the following command under project folder.

```
./gradlew run
```

## Acknowledgements

If this repo is useful for you, please fav it and follow me.
