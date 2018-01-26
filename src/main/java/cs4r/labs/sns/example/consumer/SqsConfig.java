package cs4r.labs.sns.example.consumer;

import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.RegionUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.jms.support.destination.DynamicDestinationResolver;
import org.springframework.util.ErrorHandler;

import javax.jms.Session;

@Configuration
@EnableJms
public class SqsConfig {

    @Bean
    public SQSConnectionFactory sqsConnectionFactory(SqsProperties sqsProperties) {

        AWSCredentials awsCredentials =
                new BasicAWSCredentials(sqsProperties.getAccessKey(), sqsProperties.getSecretKey());

        return
                SQSConnectionFactory.builder()
                        .withRegion(RegionUtils.getRegion(sqsProperties.getRegion()))
                        .withAWSCredentialsProvider(new AWSStaticCredentialsProvider(awsCredentials))
                        .build();
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(SQSConnectionFactory connectionFactory,
                                                                          MessageConverter messageConverter,
                                                                          ErrorHandler errorHandler) {

        DefaultJmsListenerContainerFactory factory =
                new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setDestinationResolver(new DynamicDestinationResolver());
        factory.setConcurrency("1"); // Just one, for the shake of this example
        factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
        factory.setMessageConverter(messageConverter);
        factory.setErrorHandler(errorHandler);
        return factory;
    }

    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper) {

        MappingJackson2MessageConverter mappingJackson2MessageConverter = new MappingJackson2MessageConverter();

        mappingJackson2MessageConverter.setObjectMapper(objectMapper);
        mappingJackson2MessageConverter.setTargetType(MessageType.TEXT);
        mappingJackson2MessageConverter.setTypeIdPropertyName("_type");

//        Map<String, Class<?>> typeIdMappings = new HashMap<>();
//        typeIdMappings.put(MessageDto.class.getName(), MessageDto.class);
//        mappingJackson2MessageConverter.setTypeIdMappings(typeIdMappings);

        return mappingJackson2MessageConverter;
    }

}