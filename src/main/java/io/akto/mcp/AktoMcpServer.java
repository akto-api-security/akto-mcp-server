package io.akto.mcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class AktoMcpServer {

	public static void main(String[] args) {
		if(System.getenv("AKTO_API_KEY") == null || System.getenv("AKTO_API_KEY").isEmpty()) {
			throw new RuntimeException("AKTO_API_KEY not found in environment variable");
		}
		SpringApplication.run(AktoMcpServer.class, args);
	}
}
