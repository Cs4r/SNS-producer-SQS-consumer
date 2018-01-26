package cs4r.labs.sns.example.producer;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "aws.sns")
public class SnsProperties {

    @NotBlank
    private String accessKey;
    @NotBlank
    private String secretKey;
    @NotBlank
    private String region;
    @NotBlank
    private String topicArn;
    @NotBlank
    private String topicName;

    public String getAccessKey() {

        return accessKey;
    }

    public String getSecretKey() {

        return secretKey;
    }

    public String getRegion() {

        return region;
    }

    public String getTopicArn() {

        return topicArn;
    }

    public String getTopicName() {

        return topicName;
    }

    public void setAccessKey(String accessKey) {

        this.accessKey = accessKey;
    }

    public void setSecretKey(String secretKey) {

        this.secretKey = secretKey;
    }

    public void setRegion(String region) {

        this.region = region;
    }

    public void setTopicArn(String topicArn) {

        this.topicArn = topicArn;
    }

    public void setTopicName(String topicName) {

        this.topicName = topicName;
    }
}
