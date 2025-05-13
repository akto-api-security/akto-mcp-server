package io.akto.mcp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.akto.mcp.tools.AktoTools;
import io.modelcontextprotocol.server.transport.HttpServletSseServerTransportProvider;
import org.springframework.ai.tool.StaticToolCallbackProvider;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MCPServerConfig implements WebMvcConfigurer {
    @Bean
    public HttpServletSseServerTransportProvider servletSseServerTransportProvider() {
        return new HttpServletSseServerTransportProvider(new ObjectMapper(), "/mcp/message");
    }

    @Bean
    public ServletRegistrationBean customServletBean(HttpServletSseServerTransportProvider transportProvider) {
        return new ServletRegistrationBean(transportProvider);
    }

    @Bean
    public ToolCallbackProvider apiCollectionTools(AktoTools aktoTools) {
        return MethodToolCallbackProvider.builder().toolObjects(aktoTools).build();
    }
}
