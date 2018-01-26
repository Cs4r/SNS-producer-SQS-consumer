package cs4r.labs.messaging.sqs.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

@Component
public class SqsErrorHandler implements ErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(SqsErrorHandler.class);

    @Override
    public void handleError(Throwable throwable) {

        LOGGER.error("Ooops! There has been an error processing the JMS message. Please pray again", throwable);
    }
}
