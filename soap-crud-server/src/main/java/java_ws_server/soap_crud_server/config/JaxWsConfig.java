package java_ws_server.soap_crud_server.config;

import jakarta.xml.ws.Endpoint;
import java_ws_server.soap_crud_server.endpoint.UserEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JaxWsConfig {
    private final UserEndpoint userEndpoint;

    public JaxWsConfig(UserEndpoint endpoint) {
        this.userEndpoint = endpoint;
    }

    @Bean
    public Endpoint userServiceEndpoint(){
        return Endpoint.publish("http://localhost:8081/ws/users", userEndpoint);
    }
}
