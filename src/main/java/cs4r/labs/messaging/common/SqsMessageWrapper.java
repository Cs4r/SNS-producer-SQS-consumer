package cs4r.labs.messaging.common;

public class SqsMessageWrapper {

    private String Type;
    private String MessageId;
    private String TopicArn;
    private String Message;
    private String Timestamp;
    private String SignatureVersion;
    private String Signature;
    private String SigningCertURL;
    private String UnsubscribeURL;

    public String getType() {

        return Type;
    }

    public void setType(String type) {

        Type = type;
    }

    public String getMessageId() {

        return MessageId;
    }

    public void setMessageId(String messageId) {

        MessageId = messageId;
    }

    public String getTopicArn() {

        return TopicArn;
    }

    public void setTopicArn(String topicArn) {

        TopicArn = topicArn;
    }

    public String getMessage() {

        return Message;
    }

    public void setMessage(String message) {

        Message = message;
    }

    public String getTimestamp() {

        return Timestamp;
    }

    public void setTimestamp(String timestamp) {

        Timestamp = timestamp;
    }

    public String getSignatureVersion() {

        return SignatureVersion;
    }

    public void setSignatureVersion(String signatureVersion) {

        SignatureVersion = signatureVersion;
    }

    public String getSignature() {

        return Signature;
    }

    public void setSignature(String signature) {

        Signature = signature;
    }

    public String getSigningCertURL() {

        return SigningCertURL;
    }

    public void setSigningCertURL(String signingCertURL) {

        SigningCertURL = signingCertURL;
    }

    public String getUnsubscribeURL() {

        return UnsubscribeURL;
    }

    public void setUnsubscribeURL(String unsubscribeURL) {

        UnsubscribeURL = unsubscribeURL;
    }
}
