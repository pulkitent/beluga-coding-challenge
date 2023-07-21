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