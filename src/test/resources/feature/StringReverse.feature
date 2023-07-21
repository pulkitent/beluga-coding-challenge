Feature: Reverse a string

  Scenario: As a user I should be able to reverse a string successfully and receive HTTP status as 200
    Given a server running at "http://localhost"
    When I send a POST request to "/apis/v1/strings/reverse" with following JSON request body:
    """
    {
      "input": "pulkit"
    }
    """
    Then the response status code should be 200

  Scenario: As a user I want should not able to reverse string when request body is empty and receive HTTP status as 400
    Given a server running at "http://localhost"
    When I send a POST request to "/apis/v1/strings/reverse" with following JSON request body:
    """
    {

    }
    """
    Then the response status code should be 400