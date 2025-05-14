package io.akto.mcp.tools;

import io.akto.mcp.model.FetchSeverityInfoForIssuesRequest;
import io.akto.mcp.model.FetchTestContentRequest;
import io.akto.mcp.model.FetchTestingRunResultRequest;
import io.akto.mcp.model.FetchTestingRunResultsRequest;
import io.akto.mcp.models.RetrieveAllCollectionTestsRequest;
import io.akto.mcp.processor.ApiProcessor;
import java.util.Collections;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class AktoTools {

    private final ApiProcessor apiProcessor;

    @Tool(name = "getApiCollections", description = """
        POST /api/getAllCollectionsBasic
        Example request body:
        {}
        """)
    public String getApiCollections() {
        return getResponseFromAkto("api/getAllCollectionsBasic", Collections.emptyMap());
    }

    @Tool(name = "getAllCollections", description = """
        POST /api/getAllCollections
        Example request body:
        {}
        """)
    public String getAllCollections() {
        return getResponseFromAkto("api/getAllCollections", Collections.emptyMap());
    }

    @Tool(name = "getCollection", description = """
        POST /api/getCollection
        Example request body:
        {"request": {
          "apiCollectionId": 1111111111
        }}
        """)
    public String getCollection(Map<String, Object> request) {
        return getResponseFromAkto("api/getCollection", request);
    }

    @Tool(name = "retrieveAllCollectionTests", description = """
        POST /api/retrieveAllCollectionTests
        Example request body:
        {"request": {
          "searchString": "",
          "sortKey": "scheduleTimestamp",
          "sortOrder": -1,
          "limit": 50,
          "skip": 0,
          "filters": null,
          "endTimestamp": 1778658161,
          "testingRunType": null,
          "startTimestamp": 0
        }}
        """)
    public String retrieveAllCollectionTestsRequest(RetrieveAllCollectionTestsRequest request) {
        return getResponseFromAkto("api/retrieveAllCollectionTests", request);
    }

    @Tool(name = "fetchSeverityInfoForIssues", description = """
        POST /api/fetchSeverityInfoForIssues
        Example request body:
        {"request": {
          "endTimeStamp": 0
        }}
        """)
    public String fetchSeverityInfoForIssues(FetchSeverityInfoForIssuesRequest request) {
        return getResponseFromAkto("api/fetchSeverityInfoForIssues", request);
    }

    @Tool(name = "getReportFilters", description = """
        POST /api/getReportFilters
        Example request body:
        {"request": {
          "generatedReportId": "6821a65c934b8e3c4f933659"
        }}
        """)
    public String getReportFilters(Map<String, Object> request) {
        return getResponseFromAkto("api/getReportFilters", request);
    }

    @Tool(name = "fetchCollectionWiseApiEndpoints", description = """
        POST /api/fetchCollectionWiseApiEndpoints
        Example request body:
        {"request": {
          "apiCollectionId": 1111111111
        }}
        """)
    public String fetchCollectionWiseApiEndpoints(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchCollectionWiseApiEndpoints", request);
    }

    @Tool(name = "fetchDataTypes", description = """
        POST /api/fetchDataTypes
        Example request body:
        {}
        """)
    public String fetchDataTypes() {
        return getResponseFromAkto("api/fetchDataTypes", Collections.emptyMap());
    }

    @Tool(name = "fetchAuthMechanismData", description = """
        POST /api/fetchAuthMechanismData
        Example request body:
        {}
        """)
    public String fetchAuthMechanismData() {
        return getResponseFromAkto("api/fetchAuthMechanismData", Collections.emptyMap());
    }

    @Tool(name = "fetchMetadataFilters", description = """
        POST /api/fetchMetadataFilters
        Example request body:
        {}
        """)
    public String fetchMetadataFilters() {
        return getResponseFromAkto("api/fetchMetadataFilters", Collections.emptyMap());
    }

    @Tool(name = "fetchIssueFromTestRunResultDetails", description = """
        POST /api/fetchIssueFromTestRunResultDetails
        Example request body:
        {"request": {
          "testingRunResultHexId": "6821a4804eadbb6d7ca7c42c"
        }}
        """)
    public String fetchIssueFromTestRunResultDetails(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchIssueFromTestRunResultDetails", request);
    }

    @Tool(name = "fetchCountMapOfApis", description = """
        POST /api/fetchCountMapOfApis
        Example request body:
        {}
        """)
    public String fetchCountMapOfApis() {
        return getResponseFromAkto("api/fetchCountMapOfApis", Collections.emptyMap());
    }

    @Tool(name = "fetchAllSubCategories", description = """
        POST /api/fetchAllSubCategories
        Example request body:
        {"request": {
          "mode": "testEditor",
          "fetchOnlyActive": false,
          "limit": 50,
          "skip": 100
        }}
        """)
    public String fetchAllSubCategories(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchAllSubCategories", request);
    }

    @Tool(name = "getSeverityInfoForCollections", description = """
        POST /api/getSeverityInfoForCollections
        Example request body:
        {}
        """)
    public String getSeverityInfoForCollections() {
        return getResponseFromAkto("api/getSeverityInfoForCollections", Collections.emptyMap());
    }

    @Tool(name = "fetchVulnerableRequests", description = """
        POST /api/fetchVulnerableRequests
        Example request body:
        {"request": {
          "limit": 50,
          "skip": 400
        }}
        """)
    public String fetchVulnerableRequests(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchVulnerableRequests", request);
    }

    @Tool(name = "fetchRecentParams", description = """
        POST /api/fetchRecentParams
        Example request body:
        {"request": {
          "endTimestamp": 1747074599,
          "startTimestamp": 1741804200
        }}
        """)
    public String fetchRecentParams(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchRecentParams", request);
    }

    @Tool(name = "findTotalIssuesByDay", description = """
        POST /api/findTotalIssuesByDay
        Example request body:
        {"request": {
          "endTimeStamp": 1778571718,
          "startEpoch": 0
        }}
        """)
    public String findTotalIssuesByDay(Map<String, Object> request) {
        return getResponseFromAkto("api/findTotalIssuesByDay", request);
    }

    @Tool(name = "loadSensitiveParameters", description = """
        POST /api/loadSensitiveParameters
        Example request body:
        {"request": {
          "method": "GET",
          "apiCollectionId": 1747033350,
          "url": "https://vulnerable-server.akto.io/api/college/student-details"
        }}
        """)
    public String loadSensitiveParameters(Map<String, Object> request) {
        return getResponseFromAkto("api/loadSensitiveParameters", request);
    }

    @Tool(name = "fetchSensitiveSampleData", description = """
        POST /api/fetchSensitiveSampleData
        Example request body:
        {"request": {
          "method": "GET",
          "apiCollectionId": 1111111111,
          "url": "https://vulnerable-server.akto.io/api/v2/feePayment"
        }}
        """)
    public String fetchSensitiveSampleData(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchSensitiveSampleData", request);
    }

    @Tool(name = "reRunTest", description = """
        POST /api/startTest
        Example request body:
        {"request": {
          "testingRunHexId": "6821a172934b8e3c4f933658"
        }}
        """)
    public String reRunTest(Map<String, Object> request) {
        return getResponseFromAkto("api/startTest", request);
    }

    @Tool(name = "fetchNewParametersTrend", description = """
        POST /api/fetchNewParametersTrend
        Example request body:
        {"request": {
          "endTimestamp": 1747074599,
          "startTimestamp": 1741804200
        }}
        """)
    public String fetchNewParametersTrend(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchNewParametersTrend", request);
    }

    @Tool(name = "fetchSensitiveParamsForEndpoints", description = """
        POST /api/fetchSensitiveParamsForEndpoints
        Example request body:
        {"request": {
          "method": "GET",
          "apiCollectionId": 1111111111,
          "url": "https://vulnerable-server.akto.io/api/college/dashboard/home"
        }}
        """)
    public String fetchSensitiveParamsForEndpoints(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchSensitiveParamsForEndpoints", request);
    }

    @Tool(name = "fetchPropertyIds", description = """
        POST /api/fetchPropertyIds
        Example request body:
        {}
        """)
    public String fetchPropertyIds() {
        return getResponseFromAkto("api/fetchPropertyIds", null);
    }

    @Tool(name = "fetchAllCollectionsBasic", description = """
        POST /api/getAllCollectionsBasic
        Example request body:
        {}
        """)
    public String fetchAllCollectionsBasic() {
        return getResponseFromAkto("api/getAllCollectionsBasic", Collections.emptyMap());
    }

    @Tool(name = "fetchDataTypesFull", description = """
        POST /api/fetchDataTypes
        Example request body:
        {}
        """)
    public String fetchDataTypesFull() {
        return getResponseFromAkto("api/fetchDataTypes", Collections.emptyMap());
    }

    @Tool(name = "fetchTestingRunResult", description = """
        POST /api/fetchTestingRunResult
        Example request body:
        {
          "issueId": {
            "testSubCategory": "JWT_HEADER_PARAM_INJECTION_KID",
            "testErrorSource": "AUTOMATED_TESTING",
            "testCategoryFromSourceConfig": null,
            "apiInfoKey": {
              "method": "GET",
              "apiCollectionId": 1111111111,
              "url": "https://vulnerable-server.akto.io/api/college/student-details"
            },
            "testSourceConfig": null
          }
        }≠
        """)
    public String fetchTestingRunResult(FetchTestingRunResultRequest request) {
        return getResponseFromAkto("api/fetchTestingRunResult", request);
    }

    @Tool(name = "fetchTestingRunResults", description = """
        POST /api/fetchTestingRunResults
        Example request body:
        {"request": {
          "queryMode": "AND",
          "sortKey": "severity",
          "sortOrder": "desc",
          "testingRunResultSummaryHexId": "6821a172934b8e3c4f933658",
          "limit": 0,
          "skip": 0,
          "queryValue": "severity:HIGH"
        }}
        """)
    public String fetchTestingRunResults(FetchTestingRunResultsRequest request) {
        return getResponseFromAkto("api/fetchTestingRunResults", request);
    }

    @Tool(name = "fetchRemediationInfo", description = """
        POST /api/fetchRemediationInfo
        Example request body:
        {"request": {
          "issueId": {
            "testSubCategory": "string",
            "testErrorSource": "string",
            "testCategoryFromSourceConfig": "string",
            "apiInfoKey": {
              "method": "string",
              "apiCollectionId": 0,
              "url": "string"
            },
            "testSourceConfig": "string"
          },
          "ignoreReason": "string",
          "limit": 0,
          "testingRunResultList": "string",
          "categories": "string",
          "removedRunResultsIssuesList": "string",
          "fixedIssuesCount": 0,
          "severityInfo": "string",
          "filterSubCategory": "string",
          "vulnerableRequests": "string",
          "sampleDataVsCurlMap": "string",
          "similarlyAffectedIssues": "string",
          "openIssuesCountDayWise": "string",
          "ignoredIssuesCount": 0,
          "filterStatus": "string",
          "issueIdArray": "string",
          "testSourceConfigs": "string",
          "testingRunResultSummary": "string",
          "fetchOnlyActive": false,
          "criticalIssuesCountDayWise": "string",
          "response": "string",
          "totalIssuesCountDayWise": "string",
          "statusToBeUpdated": "string"
        }}
        """)
    public String fetchRemediationInfo(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchRemediationInfo", request);
    }

    @Tool(name = "fetchApiDependencies", description = """
        Fetches API dependencies and relationships for a specific endpoint. Useful for understanding API connections, impact analysis, and security testing.
        
        Example request body:
        {"request": {
          "method": "GET",
          "apiCollectionId": 1111111111,
          "url": "https://vulnerable-server.akto.io/api/college/dashboard/home"
        }}
        """)
    public String fetchApiDependencies(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchApiDependencies", request);
    }

    @Tool(name = "fetchTestRunResults", description = """
        Retrieves detailed test run results with filtering and sorting options. Useful for analyzing test execution results and vulnerabilities.
        
        Example request body:
        {"request": {
          "queryMode": "AND",
          "sortKey": "severity",
          "sortOrder": "desc",
          "testingRunResultSummaryHexId": "6821a172934b8e3c4f933658",
          "limit": 0,
          "skip": 0,
          "queryValue": "severity:HIGH"
        }}
        """)
    public String fetchTestRunResults(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchTestRunResults", request);
    }

    @Tool(name = "fetchAllIssues", description = """
        Retrieves all issues with filtering and sorting capabilities.
        
        Example request body:
        {"request": {
          "queryMode": "AND",
          "sortKey": "severity",
          "sortOrder": -1,
          "limit": 0,
          "skip": 0,
          "queryValue": "severity:HIGH"
        }}
        """)
    public String fetchAllIssues(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchAllIssues", request);
    }

    @Tool(name = "fetchNewEndpointsTrend", description = """
        Retrieves trend data for new endpoints over a specified time period.
        
        Example request body:
        {"request": {
          "endTimestamp": 1747074599,
          "startTimestamp": 1741804200
        }}
        """)
    public String fetchNewEndpointsTrend(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchNewEndpointsTrend", request);
    }

    @Tool(name = "fetchTestCoverageData", description = """
        Retrieves test coverage data for API collections over a specified time period.
        
        Example request body:
        {"request": {
          "startTimeStamp": 0,
          "endTimeStamp": 1778571718
        }}
        """)
    public String fetchTestCoverageData(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchTestCoverageData", request);
    }

    @Tool(name = "fetchCriticalIssuesTrend", description = """
        Retrieves trend data for critical issues over a specified time period.
        
        Example request body:
        {"request": {
          "startTimeStamp": 0,
          "endTimeStamp": 1778571714
        }}
        """)
    public String fetchCriticalIssuesTrend(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchCriticalIssuesTrend", request);
    }

    @Tool(name = "fetchApiStats", description = """
        Retrieves API statistics over a specified time period.
        
        Example request body:
        {"request": {
          "startTimeStamp": 0,
          "endTimeStamp": 1778571718
        }}
        """)
    public String fetchApiStats(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchApiStats", request);
    }

    @Tool(name = "fetchEndpointsCount", description = """
        Retrieves the count of endpoints over a specified time period.
        
        Example request body:
        {"request": {
          "endTimestamp": 0,
          "startTimestamp": 0
        }}
        """)
    public String fetchEndpointsCount(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchEndpointsCount", request);
    }

    @Tool(name = "fetchMiniTestingServiceNames", description = """
        Retrieves the names of mini testing services available in the system.
        
        Example request body:
        {}
        """)
    public String fetchMiniTestingServiceNames() {
        return getResponseFromAkto("api/fetchMiniTestingServiceNames", null);
    }

    @Tool(name = "getSingleEndpoint", description = """
        Retrieves details for a single API endpoint.
        
        Example request body:
        {"request": {
          "method": "GET",
          "apiCollectionId": 1111111111,
          "url": "https://vulnerable-server.akto.io/api/college/student-details"
        }}
        """)
    public String getSingleEndpoint(Map<String, Object> request) {
        return getResponseFromAkto("api/getSingleEndpoint", request);
    }

    @Tool(name = "fetchApiInfosForCollection", description = """
        Retrieves all API infos for a specific collection.
        
        Example request body:
        {"request": {
          "apiCollectionId": 1747033350
        }}
        """)
    public String fetchApiInfosForCollection(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchApiInfosForCollection", request);
    }

    @Tool(name = "fetchTestContent", description = """
        Retrieves the content of a specific test by its originalTestId.
        
        Example request body:
        {"request": {
          "originalTestId": "APACHE_APISIX_RCE"
        }}
        """)
    public String fetchTestContent(FetchTestContentRequest request) {
        return getResponseFromAkto("api/fetchTestContent", request);
    }

    @Tool(name = "fetchTestRoles", description = """
        Retrieves all test roles available in the system.
        
        Example request body:
        {}
        """)
    public String fetchTestRoles() {
        return getResponseFromAkto("api/fetchTestRoles", null);
    }

    @Tool(name = "fetchSubTypeCountMap", description = """
        Retrieves a count map of subtypes for endpoints over a specified time period.
        
        Example request body:
        {"request": {
          "endTimestamp": 1747032698,
          "startTimestamp": 0
        }}
        """)
    public String fetchSubTypeCountMap(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchSubTypeCountMap", request);
    }

    @Tool(name = "getAllUsersCollections", description = """
        Retrieves all user collections in the system.
        
        Example request body:
        {}
        """)
    public String getAllUsersCollections() {
        return getResponseFromAkto("api/getAllUsersCollections", null);
    }

    @Tool(name = "getAllTestsCountMap", description = """
        Retrieves a count map of all tests over a specified time period.
        
        Example request body:
        {"request": {
          "endTimestamp": 1778658008,
          "startTimestamp": 0
        }}
        """)
    public String getAllTestsCountMap(Map<String, Object> request) {
        return getResponseFromAkto("api/getAllTestsCountMap", request);
    }

    @Tool(name = "fetchNewEndpointsTrendForNonHostCollections", description = """
        Retrieves trend data for new endpoints in non-host collections over a specified time period.
        
        Example request body:
        {"request": {
          "endTimestamp": 1747074599,
          "startTimestamp": 1741804200
        }}
        """)
    public String fetchNewEndpointsTrendForNonHostCollections(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchNewEndpointsTrendForNonHostCollections", request);
    }

/*    @Tool(name = "bulkUpdateIssueStatus", description = """
        Updates the status of multiple issues in bulk. Useful for mass issue management and status updates.
        
        Example request body:
        {}
        """)
    public String bulkUpdateIssueStatus() {
        return getResponseFromAkto("api/bulkUpdateIssueStatus", null);
    }*/

/*    @Tool(name = "bulkCreateJiraTickets", description = """
        Creates multiple Jira tickets in bulk for selected issues. Useful for mass ticket creation and integration management.
        
        Example request body:
        {"request": {
          "issueType": 10035,
          "projId": "NAYAN",
          "issuesIds": [
            {
              "testSubCategory": "JWT_HEADER_PARAM_INJECTION_KID",
              "testErrorSource": "AUTOMATED_TESTING",
              "testCategoryFromSourceConfig": null,
              "apiInfoKey": {
                "method": "GET",
                "apiCollectionId": 1111111111,
                "url": "https://vulnerable-server.akto.io/api/college/dashboard/home"
              },
              "testSourceConfig": null
            }
          ],
          "aktoDashboardHost": "https://app.akto.io"
        }}
        """)
    public String bulkCreateJiraTickets(Map<String, Object> request) {
        return getResponseFromAkto("api/bulkCreateJiraTickets", request);
    }*/

    @Tool(name = "fetchIntegration", description = """
        POST /api/fetchIntegration
        Example request body:
        {}
        """)
    public String fetchIntegration() {
        return getResponseFromAkto("api/fetchIntegration", Collections.emptyMap());
    }

    @Tool(name = "fetchVulnerableTestingRunResultsFromIssues", description = """
        POST /api/fetchVulnerableTestingRunResultsFromIssues
        Example request body:
        {"request": {
          "activeCollections": true,
          "endTimeStamp": 1778571718,
          "filterStatus": ["OPEN"],
          "skip": 0,
          "startEpoch": 0,
          "issuesIds": [
            {
              "testSubCategory": "JWT_HEADER_PARAM_INJECTION_KID",
              "testErrorSource": "AUTOMATED_TESTING",
              "testCategoryFromSourceConfig": null,
              "apiInfoKey": {
                "method": "GET",
                "apiCollectionId": 1111111111,
                "url": "https://vulnerable-server.akto.io/api/college/dashboard/home"
              },
              "testSourceConfig": null
            }
          ]
        }}
        """)
    public String fetchVulnerableTestingRunResultsFromIssues(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchVulnerableTestingRunResultsFromIssues", request);
    }

    @Tool(name = "getCustomerEndpoints", description = """
        POST /api/getCustomerEndpoints
        Example request body:
        {}
        """)
    public String getCustomerEndpoints() {
        return getResponseFromAkto("api/getCustomerEndpoints", Collections.emptyMap());
    }

    @Tool(name = "getSeveritiesCountPerCollection", description = """
        POST /api/getSeveritiesCountPerCollection
        Example request body:
        {"request": {
          "apiCollectionId": 1747033350
        }}
        """)
    public String getSeveritiesCountPerCollection(Map<String, Object> request) {
        return getResponseFromAkto("api/getSeveritiesCountPerCollection", request);
    }

    @Tool(name = "fetchCodeAnalysisApiInfos", description = """
        POST /api/fetchCodeAnalysisApiInfos
        Example request body:
        {"request": {
          "apiCollectionId": 1747033350
        }}
        """)
    public String fetchCodeAnalysisApiInfos(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchCodeAnalysisApiInfos", request);
    }

    @Tool(name = "fetchTestRunResultsCount", description = """
        POST /api/fetchTestRunResultsCount
        Example request body:
        {"request": {
          "testingRunResultSummaryHexId": "6821a176992b895372dc1c0d"
        }}
        """)
    public String fetchTestRunResultsCount(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchTestRunResultsCount", request);
    }

/*    @Tool(name = "modifyTestingRunConfig", description = """
        POST /api/modifyTestingRunConfig
        Example request body:
        {"request": {
          "editableTestingRunConfig": {
            "continuousTesting": false,
            "autoTicketingDetails": {
              "issueType": "Bug",
              "shouldCreateTickets": true,
              "projectId": "NAYAN",
              "severities": ["HIGH"]
            },
            "sendMsTeamsAlert": false,
            "testSubCategoryList": ["ID_WRAP_ARRAY_OF_PARAMS_JSON_BODY_INTEGER_VAL"],
            "maxConcurrentRequests": -1,
            "recurringDaily": false,
            "overriddenTestAppUrl": "",
            "sendSlackAlert": false,
            "scheduleTimestamp": 0,
            "recurringWeekly": false,
            "testRunTime": -1,
            "testingRunHexId": "6821a172934b8e3c4f933658",
            "recurringMonthly": false,
            "testRoleId": ""
          },
          "testingRunConfigId": 8236799
        }}
        """)
    public String modifyTestingRunConfig(Map<String, Object> request) {
        return getResponseFromAkto("api/modifyTestingRunConfig", request);
    }*/

    @Tool(name = "updateIssueDescription", description = """
        POST /api/updateIssueDescription
        Example request body:
        {"request": {
          "issueId": {
            "testSubCategory": "JWT_NONE_ALGO",
            "testErrorSource": "AUTOMATED_TESTING",
            "testCategoryFromSourceConfig": null,
            "apiInfoKey": {
              "method": "GET",
              "apiCollectionId": 1111111111,
              "url": "https://vulnerable-server.akto.io/api/college/student-details"
            },
            "testSourceConfig": null
          },
          "description": "test"
        }}
        """)
    public String updateIssueDescription(Map<String, Object> request) {
        return getResponseFromAkto("api/updateIssueDescription", request);
    }

/*    @Tool(name = "getTeamData", description = """
        POST /api/getTeamData
        Example request body:
        {}
        """)
    public String getTeamData() {
        return getResponseFromAkto("api/getTeamData", Collections.emptyMap());
    }*/

    @Tool(name = "fetchNewEndpointsTrendForHostCollections", description = """
        POST /api/fetchNewEndpointsTrendForHostCollections
        Example request body:
        {"request": {
          "endTimestamp": 1747074599,
          "startTimestamp": 1741804200
        }}
        """)
    public String fetchNewEndpointsTrendForHostCollections(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchNewEndpointsTrendForHostCollections", request);
    }

    @Tool(name = "fetchTestRunResultDetails", description = """
        POST /api/fetchTestRunResultDetails
        Example request body:
        {"request": {
          "testingRunResultHexId": "6821a5ad4eadbb6d7ca83d76"
        }}
        """)
    public String fetchTestRunResultDetails(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchTestRunResultDetails", request);
    }

    @Tool(name = "getLastSeenTrafficInfoForCollections", description = """
        POST /api/getLastSeenTrafficInfoForCollections
        Example request body:
        {}
        """)
    public String getLastSeenTrafficInfoForCollections() {
        return getResponseFromAkto("api/getLastSeenTrafficInfoForCollections", Collections.emptyMap());
    }

    @Tool(name = "fetchAffectedEndpoints", description = """
        POST /api/fetchAffectedEndpoints
        Example request body:
        {"request": {
          "issueId": {
            "testSubCategory": "JWT_HEADER_PARAM_INJECTION_KID",
            "testErrorSource": "AUTOMATED_TESTING",
            "testCategoryFromSourceConfig": null,
            "apiInfoKey": {
              "method": "GET",
              "apiCollectionId": 1111111111,
              "url": "https://vulnerable-server.akto.io/api/college/student-details"
            },
            "testSourceConfig": null
          }
        }}
        """)
    public String fetchAffectedEndpoints(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchAffectedEndpoints", request);
    }

    @Tool(name = "findTotalIssues", description = """
        POST /api/findTotalIssues
        Example request body:
        {"request": {
          "startTimeStamp": 1746946142,
          "endTimeStamp": 1747032542
        }}
        """)
    public String findTotalIssues(Map<String, Object> request) {
        return getResponseFromAkto("api/findTotalIssues", request);
    }

    @Tool(name = "getSensitiveInfoForCollections", description = """
        POST /api/getSensitiveInfoForCollections
        Example request body:
        {}
        """)
    public String getSensitiveInfoForCollections() {
        return getResponseFromAkto("api/getSensitiveInfoForCollections", Collections.emptyMap());
    }

    @Tool(name = "getRiskScoreInfo", description = """
        POST /api/getRiskScoreInfo
        Example request body:
        {}
        """)
    public String getRiskScoreInfo() {
        return getResponseFromAkto("api/getRiskScoreInfo", Collections.emptyMap());
    }

    @Tool(name = "getIssueSummaryInfo", description = """
        POST /api/getIssueSummaryInfo
        Example request body:
        {"request": {
          "endTimestamp": 1778658008,
          "startTimestamp": 0
        }}
        """)
    public String getIssueSummaryInfo(Map<String, Object> request) {
        return getResponseFromAkto("api/getIssueSummaryInfo", request);
    }

    @Tool(name = "fetchTestingRunResultSummaries", description = """
        POST /api/fetchTestingRunResultSummaries
        Example request body:
        {"request": {
          "testingRunHexId": "6821a172934b8e3c4f933658",
          "endTimestamp": 0,
          "startTimestamp": 0
        }}
        """)
    public String fetchTestingRunResultSummaries(Map<String, Object> request) {
        return getResponseFromAkto("api/fetchTestingRunResultSummaries", request);
    }

   /* @Tool(name = "generateReportPDF", description = """
        POST /api/generateReportPDF
        Example request body:
        {"request": {
          "issuesIdsForReport": [
            {
              "testSubCategory": "JWT_HEADER_PARAM_INJECTION_KID",
              "testErrorSource": "AUTOMATED_TESTING",
              "testCategoryFromSourceConfig": null,
              "apiInfoKey": {
                "method": "GET",
                "apiCollectionId": 1111111111,
                "url": "https://vulnerable-server.akto.io/api/college/dashboard/home"
              },
              "testSourceConfig": null
            }
          ],
          "reportFilterList": {
            "activeCollections": ["true"],
            "endTimeStamp": [1778571718],
            "filterStatus": ["OPEN"],
            "startEpoch": [0]
          }
        }}
        """)
    public String generateReportPDF(Map<String, Object> request) {
        return getResponseFromAkto("api/generateReportPDF", request);
    }*/

    @Tool(name = "checkIfDependencyGraphAvailable", description = """
        POST /api/checkIfDependencyGraphAvailable
        Example request body:
        {"request": {
          "method": "GET",
          "apiCollectionId": 1744008475,
          "url": "https://juiceshop.akto.io/rest/user/whoami"
        }}
        """)
    public String checkIfDependencyGraphAvailable(Map<String, Object> request) {
        return getResponseFromAkto("api/checkIfDependencyGraphAvailable", request);
    }

    @Tool(name = "getCoverageInfoForCollections", description = """
        POST /api/getCoverageInfoForCollections
        Example request body:
        {}
        """)
    public String getCoverageInfoForCollections() {
        return getResponseFromAkto("api/getCoverageInfoForCollections", Collections.emptyMap());
    }

    private String getResponseFromAkto(String path, Object request) {
        try {
            if (request == null) {
                request = Collections.emptyMap();
            }
            return apiProcessor.processRequest(path, request, String.class, HttpMethod.POST);
        } catch (Exception e) {
            log.error("Error calling API: {}", e.getMessage(), e);
            throw e;
        }
    }

}
