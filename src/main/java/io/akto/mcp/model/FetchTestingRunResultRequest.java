package io.akto.mcp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FetchTestingRunResultRequest {

    private TestingIssueId issueId;
}
