package io.akto.mcp.tools;

import java.util.Map;

public class ToolMetadata {
    public static final Map<String, ToolInfo> TOOL_METADATA = Map.ofEntries(
        Map.entry("getApiCollections", new ToolInfo(
            "getApiCollections",
            "Retrieves basic information about all API collections in the system.",
            """
            {
                "type": "object",
                "description": "No input parameters required"
            }
            """
        )),
        Map.entry("getAllCollections", new ToolInfo(
            "getAllCollections",
            "Retrieves detailed information about all API collections in the system.",
            """
            {
                "type": "object",
                "description": "No input parameters required"
            }
            """
        )),
        Map.entry("getCollection", new ToolInfo(
            "getCollection",
            "Retrieves detailed information about a specific API collection.",
            """
            {
                "type": "object",
                "properties": {
                    "apiCollectionId": {
                        "type": "integer",
                        "description": "ID of the API collection to retrieve",
                        "example": 1111111111
                    }
                },
                "required": ["apiCollectionId"]
            }
            """
        )),
        Map.entry("fetchAllIssues", new ToolInfo(
            "fetchAllIssues",
            "Retrieves all issues with filtering and sorting capabilities. Allows filtering by status, time range, and sorting by various fields.",
            """
            {
                "type": "object",
                "properties": {
                    "activeCollections": {
                        "type": "boolean",
                        "description": "Filter for active collections. true for active, false for inactive"
                    },
                    "sortKey": {
                        "type": "string",
                        "description": "Field to sort results by"
                    },
                    "sortOrder": {
                        "type": "integer",
                        "description": "Sort order (-1 for descending, 1 for ascending)"
                    },
                    "limit": {
                        "type": "integer",
                        "title": "Limit",
                        "description": "Maximum number of results (1-50). Used for pagination to control the number of records returned per request.",
                        "default": 10,
                        "minimum": 1
                    },
                    "endTimeStamp": {
                        "type": "integer",
                        "description": "End timestamp for filtering"
                    },
                    "filterStatus": {
                        "type": "array",
                        "description": "Array of statuses to filter by"
                    },
                    "skip": {
                        "type": "integer",
                        "title": "Skip",
                        "description": "Number of records to skip (offset) for pagination. For example: if limit=50, use skip=0 for first page, skip=50 for second page, skip=100 for third page, etc.",
                        "default": 0,
                        "minimum": 0
                    },
                    "startEpoch": {
                        "type": "integer",
                        "description": "Start timestamp for filtering"
                    }
                },
                "required": ["limit", "endTimeStamp", "skip"]
            }
            """
        )),
        Map.entry("fetchApiDependencies", new ToolInfo(
            "fetchApiDependencies",
            "Fetches API dependencies and relationships for a specific endpoint. Useful for understanding API connections, impact analysis, and security testing.",
            """
            {
                "type": "object",
                "properties": {
                    "method": {
                        "type": "string",
                        "description": "HTTP method of the endpoint",
                        "example": "GET"
                    },
                    "apiCollectionId": {
                        "type": "integer",
                        "description": "ID of the API collection",
                        "example": 1111111111
                    },
                    "url": {
                        "type": "string",
                        "description": "URL of the endpoint",
                        "example": "https://vulnerable-server.akto.io/api/college/dashboard/home"
                    }
                },
                "required": ["method", "apiCollectionId", "url"]
            }
            """
        )),
        Map.entry("fetchNewEndpointsTrend", new ToolInfo(
            "fetchNewEndpointsTrend",
            "Retrieves trend data for new endpoints over a specified time period.",
            """
            {
                "type": "object",
                "properties": {
                    "endTimestamp": {
                        "type": "integer",
                        "description": "End timestamp for the trend period",
                        "example": 1747074599
                    },
                    "startTimestamp": {
                        "type": "integer",
                        "description": "Start timestamp for the trend period",
                        "example": 1741804200
                    }
                },
                "required": ["endTimestamp", "startTimestamp"]
            }
            """
        )),
        Map.entry("fetchTestCoverageData", new ToolInfo(
            "fetchTestCoverageData",
            "Retrieves test coverage data for API collections over a specified time period.",
            """
            {
                "type": "object",
                "properties": {
                    "startTimeStamp": {
                        "type": "integer",
                        "description": "Start timestamp for the coverage period",
                        "example": 0
                    },
                    "endTimeStamp": {
                        "type": "integer",
                        "description": "End timestamp for the coverage period",
                        "example": 1778571718
                    }
                },
                "required": ["startTimeStamp", "endTimeStamp"]
            }
            """
        )),
        Map.entry("fetchCriticalIssuesTrend", new ToolInfo(
            "fetchCriticalIssuesTrend",
            "Retrieves trend data for critical issues over a specified time period.",
            """
            {
                "type": "object",
                "properties": {
                    "startTimeStamp": {
                        "type": "integer",
                        "description": "Start timestamp for the trend period",
                        "example": 0
                    },
                    "endTimeStamp": {
                        "type": "integer",
                        "description": "End timestamp for the trend period",
                        "example": 1778571714
                    }
                },
                "required": ["startTimeStamp", "endTimeStamp"]
            }
            """
        )),
        Map.entry("fetchApiStats", new ToolInfo(
            "fetchApiStats",
            "Retrieves API statistics over a specified time period.",
            """
            {
                "type": "object",
                "properties": {
                    "startTimeStamp": {
                        "type": "integer",
                        "description": "Start timestamp for the stats period",
                        "example": 0
                    },
                    "endTimeStamp": {
                        "type": "integer",
                        "description": "End timestamp for the stats period",
                        "example": 1778571718
                    }
                },
                "required": ["startTimeStamp", "endTimeStamp"]
            }
            """
        )),
        Map.entry("fetchEndpointsCount", new ToolInfo(
            "fetchEndpointsCount",
            "Retrieves the count of endpoints over a specified time period.",
            """
            {
                "type": "object",
                "properties": {
                    "endTimestamp": {
                        "type": "integer",
                        "description": "End timestamp for the count period",
                        "example": 0
                    },
                    "startTimestamp": {
                        "type": "integer",
                        "description": "Start timestamp for the count period",
                        "example": 0
                    }
                },
                "required": ["endTimestamp", "startTimestamp"]
            }
            """
        )),
        Map.entry("fetchSubTypeCountMap", new ToolInfo(
            "fetchSubTypeCountMap",
            "Retrieves a count map of subtypes for endpoints over a specified time period.",
            """
            {
                "type": "object",
                "properties": {
                    "endTimestamp": {
                        "type": "integer",
                        "description": "End timestamp for the count period",
                        "example": 1747032698
                    },
                    "startTimestamp": {
                        "type": "integer",
                        "description": "Start timestamp for the count period",
                        "example": 0
                    }
                },
                "required": ["endTimestamp", "startTimestamp"]
            }
            """
        )),
        Map.entry("getAllUsersCollections", new ToolInfo(
            "getAllUsersCollections",
            "Retrieves all user collections in the system.",
            """
            {
                "type": "object",
                "description": "No input parameters required"
            }
            """
        )),
        Map.entry("getAllTestsCountMap", new ToolInfo(
            "getAllTestsCountMap",
            "Retrieves a count map of all tests over a specified time period.",
            """
            {
                "type": "object",
                "properties": {
                    "endTimestamp": {
                        "type": "integer",
                        "description": "End timestamp for the count period",
                        "example": 1778658008
                    },
                    "startTimestamp": {
                        "type": "integer",
                        "description": "Start timestamp for the count period",
                        "example": 0
                    }
                },
                "required": ["endTimestamp", "startTimestamp"]
            }
            """
        )),
        Map.entry("fetchNewEndpointsTrendForNonHostCollections", new ToolInfo(
            "fetchNewEndpointsTrendForNonHostCollections",
            "Retrieves trend data for new endpoints in non-host collections over a specified time period.",
            """
            {
                "type": "object",
                "properties": {
                    "endTimestamp": {
                        "type": "integer",
                        "description": "End timestamp for the trend period",
                        "example": 1747074599
                    },
                    "startTimestamp": {
                        "type": "integer",
                        "description": "Start timestamp for the trend period",
                        "example": 1741804200
                    }
                },
                "required": ["endTimestamp", "startTimestamp"]
            }
            """
        )),
        Map.entry("fetchIntegration", new ToolInfo(
            "fetchIntegration",
            "Retrieves integration information for the system.",
            """
            {
                "type": "object",
                "description": "No input parameters required"
            }
            """
        )),
        Map.entry("fetchCodeAnalysisApiInfos", new ToolInfo(
            "fetchCodeAnalysisApiInfos",
            "Retrieves code analysis information for APIs in a specific collection.",
            """
            {
                "type": "object",
                "properties": {
                    "apiCollectionId": {
                        "type": "integer",
                        "description": "ID of the API collection",
                        "example": 1747033350
                    }
                },
                "required": ["apiCollectionId"]
            }
            """
        )),
        Map.entry("fetchTestRunResultsCount", new ToolInfo(
            "fetchTestRunResultsCount",
            "Retrieves the count of test run results for a specific testing run.",
            """
            {
                "type": "object",
                "properties": {
                    "testingRunResultSummaryHexId": {
                        "type": "string",
                        "description": "Hex ID of the testing run result summary",
                        "example": "6821a176992b895372dc1c0d"
                    }
                },
                "required": ["testingRunResultSummaryHexId"]
            }
            """
        )),
        Map.entry("getLastSeenTrafficInfoForCollections", new ToolInfo(
            "getLastSeenTrafficInfoForCollections",
            "Retrieves the last seen traffic information for all collections.",
            """
            {
                "type": "object",
                "description": "No input parameters required"
            }
            """
        )),
        Map.entry("fetchAffectedEndpoints", new ToolInfo(
            "fetchAffectedEndpoints",
            "Retrieves endpoints affected by a specific issue.",
            """
            {
                "type": "object",
                "properties": {
                    "issueId": {
                        "type": "object",
                        "properties": {
                            "testSubCategory": {
                                "type": "string",
                                "description": "Test subcategory of the issue",
                                "example": "JWT_HEADER_PARAM_INJECTION_KID"
                            },
                            "testErrorSource": {
                                "type": "string",
                                "description": "Source of the test error",
                                "example": "AUTOMATED_TESTING"
                            },
                            "testCategoryFromSourceConfig": {
                                "type": "string",
                                "description": "Test category from source config",
                                "example": null
                            },
                            "apiInfoKey": {
                                "type": "object",
                                "properties": {
                                    "method": {
                                        "type": "string",
                                        "description": "HTTP method",
                                        "example": "GET"
                                    },
                                    "apiCollectionId": {
                                        "type": "integer",
                                        "description": "ID of the API collection",
                                        "example": 1111111111
                                    },
                                    "url": {
                                        "type": "string",
                                        "description": "URL of the endpoint",
                                        "example": "https://vulnerable-server.akto.io/api/college/student-details"
                                    }
                                },
                                "required": ["method", "apiCollectionId", "url"]
                            },
                            "testSourceConfig": {
                                "type": "string",
                                "description": "Test source configuration",
                                "example": null
                            }
                        },
                        "required": ["testSubCategory", "testErrorSource", "apiInfoKey"]
                    }
                },
                "required": ["issueId"]
            }
            """
        )),
        Map.entry("findTotalIssues", new ToolInfo(
            "findTotalIssues",
            "Retrieves the total number of issues within a specified time period.",
            """
            {
                "type": "object",
                "properties": {
                    "startTimeStamp": {
                        "type": "integer",
                        "description": "Start timestamp for the period",
                        "example": 1746946142
                    },
                    "endTimeStamp": {
                        "type": "integer",
                        "description": "End timestamp for the period",
                        "example": 1747032542
                    }
                },
                "required": ["startTimeStamp", "endTimeStamp"]
            }
            """
        )),
        Map.entry("getSensitiveInfoForCollections", new ToolInfo(
            "getSensitiveInfoForCollections",
            "Retrieves sensitive information for all collections.",
            """
            {
                "type": "object",
                "description": "No input parameters required"
            }
            """
        )),
        Map.entry("getRiskScoreInfo", new ToolInfo(
            "getRiskScoreInfo",
            "Retrieves risk score information for the system.",
            """
            {
                "type": "object",
                "description": "No input parameters required"
            }
            """
        )),
        Map.entry("getIssueSummaryInfo", new ToolInfo(
            "getIssueSummaryInfo",
            "Retrieves summary information about issues within a specified time period.",
            """
            {
                "type": "object",
                "properties": {
                    "endTimestamp": {
                        "type": "integer",
                        "description": "End timestamp for the summary period",
                        "example": 1778658008
                    },
                    "startTimestamp": {
                        "type": "integer",
                        "description": "Start timestamp for the summary period",
                        "example": 0
                    }
                },
                "required": ["endTimestamp", "startTimestamp"]
            }
            """
        )),
        Map.entry("fetchTestingRunResultSummaries", new ToolInfo(
            "fetchTestingRunResultSummaries",
            "Retrieves summaries of testing run results for a specific testing run.",
            """
            {
                "type": "object",
                "properties": {
                    "testingRunHexId": {
                        "type": "string",
                        "description": "Hex ID of the testing run",
                        "example": "6821a172934b8e3c4f933658"
                    },
                    "endTimestamp": {
                        "type": "integer",
                        "description": "End timestamp for the results period",
                        "example": 0
                    },
                    "startTimestamp": {
                        "type": "integer",
                        "description": "Start timestamp for the results period",
                        "example": 0
                    }
                },
                "required": ["testingRunHexId", "endTimestamp", "startTimestamp"]
            }
            """
        )),
        Map.entry("checkIfDependencyGraphAvailable", new ToolInfo(
            "checkIfDependencyGraphAvailable",
            "Checks if a dependency graph is available for a specific endpoint.",
            """
            {
                "type": "object",
                "properties": {
                    "method": {
                        "type": "string",
                        "description": "HTTP method of the endpoint",
                        "example": "GET"
                    },
                    "apiCollectionId": {
                        "type": "integer",
                        "description": "ID of the API collection",
                        "example": 1744008475
                    },
                    "url": {
                        "type": "string",
                        "description": "URL of the endpoint",
                        "example": "https://juiceshop.akto.io/rest/user/whoami"
                    }
                },
                "required": ["method", "apiCollectionId", "url"]
            }
            """
        )),
        Map.entry("getCoverageInfoForCollections", new ToolInfo(
            "getCoverageInfoForCollections",
            "Retrieves coverage information for all collections.",
            """
            {
                "type": "object",
                "description": "No input parameters required"
            }
            """
        )),
        Map.entry("retrieveAllCollectionTests", new ToolInfo(
            "retrieveAllCollectionTests",
            "Retrieves all collection tests with filtering and sorting capabilities.",
            """
            {
                "type": "object",
                "properties": {
                    "searchString": {
                        "type": "string",
                        "description": "Search string to filter tests"
                    },
                    "sortKey": {
                        "type": "string",
                        "description": "Field to sort results by",
                        "example": "scheduleTimestamp"
                    },
                    "sortOrder": {
                        "type": "integer",
                        "description": "Sort order (-1 for descending, 1 for ascending)",
                        "example": -1
                    },
                    "limit": {
                        "type": "integer",
                        "description": "Maximum number of results",
                        "example": 50
                    },
                    "skip": {
                        "type": "integer",
                        "description": "Number of records to skip",
                        "example": 0
                    },
                    "filters": {
                        "type": "object",
                        "description": "Additional filters to apply"
                    },
                    "endTimestamp": {
                        "type": "integer",
                        "description": "End timestamp for filtering",
                        "example": 1778658161
                    },
                    "testingRunType": {
                        "type": "string",
                        "description": "Type of testing run"
                    },
                    "startTimestamp": {
                        "type": "integer",
                        "description": "Start timestamp for filtering",
                        "example": 0
                    }
                },
                "required": ["limit", "skip", "endTimestamp", "startTimestamp"]
            }
            """
        )),
        Map.entry("fetchSeverityInfoForIssues", new ToolInfo(
            "fetchSeverityInfoForIssues",
            "Retrieves severity information for issues.",
            """
            {
                "type": "object",
                "properties": {
                    "endTimeStamp": {
                        "type": "integer",
                        "description": "End timestamp for filtering",
                        "example": 0
                    }
                },
                "required": ["endTimeStamp"]
            }
            """
        )),
        Map.entry("getReportFilters", new ToolInfo(
            "getReportFilters",
            "Retrieves filters for a specific report.",
            """
            {
                "type": "object",
                "properties": {
                    "generatedReportId": {
                        "type": "string",
                        "description": "ID of the generated report",
                        "example": "6821a65c934b8e3c4f933659"
                    }
                },
                "required": ["generatedReportId"]
            }
            """
        )),
        Map.entry("fetchCollectionWiseApiEndpoints", new ToolInfo(
            "fetchCollectionWiseApiEndpoints",
            "Retrieves API endpoints for a specific collection.",
            """
            {
                "type": "object",
                "properties": {
                    "apiCollectionId": {
                        "type": "integer",
                        "description": "ID of the API collection",
                        "example": 1111111111
                    }
                },
                "required": ["apiCollectionId"]
            }
            """
        )),
        Map.entry("fetchDataTypes", new ToolInfo(
            "fetchDataTypes",
            "Retrieves all data types in the system.",
            """
            {
                "type": "object",
                "description": "No input parameters required"
            }
            """
        )),
        Map.entry("fetchAuthMechanismData", new ToolInfo(
            "fetchAuthMechanismData",
            "Retrieves authentication mechanism data.",
            """
            {
                "type": "object",
                "description": "No input parameters required"
            }
            """
        )),
        Map.entry("fetchMetadataFilters", new ToolInfo(
            "fetchMetadataFilters",
            "Retrieves metadata filters.",
            """
            {
                "type": "object",
                "description": "No input parameters required"
            }
            """
        )),
        Map.entry("fetchRecentParams", new ToolInfo(
            "fetchRecentParams",
            "Retrieves recent parameters over a specified time period.",
            """
            {
                "type": "object",
                "properties": {
                    "endTimestamp": {
                        "type": "integer",
                        "description": "End timestamp for the period",
                        "example": 1747074599
                    },
                    "startTimestamp": {
                        "type": "integer",
                        "description": "Start timestamp for the period",
                        "example": 1741804200
                    }
                },
                "required": ["endTimestamp", "startTimestamp"]
            }
            """
        )),
        Map.entry("findTotalIssuesByDay", new ToolInfo(
            "findTotalIssuesByDay",
            "Retrieves total issues grouped by day over a specified time period.",
            """
            {
                "type": "object",
                "properties": {
                    "endTimeStamp": {
                        "type": "integer",
                        "description": "End timestamp for the period",
                        "example": 1778571718
                    },
                    "startEpoch": {
                        "type": "integer",
                        "description": "Start timestamp for the period",
                        "example": 0
                    }
                },
                "required": ["endTimeStamp", "startEpoch"]
            }
            """
        )),
        Map.entry("loadSensitiveParameters", new ToolInfo(
            "loadSensitiveParameters",
            "Retrieves sensitive parameters for a specific endpoint.",
            """
            {
                "type": "object",
                "properties": {
                    "method": {
                        "type": "string",
                        "description": "HTTP method of the endpoint",
                        "example": "GET"
                    },
                    "apiCollectionId": {
                        "type": "integer",
                        "description": "ID of the API collection",
                        "example": 1747033350
                    },
                    "url": {
                        "type": "string",
                        "description": "URL of the endpoint",
                        "example": "https://vulnerable-server.akto.io/api/college/student-details"
                    }
                },
                "required": ["method", "apiCollectionId", "url"]
            }
            """
        )),
        Map.entry("fetchSensitiveSampleData", new ToolInfo(
            "fetchSensitiveSampleData",
            "Retrieves sample data for sensitive parameters of a specific endpoint.",
            """
            {
                "type": "object",
                "properties": {
                    "method": {
                        "type": "string",
                        "description": "HTTP method of the endpoint",
                        "example": "GET"
                    },
                    "apiCollectionId": {
                        "type": "integer",
                        "description": "ID of the API collection",
                        "example": 1111111111
                    },
                    "url": {
                        "type": "string",
                        "description": "URL of the endpoint",
                        "example": "https://vulnerable-server.akto.io/api/v2/feePayment"
                    }
                },
                "required": ["method", "apiCollectionId", "url"]
            }
            """
        )),
        Map.entry("reRunTest", new ToolInfo(
            "reRunTest",
            "Reruns a specific test.",
            """
            {
                "type": "object",
                "properties": {
                    "testingRunHexId": {
                        "type": "string",
                        "description": "Hex ID of the testing run",
                        "example": "6821a172934b8e3c4f933658"
                    }
                },
                "required": ["testingRunHexId"]
            }
            """
        )),
        Map.entry("fetchNewParametersTrend", new ToolInfo(
            "fetchNewParametersTrend",
            "Retrieves trend data for new parameters over a specified time period.",
            """
            {
                "type": "object",
                "properties": {
                    "endTimestamp": {
                        "type": "integer",
                        "description": "End timestamp for the trend period",
                        "example": 1747074599
                    },
                    "startTimestamp": {
                        "type": "integer",
                        "description": "Start timestamp for the trend period",
                        "example": 1741804200
                    }
                },
                "required": ["endTimestamp", "startTimestamp"]
            }
            """
        )),
        Map.entry("fetchSensitiveParamsForEndpoints", new ToolInfo(
            "fetchSensitiveParamsForEndpoints",
            "Retrieves sensitive parameters for specific endpoints.",
            """
            {
                "type": "object",
                "properties": {
                    "method": {
                        "type": "string",
                        "description": "HTTP method of the endpoint",
                        "example": "GET"
                    },
                    "apiCollectionId": {
                        "type": "integer",
                        "description": "ID of the API collection",
                        "example": 1111111111
                    },
                    "url": {
                        "type": "string",
                        "description": "URL of the endpoint",
                        "example": "https://vulnerable-server.akto.io/api/college/dashboard/home"
                    }
                },
                "required": ["method", "apiCollectionId", "url"]
            }
            """
        )),
        Map.entry("fetchPropertyIds", new ToolInfo(
            "fetchPropertyIds",
            "Retrieves property IDs.",
            """
            {
                "type": "object",
                "description": "No input parameters required"
            }
            """
        )),
        Map.entry("fetchAllCollectionsBasic", new ToolInfo(
            "fetchAllCollectionsBasic",
            "Retrieves basic information about all collections.",
            """
            {
                "type": "object",
                "description": "No input parameters required"
            }
            """
        ))
    );

    public static class ToolInfo {
        private final String name;
        private final String description;
        private final String inputSchema;

        public ToolInfo(String name, String description, String inputSchema) {
            this.name = name;
            this.description = description;
            this.inputSchema = inputSchema;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getInputSchema() {
            return inputSchema;
        }
    }
} 