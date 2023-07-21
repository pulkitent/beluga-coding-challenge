package com.otto.beluga.integration.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ApiTestSteps {

  @Value("${server.port}")
  private int port;

  private String baseUrl;
  private Response response;

  @Given("a server running at {string}")
  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  @When("I send a POST request to {string} with following JSON request body:")
  public void sendPostRequest(String endpoint, String requestBody) {
    response = given()
        .baseUri(baseUrl)
        .port(port)
        .contentType(ContentType.JSON)
        .body(requestBody)
        .when()
        .post(endpoint);
  }

  @Then("the response status code should be {int}")
  public void verifyStatusCode(int statusCode) {
    assertEquals(statusCode, response.getStatusCode());
  }
}
