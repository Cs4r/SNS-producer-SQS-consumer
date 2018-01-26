package cs4r.labs.messaging.sqs.consumer;

import cs4r.labs.messaging.common.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;

@Service
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = "${aws.sqs.destinationQueue}")
    public void onReceive(Message<MessageDto> receivedMsg) throws JMSException {

        LOGGER.info("Message received. Payload: {}, headers: {}", receivedMsg.getPayload(), receivedMsg.getHeaders());
    }
}
