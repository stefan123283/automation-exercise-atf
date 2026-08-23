package com.stefan.automation.managers;

import io.cucumber.java.Scenario;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ApiClient {

    private RequestSpecification requestSpecification;
    private final Map<String, String> formParametersMap = new HashMap<>();
    private Response response;
    private JsonPath jsonPath;
    private int apiRequestsCount;

    public static boolean isApiTest(Scenario scenario) {
        Collection<String> scenarioTagNamesCollection = scenario.getSourceTagNames();
        boolean isUiTagPresent = false;
        boolean isApiTagPresent = false;
        boolean isApiTest = false;
        for (String scenarioTagName : scenarioTagNamesCollection) {
            if (scenarioTagName.equalsIgnoreCase("@ui")) {
                isUiTagPresent = true;
            }
            if (scenarioTagName.equalsIgnoreCase("@api")) {
                isApiTagPresent = true;
            }
        }

        if (!isUiTagPresent && !isApiTagPresent) {
            throw new IllegalStateException("The \"" + scenario.getName() + "\" scenario should have either one \"ui\" or \"api\" tag!");
        } else if (isUiTagPresent && isApiTagPresent) {
            throw new IllegalStateException("The \"" + scenario.getName() + "\" scenario should have only one \"ui\" or \"api\" tag!");
        } else if (isApiTagPresent) {
            isApiTest = true;
        }
        return isApiTest;
    }

    public void userSendsRequestToUrl(String requestMethod, String url) {
        switch (requestMethod.toUpperCase()) {
            case "GET" -> {
                response = requestSpecification != null ? requestSpecification.when().get(url) : when().get(url);
                apiRequestsCount++;
            }
            case "POST" -> {
                response = requestSpecification != null ? requestSpecification.when().post(url) : when().post(url);
                apiRequestsCount++;
            }
            case "PUT" -> {
                response = requestSpecification != null ? requestSpecification.when().put(url) : when().put(url);
                apiRequestsCount++;
            }
            case "DELETE" -> {
                response = requestSpecification != null ? requestSpecification.when().delete(url) : when().delete(url);
                apiRequestsCount++;
            }
            default -> throw new IllegalArgumentException("Invalid request type specified!");
        }
        logResponseBody();
    }

    public void userPreparesRequestParameter(String requestParameter, String value) {
        formParametersMap.put(requestParameter, value);
        requestSpecification = given().formParams(formParametersMap);
    }

    public String getResponseBody() {
        return response.getBody().htmlPath().getString("body");
    }

    public void logResponseBody() {
        Log.debug("The response body of the request is: \n" + getResponseBody());
    }

    public JsonPath getJsonPathInstance() {
        if (jsonPath == null || apiRequestsCount > 1) {
            jsonPath = new JsonPath(getResponseBody());
        }
        return jsonPath;
    }

    public int getResponseCode() {
        return getJsonPathInstance().getInt("responseCode");
    }

    public String getResponseMessage() {
        return getJsonPathInstance().getString("message");
    }

    public void userPreparesRequestParametersForRegistration(String userName, String email, String password, String title,
                                                             String birthDay, String birthMonth, String birthYear, String firstName,
                                                             String lastName, String company, String address1, String address2,
                                                             String country, String zipCode, String state, String city, String mobileNumber) {
        userPreparesRequestParameter("name", userName);
        userPreparesRequestParameter("email", email);
        userPreparesRequestParameter("password", password);
        userPreparesRequestParameter("title", title);
        userPreparesRequestParameter("birth_date", birthDay);
        userPreparesRequestParameter("birth_month", birthMonth);
        userPreparesRequestParameter("birth_year", birthYear);
        userPreparesRequestParameter("firstname", firstName);
        userPreparesRequestParameter("lastname", lastName);
        userPreparesRequestParameter("company", company);
        userPreparesRequestParameter("address1", address1);
        userPreparesRequestParameter("address2", address2);
        userPreparesRequestParameter("country", country);
        userPreparesRequestParameter("zipcode", zipCode);
        userPreparesRequestParameter("state", state);
        userPreparesRequestParameter("city", city);
        userPreparesRequestParameter("mobile_number", mobileNumber);
    }

}
