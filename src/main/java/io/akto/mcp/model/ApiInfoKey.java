package io.akto.mcp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ai.tool.annotation.ToolParam;

@Data
@NoArgsConstructor
public class ApiInfoKey {

    private String method;
    private Integer apiCollectionId;
    private String url;
}
