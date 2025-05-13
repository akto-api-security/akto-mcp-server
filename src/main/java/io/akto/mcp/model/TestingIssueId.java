package io.akto.mcp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ai.tool.annotation.ToolParam;

@Data
@NoArgsConstructor
public class TestingIssueId {
    private String testSubCategory;
    private String testErrorSource;
    private String testCategoryFromSourceConfig;
    private String testSourceConfig;
    private ApiInfoKey apiInfoKey;

}
