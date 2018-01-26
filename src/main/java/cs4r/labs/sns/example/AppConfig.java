package cs4r.labs.sns.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ObjectMapper objectMapper() {
        // Default object mapper, nothing fancy for now
        return new ObjectMapper();
    }
}
