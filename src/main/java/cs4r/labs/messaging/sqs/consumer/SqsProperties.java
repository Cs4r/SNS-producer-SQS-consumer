package cs4r.labs.messaging.sqs.consumer;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "aws.sqs")
public class SqsProperties {

    @NotBlank
    private String accessKey;
    @NotBlank
    private String secretKey;
    @NotBlank
    private String region;
    @NotBlank
    private String destinationQueue;

    public String getAccessKey() {

        return accessKey;
    }

    public void setAccessKey(String accessKey) {

        this.accessKey = accessKey;
    }

    public String getSecretKey() {

        return secretKey;
    }

    public void setSecretKey(String secretKey) {

        this.secretKey = secretKey;
    }

    public String getRegion() {

        return region;
    }

    public void setRegion(String region) {

        this.region = region;
    }

    public String getDestinationQueue() {

        return destinationQueue;
    }

    public void setDestinationQueue(String destinationQueue) {

        this.destinationQueue = destinationQueue;
    }
}
