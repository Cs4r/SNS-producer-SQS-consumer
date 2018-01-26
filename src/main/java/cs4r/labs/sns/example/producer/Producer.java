package cs4r.labs.sns.example.producer;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs4r.labs.sns.example.common.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Producer {

    @Autowired
    private AmazonSNS snsClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${aws.sns.topicArn}")
    private String topicArn;

    public void send(MessageDto message) throws Exception {

        // When sending the message to Amazon SNS it's very important to state the object type
        // so that it is possible to deserialize (unmarshall) in the other end
        String className = message.getClass().getName();

        MessageAttributeValue objectType = new MessageAttributeValue()
                .withDataType("String")
                .withStringValue(className);

        // The extra attribute '_type' will be mapped to a JMS header when the message reaches its corresponding SQS queue
        Map<String, MessageAttributeValue> attributes = new HashMap<>();
        attributes.put("_type", objectType);

        PublishRequest publishRequest = new PublishRequest()
                .withMessageAttributes(attributes)
                .withTopicArn(topicArn)
                .withMessage(objectMapper.writeValueAsString(message));

        snsClient.publish(publishRequest);
    }
}
