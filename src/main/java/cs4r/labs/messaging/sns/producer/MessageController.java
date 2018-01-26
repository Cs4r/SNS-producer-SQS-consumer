package cs4r.labs.messaging.sns.producer;

import cs4r.labs.messaging.common.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private Producer producer;

    @PostMapping("/message")
    public ResponseEntity send(@RequestBody MessageDto message) throws Exception {

        producer.send(message);

        return ResponseEntity.ok().build();
    }

}