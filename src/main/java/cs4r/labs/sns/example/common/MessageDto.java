package cs4r.labs.sns.example.common;

import java.io.Serializable;

public class MessageDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    @Override
    public String toString() {

        return "MessageDto{" +
                "message='" + message + '\'' +
                '}';
    }
}
