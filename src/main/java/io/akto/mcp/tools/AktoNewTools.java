package io.akto.mcp.tools;

import io.akto.mcp.processor.ApiProcessor;
import java.util.Collections;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class AktoNewTools {

    private final ApiProcessor apiProcessor;

    @Tool(name = "getApiCollections", description = """
        POST /api/getAllCollectionsBasic
        Sample request body schema:
            "requestBody": {
              "content": {
                "application/json": {
                  "schema": {
                    "type": "object",
                    "description": "Sample description",
                    "types": [
                      "object"
                    ]
                  }
                }
              }
            }
        
        """)
    public String getApiCollections() {
        return getResponseFromAkto("api/getAllCollectionsBasic", Collections.emptyMap(),
            org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "getAllCollections", description = """
        POST /api/getAllCollections
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String getAllCollections() {
        return getResponseFromAkto("api/getAllCollections", Collections.emptyMap(),
            org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "get_collection", description = """
        POST /api/getCollection
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "apiCollectionId": {"type": "integer", "format": "int32", "example": 1111111111, "types": ["integer"]}
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String getCollection(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/getCollection",
            request,
            org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "retrieveAllCollectionTests", description = """
        POST /api/retrieveAllCollectionTests
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "searchString": {"type": "string", "example": "", "types": ["string"]},
                  "sortKey": {"type": "string", "example": "scheduleTimestamp", "types": ["string"]},
                  "sortOrder": {"type": "integer", "format": "int32", "example": -1, "types": ["integer"]},
                  "limit": {"type": "integer", "format": "int32", "example": 50, "types": ["integer"]},
                  "skip": {"type": "integer", "format": "int32", "example": 0, "types": ["integer"]},
                  "filters": {"type": "string", "example": "null", "types": ["string"]},
                  "endTimestamp": {"required": "true", "type": "integer", "format": "int32", "example": 1778658161, "types": ["integer"]}, // this is a compulsory field and must be equal to current timestamp
                  "testingRunType": {"type": "string", "example": "null", "types": ["string"]},
                  "startTimestamp": {"type": "integer", "format": "int32", "example": 0, "types": ["integer"]}
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String retrieveAllCollectionTestsRequest(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/retrieveAllCollectionTests",
            request,
            org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchSeverityInfoForIssues", description = """
        POST /api/fetchSeverityInfoForIssues
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "endTimeStamp": {
                    "type": "integer",
                    "format": "int32",
                    "example": 0,
                    "types": ["integer"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchSeverityInfoForIssues(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchSeverityInfoForIssues", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "getReportFilters", description = """
        POST /api/getReportFilters
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "generatedReportId": {
                    "type": "string",
                    "example": "6821a65c934b8e3c4f933659",
                    "types": ["string"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String getReportFilters(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/getReportFilters", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchCollectionWiseApiEndpoints", description = """
        POST /api/fetchCollectionWiseApiEndpoints
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "apiCollectionId": {
                    "required": "true",
                    "type": "integer",
                    "format": "int32",
                    "example": 1111111111,
                    "types": ["integer"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchCollectionWiseApiEndpoints(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchCollectionWiseApiEndpoints", request,
            org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchBurpCredentials", description = """
        POST /api/fetchBurpCredentials
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchBurpCredentials() {
        return getResponseFromAkto("api/fetchBurpCredentials", Collections.emptyMap(),
            org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "attachFileToIssueFull", description = """
        Attaches a file or test request/response details to a specific issue in the system. Useful for adding evidence or context to an issue for better tracking and resolution.
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "issueId": {
                    "type": "string",
                    "example": "NAYAN-73",
                    "types": ["string"]
                  },
                  "testReq": {
                    "type": "string",
                    "example": "{...}",
                    "types": ["string"]
                  },
                  "origReq": {
                    "type": "string",
                    "example": "{...}",
                    "types": ["string"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String attachFileToIssueFull(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/attachFileToIssue", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchSlackWebhooks", description = """
        POST /api/fetchSlackWebhooks
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchSlackWebhooks() {
        return getResponseFromAkto("api/fetchSlackWebhooks", Collections.emptyMap(),
            org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchSlackWebhooksFull", description = """
        Fetches all configured Slack webhooks for the current account. Useful for integrating Akto alerts and notifications with your Slack channels.
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchSlackWebhooksFull() {
        return getResponseFromAkto("api/fetchSlackWebhooks", Collections.emptyMap(),
            org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchDataTypes", description = """
        POST /api/fetchDataTypes
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchDataTypes() {
        return getResponseFromAkto("api/fetchDataTypes", Collections.emptyMap(),
            org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchAuthMechanismData", description = """
        POST /api/fetchAuthMechanismData
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchAuthMechanismData() {
        return getResponseFromAkto("api/fetchAuthMechanismData", Collections.emptyMap(),
            org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "checkWebhook", description = """
        POST /api/checkWebhook
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "webhookOption": {
                    "type": "string",
                    "example": "TESTING_RUN_RESULTS",
                    "types": ["string"]
                  },
                  "webhookType": {
                    "type": "string",
                    "example": "MICROSOFT_TEAMS",
                    "types": ["string"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String checkWebhook(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/checkWebhook", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchMetadataFilters", description = """
        POST /api/fetchMetadataFilters
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchMetadataFilters() {
        return getResponseFromAkto("api/fetchMetadataFilters", Collections.emptyMap(),
            org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchIssueFromTestRunResultDetails", description = """
        POST /api/fetchIssueFromTestRunResultDetails
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "testingRunResultHexId": {
                    "type": "string",
                    "example": "6821a4804eadbb6d7ca7c42c",
                    "types": ["string"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchIssueFromTestRunResultDetails(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchIssueFromTestRunResultDetails", request,
            org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchCountMapOfApis", description = """
        POST /api/fetchCountMapOfApis
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchCountMapOfApis() {
        return getResponseFromAkto("api/fetchCountMapOfApis", Collections.emptyMap(),
            org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchAllSubCategories", description = """
        POST /api/fetchAllSubCategories
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "mode": {
                    "type": "string",
                    "example": "testEditor",
                    "types": ["string"]
                  },
                  "fetchOnlyActive": {
                    "type": "boolean",
                    "example": false,
                    "types": ["boolean"]
                  },
                  "limit": {
                    "type": "integer",
                    "format": "int32",
                    "example": 50,
                    "types": ["integer"]
                  },
                  "skip": {
                    "type": "integer",
                    "format": "int32",
                    "example": 100,
                    "types": ["integer"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchAllSubCategories(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchAllSubCategories", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "getSeverityInfoForCollections", description = """
        POST /api/getSeverityInfoForCollections
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String getSeverityInfoForCollections(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/getSeverityInfoForCollections", request,
            org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchVulnerableRequests", description = """
        POST /api/fetchVulnerableRequests
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "limit": {
                    "type": "integer",
                    "format": "int32",
                    "example": 50,
                    "types": ["integer"]
                  },
                  "skip": {
                    "type": "integer",
                    "format": "int32",
                    "example": 400,
                    "types": ["integer"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchVulnerableRequests(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchVulnerableRequests", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchQuickStartPageState", description = """
        POST /api/fetchQuickStartPageState
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchQuickStartPageState(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchQuickStartPageState", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchRecentParams", description = """
        POST /api/fetchRecentParams
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "endTimestamp": {
                    "type": "integer",
                    "format": "int32",
                    "example": 1747074599,
                    "types": ["integer"]
                  },
                  "startTimestamp": {
                    "type": "integer",
                    "format": "int32",
                    "example": 1741804200,
                    "types": ["integer"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchRecentParams(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchRecentParams", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "createJiraIssueFull", description = """
        Creates a new Jira issue and links it to an Akto issue. This is useful for integrating Akto's issue tracking with your Jira workflow, allowing for seamless collaboration and tracking between security and engineering teams.
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "issueType": {
                    "type": "integer",
                    "format": "int32",
                    "example": 10035,
                    "types": ["integer"]
                  },
                  "projId": {
                    "type": "string",
                    "example": "NAYAN",
                    "types": ["string"]
                  },
                  "jiraMetaData": {
                    "type": "object",
                    "properties": {
                      "issueUrl": {
                        "type": "string",
                        "example": "https://app.akto.io/dashboard/testing/6821a172934b8e3c4f933658?result=6821a4804eadbb6d7ca7c42c",
                        "types": ["string"]
                      },
                      "hostStr": {
                        "type": "string",
                        "example": "Host - vulnerable-server.akto.io",
                        "types": ["string"]
                      },
                      "issueTitle": {
                        "type": "string",
                        "example": "JWT None Algorithm",
                        "types": ["string"]
                      },
                      "testingIssueId": {
                        "type": "object",
                        "properties": {
                          "testSubCategory": {
                            "type": "string",
                            "example": "JWT_NONE_ALGO",
                            "types": ["string"]
                          },
                          "testErrorSource": {
                            "type": "string",
                            "example": "AUTOMATED_TESTING",
                            "types": ["string"]
                          },
                          "testCategoryFromSourceConfig": {
                            "type": "string",
                            "example": "null",
                            "types": ["string"]
                          },
                          "apiInfoKey": {
                            "type": "object",
                            "properties": {
                              "method": {
                                "type": "string",
                                "example": "GET",
                                "types": ["string"]
                              },
                              "apiCollectionId": {
                                "type": "integer",
                                "format": "int32",
                                "example": 1111111111,
                                "types": ["integer"]
                              },
                              "url": {
                                "type": "string",
                                "example": "https://vulnerable-server.akto.io/api/college/student-details",
                                "types": ["string"]
                              }
                            },
                            "types": ["object"]
                          },
                          "testSourceConfig": {
                            "type": "string",
                            "example": "null",
                            "types": ["string"]
                          }
                        },
                        "types": ["object"]
                      },
                      "endPointStr": {
                        "type": "string",
                        "example": "Endpoint - /api/college/student-details",
                        "types": ["string"]
                      },
                      "issueDescription": {
                        "type": "string",
                        "example": "Description - The endpoint appears to be vulnerable to broken authentication attack.The original request was replayed by changing algorithm of JWT token to NONE in request headers. The server responded with 2XX success codes. This indicates that this endpoint can be accessed without JWT signature which means a malicious user can get unauthorized access to this endpoint. Background: All JSON Web Tokens should contain the \\alg\\ header parameter, which specifies the algorithm that the server should use to verify the signature of the token. In addition to cryptographically strong algorithms the JWT specification also defines the \\none\\ algorithm, which can be used with \\unsecured\\ (unsigned) JWTs. When this algorithm is supported on the server, it may accept tokens that have no signature at all. As the JWT header can be tampered with client-side, a malicious user could change the \\alg\\ header to \\none\\, then remove the signature and check whether the server still accepts the token.\n",
                        "types": ["string"]
                      }
                    },
                    "types": ["object"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String createJiraIssueFull(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/createJiraIssue", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "findTotalIssuesByDay", description = """
        POST /api/findTotalIssuesByDay
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "endTimeStamp": {
                    "type": "integer",
                    "format": "int32",
                    "example": 1778571718,
                    "types": ["integer"]
                  },
                  "startEpoch": {
                    "type": "integer",
                    "format": "int32",
                    "example": 0,
                    "types": ["integer"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String findTotalIssuesByDay(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/findTotalIssuesByDay", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "loadSensitiveParameters", description = """
        POST /api/loadSensitiveParameters
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "method": {
                    "type": "string",
                    "example": "GET",
                    "types": ["string"]
                  },
                  "apiCollectionId": {
                    "type": "integer",
                    "format": "int32",
                    "example": 1747033350,
                    "types": ["integer"]
                  },
                  "url": {
                    "type": "string",
                    "example": "https://vulnerable-server.akto.io/api/college/student-details",
                    "types": ["string"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String loadSensitiveParameters(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/loadSensitiveParameters", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchSensitiveSampleData", description = """
        POST /api/fetchSensitiveSampleData
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "method": {
                    "type": "string",
                    "example": "GET",
                    "types": ["string"]
                  },
                  "apiCollectionId": {
                    "type": "integer",
                    "format": "int32",
                    "example": 1111111111,
                    "types": ["integer"]
                  },
                  "url": {
                    "type": "string",
                    "example": "https://vulnerable-server.akto.io/api/v2/feePayment",
                    "types": ["string"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchSensitiveSampleData(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchSensitiveSampleData", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "startTest", description = """
        POST /api/startTest
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "testingRunHexId": {
                    "type": "string",
                    "example": "6821a172934b8e3c4f933658",
                    "types": ["string"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String startTest(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/startTest", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchNewParametersTrend", description = """
        POST /api/fetchNewParametersTrend
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "endTimestamp": {
                    "type": "integer",
                    "format": "int32",
                    "example": 1747074599,
                    "types": ["integer"]
                  },
                  "startTimestamp": {
                    "type": "integer",
                    "format": "int32",
                    "example": 1741804200,
                    "types": ["integer"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchNewParametersTrend(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchNewParametersTrend", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "deleteApiToken", description = """
        POST /api/deleteApiToken
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "apiTokenId": {
                    "type": "integer",
                    "format": "int32",
                    "example": 1747031584,
                    "types": ["integer"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String deleteApiToken(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/deleteApiToken", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "deleteTestRuns", description = """
        POST /api/deleteTestRuns
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "testRunIds": {
                    "type": "array",
                    "items": {
                      "type": "string",
                      "example": "681d9613fb52b52784e4240b",
                      "types": ["string"]
                    },
                    "types": ["array"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String deleteTestRuns(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/deleteTestRuns", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchAktoGptConfig", description = """
        POST /api/fetchAktoGptConfig
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchAktoGptConfig(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchAktoGptConfig", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchSensitiveParamsForEndpoints", description = """
        POST /api/fetchSensitiveParamsForEndpoints
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "method": {
                    "type": "string",
                    "example": "GET",
                    "types": ["string"]
                  },
                  "apiCollectionId": {
                    "type": "integer",
                    "format": "int32",
                    "example": 1111111111,
                    "types": ["integer"]
                  },
                  "url": {
                    "type": "string",
                    "example": "https://vulnerable-server.akto.io/api/college/dashboard/home",
                    "types": ["string"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchSensitiveParamsForEndpoints(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchSensitiveParamsForEndpoints", request,
            org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchPropertyIds", description = """
        POST /api/fetchPropertyIds
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchPropertyIds(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchPropertyIds", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchAdminSettings", description = """
        POST /api/fetchAdminSettings
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchAdminSettings(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchAdminSettings", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchAllCollectionsBasic", description = """
        POST /api/getAllCollectionsBasic
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchAllCollectionsBasic() {
        return getResponseFromAkto("api/getAllCollectionsBasic", Collections.emptyMap(),
            org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchDataTypesFull", description = """
        POST /api/fetchDataTypes
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchDataTypesFull() {
        return getResponseFromAkto("api/fetchDataTypes", Collections.emptyMap(),
            org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchTestingRunResult", description = """
        POST /api/fetchTestingRunResult
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "issueId": {
                    "type": "object",
                    "properties": {
                      "testSubCategory": {"type": "string", "example": "JWT_HEADER_PARAM_INJECTION_KID", "types": ["string"]},
                      "testErrorSource": {"type": "string", "example": "AUTOMATED_TESTING", "types": ["string"]},
                      "testCategoryFromSourceConfig": {"type": "string", "example": "null", "types": ["string"]},
                      "apiInfoKey": {
                        "type": "object",
                        "properties": {
                          "method": {"type": "string", "example": "GET", "types": ["string"]},
                          "apiCollectionId": {"type": "integer", "format": "int32", "example": 1111111111, "types": ["integer"]},
                          "url": {"type": "string", "example": "https://vulnerable-server.akto.io/api/college/student-details", "types": ["string"]}
                        },
                        "types": ["object"]
                      },
                      "testSourceConfig": {"type": "string", "example": "null", "types": ["string"]}
                    },
                    "types": ["object"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchTestingRunResult(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchTestingRunResult", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchRemediationInfo", description = """
        POST /api/fetchRemediationInfo
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "issueId": {
                    "type": "object",
                    "properties": {
                      "testSubCategory": {"type": "string", "example": "string", "types": ["string"]},
                      "testErrorSource": {"type": "string", "example": "string", "types": ["string"]},
                      "testCategoryFromSourceConfig": {"type": "string", "example": "string", "types": ["string"]},
                      "apiInfoKey": {
                        "type": "object",
                        "properties": {
                          "method": {"type": "string", "example": "string", "types": ["string"]},
                          "apiCollectionId": {"type": "integer", "format": "int32", "example": 0, "types": ["integer"]},
                          "url": {"type": "string", "example": "string", "types": ["string"]}
                        },
                        "types": ["object"]
                      },
                      "testSourceConfig": {"type": "string", "example": "string", "types": ["string"]}
                    },
                    "types": ["object"]
                  },
                  "ignoreReason": {"type": "string", "example": "string", "types": ["string"]},
                  "limit": {"type": "integer", "format": "int32", "example": 0, "types": ["integer"]},
                  "testingRunResultList": {"type": "string", "example": "string", "types": ["string"]},
                  "categories": {"type": "string", "example": "string", "types": ["string"]},
                  "removedRunResultsIssuesList": {"type": "string", "example": "string", "types": ["string"]},
                  "fixedIssuesCount": {"type": "integer", "format": "int32", "example": 0, "types": ["integer"]},
                  "severityInfo": {"type": "string", "example": "string", "types": ["string"]},
                  "filterSubCategory": {"type": "string", "example": "string", "types": ["string"]},
                  "vulnerableRequests": {"type": "string", "example": "string", "types": ["string"]},
                  "sampleDataVsCurlMap": {"type": "string", "example": "string", "types": ["string"]},
                  "similarlyAffectedIssues": {"type": "string", "example": "string", "types": ["string"]},
                  "openIssuesCountDayWise": {"type": "string", "example": "string", "types": ["string"]},
                  "ignoredIssuesCount": {"type": "integer", "format": "int32", "example": 0, "types": ["integer"]},
                  "filterStatus": {"type": "string", "example": "string", "types": ["string"]},
                  "issueIdArray": {"type": "string", "example": "string", "types": ["string"]},
                  "testSourceConfigs": {"type": "string", "example": "string", "types": ["string"]},
                  "testingRunResultSummary": {"type": "string", "example": "string", "types": ["string"]},
                  "fetchOnlyActive": {"type": "boolean", "example": false, "types": ["boolean"]},
                  "criticalIssuesCountDayWise": {"type": "string", "example": "string", "types": ["string"]},
                  "response": {"type": "string", "example": "string", "types": ["string"]},
                  "totalIssuesCountDayWise": {"type": "string", "example": "string", "types": ["string"]},
                  "statusToBeUpdated": {"type": "string", "example": "string", "types": ["string"]}
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchRemediationInfo(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchRemediationInfo", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchApiDependencies", description = """
        Fetches API dependencies and relationships for a specific endpoint. Useful for understanding API connections, impact analysis, and security testing.
        
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "method": {
                    "type": "string",
                    "example": "GET",
                    "types": ["string"]
                  },
                  "apiCollectionId": {
                    "type": "integer",
                    "format": "int32",
                    "example": 1111111111,
                    "types": ["integer"]
                  },
                  "url": {
                    "type": "string",
                    "example": "https://vulnerable-server.akto.io/api/college/dashboard/home",
                    "types": ["string"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchApiDependencies(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchApiDependencies", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchTestRunResults", description = """
        Retrieves detailed test run results with filtering and sorting options. Useful for analyzing test execution results and vulnerabilities.
        
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "queryMode": {
                    "type": "string",
                    "example": "AND",
                    "types": ["string"]
                  },
                  "sortKey": {
                    "type": "string",
                    "example": "severity",
                    "types": ["string"]
                  },
                  "sortOrder": {
                    "type": "string",
                    "example": "desc",
                    "types": ["string"]
                  },
                  "testingRunResultSummaryHexId": {
                    "type": "string",
                    "example": "6821a172934b8e3c4f933658",
                    "types": ["string"]
                  },
                  "limit": {
                    "type": "integer",
                    "format": "int32",
                    "example": 0,
                    "types": ["integer"]
                  },
                  "skip": {
                    "type": "integer",
                    "format": "int32",
                    "example": 0,
                    "types": ["integer"]
                  },
                  "queryValue": {
                    "type": "string",
                    "example": "severity:HIGH",
                    "types": ["string"]
                  }
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchTestRunResults(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchTestRunResults", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchAllIssues", description = """
        Retrieves all issues with filtering and sorting capabilities.
        
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "queryMode": {"type": "string", "example": "AND", "types": ["string"]},
                  "sortKey": {"type": "string", "example": "severity", "types": ["string"]},
                  "sortOrder": {"type": "string", "example": "desc", "types": ["string"]},
                  "limit": {"type": "integer", "format": "int32", "example": 0, "types": ["integer"]},
                  "skip": {"type": "integer", "format": "int32", "example": 0, "types": ["integer"]},
                  "queryValue": {"type": "string", "example": "severity:HIGH", "types": ["string"]}
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchAllIssues(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchAllIssues", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchNewEndpointsTrend", description = """
        Retrieves trend data for new endpoints over a specified time period.
        
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "endTimestamp": {"type": "integer", "format": "int32", "example": 1747074599, "types": ["integer"]},
                  "startTimestamp": {"type": "integer", "format": "int32", "example": 1741804200, "types": ["integer"]}
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchNewEndpointsTrend(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchNewEndpointsTrend", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchTestCoverageData", description = """
        Retrieves test coverage data for API collections over a specified time period.
        
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "startTimeStamp": {"type": "integer", "format": "int32", "example": 0, "types": ["integer"]},
                  "endTimeStamp": {"type": "integer", "format": "int32", "example": 1778571718, "types": ["integer"]}
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchTestCoverageData(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchTestCoverageData", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchCriticalIssuesTrend", description = """
        Retrieves trend data for critical issues over a specified time period.
        
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "startTimeStamp": {"type": "integer", "format": "int32", "example": 0, "types": ["integer"]},
                  "endTimeStamp": {"type": "integer", "format": "int32", "example": 1778571714, "types": ["integer"]}
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchCriticalIssuesTrend(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchCriticalIssuesTrend", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchApiStats", description = """
        Retrieves API statistics over a specified time period.
        
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "startTimeStamp": {"type": "integer", "format": "int32", "example": 0, "types": ["integer"]},
                  "endTimeStamp": {"type": "integer", "format": "int32", "example": 1778571718, "types": ["integer"]}
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchApiStats(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchApiStats", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchEndpointsCount", description = """
        Retrieves the count of endpoints over a specified time period.
        
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "endTimestamp": {"type": "integer", "format": "int32", "example": 0, "types": ["integer"]},
                  "startTimestamp": {"type": "integer", "format": "int32", "example": 0, "types": ["integer"]}
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchEndpointsCount(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchEndpointsCount", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchMiniTestingServiceNames", description = """
        Retrieves the names of mini testing services available in the system.
        
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchMiniTestingServiceNames(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchMiniTestingServiceNames", request,
            org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "getSingleEndpoint", description = """
        Retrieves details for a single API endpoint.
        
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "method": {"type": "string", "example": "GET", "types": ["string"]},
                  "apiCollectionId": {"type": "integer", "format": "int32", "example": 1111111111, "types": ["integer"]},
                  "url": {"type": "string", "example": "https://vulnerable-server.akto.io/api/college/student-details", "types": ["string"]}
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String getSingleEndpoint(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/getSingleEndpoint", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchApiInfosForCollection", description = """
        Retrieves all API infos for a specific collection.
        
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "apiCollectionId": {"type": "integer", "format": "int32", "example": 1747033350, "types": ["integer"]}
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchApiInfosForCollection(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchApiInfosForCollection", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchTestContent", description = """
        Retrieves the content of a specific test by its originalTestId.
        
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "originalTestId": {"type": "string", "example": "APACHE_APISIX_RCE", "types": ["string"]}
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchTestContent(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchTestContent", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchTestRoles", description = """
        Retrieves all test roles available in the system.
        
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchTestRoles(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchTestRoles", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchSubTypeCountMap", description = """
        Retrieves a count map of subtypes for endpoints over a specified time period.
        
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "endTimestamp": {"type": "integer", "format": "int32", "example": 1747032698, "types": ["integer"]},
                  "startTimestamp": {"type": "integer", "format": "int32", "example": 0, "types": ["integer"]}
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchSubTypeCountMap(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchSubTypeCountMap", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "getAllUsersCollections", description = """
        Retrieves all user collections in the system.
        
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String getAllUsersCollections(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/getAllUsersCollections", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "getAllTestsCountMap", description = """
        Retrieves a count map of all tests over a specified time period.
        
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "endTimestamp": {"type": "integer", "format": "int32", "example": 1778658008, "types": ["integer"]},
                  "startTimestamp": {"type": "integer", "format": "int32", "example": 0, "types": ["integer"]}
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String getAllTestsCountMap(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/getAllTestsCountMap", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "fetchNewEndpointsTrendForNonHostCollections", description = """
        Retrieves trend data for new endpoints in non-host collections over a specified time period.
        
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "endTimestamp": {"type": "integer", "format": "int32", "example": 1747074599, "types": ["integer"]},
                  "startTimestamp": {"type": "integer", "format": "int32", "example": 1741804200, "types": ["integer"]}
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String fetchNewEndpointsTrendForNonHostCollections(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/fetchNewEndpointsTrendForNonHostCollections", request,
            org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "bulkUpdateIssueStatus", description = """
        Updates the status of multiple issues in bulk. Useful for mass issue management and status updates.
        
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "description": "AKTO_ERROR while building schema",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String bulkUpdateIssueStatus(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/bulkUpdateIssueStatus", request, org.springframework.http.HttpMethod.POST);
    }

    @Tool(name = "bulkCreateJiraTickets", description = """
        Creates multiple Jira tickets in bulk for selected issues. Useful for mass ticket creation and integration management.
        
        Sample request body schema:
        {
          "content": {
            "application/json": {
              "schema": {
                "type": "object",
                "properties": {
                  "issueType": {"type": "integer", "format": "int32", "example": 10035, "types": ["integer"]},
                  "projId": {"type": "string", "example": "NAYAN", "types": ["string"]},
                  "issuesIds": {"type": "array", "items": {"type": "object", "properties": {"testSubCategory": {"type": "string", "example": "JWT_HEADER_PARAM_INJECTION_KID", "types": ["string"]}, "testErrorSource": {"type": "string", "example": "AUTOMATED_TESTING", "types": ["string"]}, "testCategoryFromSourceConfig": {"type": "string", "example": "null", "types": ["string"]}, "apiInfoKey": {"type": "object", "properties": {"method": {"type": "string", "example": "GET", "types": ["string"]}, "apiCollectionId": {"type": "integer", "format": "int32", "example": 1111111111, "types": ["integer"]}, "url": {"type": "string", "example": "https://vulnerable-server.akto.io/api/college/dashboard/home", "types": ["string"]}}, "types": ["object"]}, "testSourceConfig": {"type": "string", "example": "null", "types": ["string"]}}, "types": ["object"]}, "types": ["array"]}, "aktoDashboardHost": {"type": "string", "example": "https://app.akto.io", "types": ["string"]}
                },
                "description": "Sample description",
                "types": ["object"]
              }
            }
          }
        }
        """)
    public String bulkCreateJiraTickets(@RequestBody Map<String, Object> request) {
        return getResponseFromAkto("api/bulkCreateJiraTickets", request, org.springframework.http.HttpMethod.POST);
    }

    private String getResponseFromAkto(String path, Object request, org.springframework.http.HttpMethod method) {
        try {
            if (request == null) {
                request = Collections.emptyMap();
            }
            return apiProcessor.processRequest(path,
                request,
                String.class,
                method);
        } catch (Exception e) {
            log.error("Error calling API: {}", e.getMessage(), e);
            throw e;
        }
    }
}
