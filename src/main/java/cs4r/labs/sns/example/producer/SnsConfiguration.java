package cs4r.labs.sns.example.producer;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.services.sns.model.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SnsConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(SnsConfiguration.class);

    @Bean
    public AmazonSNS ssnClient(SnsProperties snsProperties) {
        // Create Amazon SNS Client
        AWSCredentials awsCredentials =
                new BasicAWSCredentials(snsProperties.getAccessKey(), snsProperties.getSecretKey());

        AmazonSNS snsClient = AmazonSNSClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(snsProperties.getRegion())
                .build();

        // OPTIONAL: Check the topic already created or not
        ListTopicsResult listTopicsResult = snsClient.listTopics();
        List<Topic> topics = listTopicsResult.getTopics();

        boolean topicExists = topics.stream()
                .anyMatch(topic -> snsProperties.getTopicArn().equalsIgnoreCase(topic.getTopicArn()));

        // Create a new topic if it doesn't exist
        if (!topicExists) {
            createSNSTopic(snsClient, snsProperties.getTopicName());
        }
        return snsClient;
    }

    private CreateTopicResult createSNSTopic(AmazonSNS snsClient, String topicName) {

        CreateTopicRequest createTopic = new CreateTopicRequest(topicName);
        CreateTopicResult result = snsClient.createTopic(createTopic);
        LOGGER.info("Created topic request: " +
                snsClient.getCachedResponseMetadata(createTopic));
        return result;
    }
}