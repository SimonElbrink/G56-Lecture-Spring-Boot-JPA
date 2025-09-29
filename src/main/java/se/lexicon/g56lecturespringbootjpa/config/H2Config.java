package se.lexicon.g56lecturespringbootjpa.config;

import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Configuration
public class H2Config {

    @Bean  (initMethod = "start", destroyMethod = "stop")
    public Server h2TcpServer() throws java.sql.SQLException {
        Server tcpServer = Server.createTcpServer(
                "-tcp", "-tcpAllowOthers", "-tcpPort", "9092"
        );
        log.info("H2 TCP Server started on port: {}", tcpServer.getPort());
        log.info("H2 TCP Server URL: {}", tcpServer.getURL());

        return tcpServer;
    }
}
