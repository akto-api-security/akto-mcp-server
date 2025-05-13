package io.akto.mcp;

import io.akto.mcp.tools.AktoTools;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AktoMcpServer {

	public static void main(String[] args) {
		if(System.getenv("AKTO_API_KEY") == null || System.getenv("AKTO_API_KEY").isEmpty()) {
			throw new RuntimeException("AKTO_API_KEY not found in environment variable");
		}
		SpringApplication.run(AktoMcpServer.class, args);
	}

	@Bean
	public ToolCallbackProvider apiCollectionTools(AktoTools aktoTools) {
		return MethodToolCallbackProvider.builder().toolObjects(aktoTools).build();
	}
}
