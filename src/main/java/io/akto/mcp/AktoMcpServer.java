package io.akto.mcp;

import io.akto.mcp.tools.AktoTools;
import io.akto.mcp.tools.ToolMetadata;
import io.modelcontextprotocol.server.McpSyncServerExchange;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.springframework.ai.mcp.McpToolUtils;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.ai.tool.StaticToolCallbackProvider;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.definition.DefaultToolDefinition;
import org.springframework.ai.tool.function.FunctionToolCallback;
import org.springframework.ai.tool.metadata.DefaultToolMetadata;
import org.springframework.ai.tool.method.MethodToolCallback;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.util.ReflectionUtils;

@SpringBootApplication
public class AktoMcpServer {

    public static void main(String[] args) {
        if (System.getenv("AKTO_API_KEY") == null || System.getenv("AKTO_API_KEY").isEmpty()) {
            throw new RuntimeException("AKTO_API_KEY not found in environment variable");
        }
        SpringApplication.run(AktoMcpServer.class, args);
    }

    @Bean
    public ToolCallbackProvider apiCollectionTools1(AktoTools aktoTools) {
        return MethodToolCallbackProvider.builder().toolObjects(aktoTools).build();
    }

    //@Bean
    public ToolCallbackProvider apiCollectionTools(AktoTools aktoTools) {
        List<FunctionToolCallback<Object, Object>> tools = new ArrayList<>();

        ToolMetadata.TOOL_METADATA.forEach((name, info) -> {
            FunctionToolCallback<Object, Object> callback = FunctionToolCallback.builder(name, (a, b) -> {
                    try {
                        Method method;
                        Object result;

                        try {
                            method = AktoTools.class.getMethod(name, Map.class);
                            result = method.invoke(aktoTools, a);
                        } catch (NoSuchMethodException e) {
                            method = AktoTools.class.getMethod(name);
                            result = method.invoke(aktoTools);
                        }

                        return result;
                    } catch (Exception ex) {
                        throw new RuntimeException("Error invoking method " + name, ex);
                    }
                })
                .description(info.getDescription())
                .inputSchema(info.getInputSchema())
                .inputType(new ParameterizedTypeReference<Map<String, Object>>() {})
                .toolMetadata(DefaultToolMetadata.builder().returnDirect(false).build())
                .build();

            tools.add(callback);
        });

        return new StaticToolCallbackProvider(tools);
    }
}
