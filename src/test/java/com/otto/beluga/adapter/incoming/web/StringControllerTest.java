package com.otto.beluga.adapter.incoming.web;

import com.otto.beluga.adapter.incoming.web.request.StringReverseRequest;
import com.otto.beluga.adapter.incoming.web.response.StringReverseResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class StringControllerTest {

  @InjectMocks
  private StringController stringController;

  @Test
  void testReverse_ShouldReturnHTTP200WhenInputInRequestIsNotNullAndIsValid() {
    // Given
    String input = "Pulkit";
    StringReverseRequest stringReverseRequest = new StringReverseRequest();
    stringReverseRequest.setInput(input);

    // When
    ResponseEntity<StringReverseResponse<String>> response = stringController.reverse(stringReverseRequest);

    // Then
    Assertions.assertNotNull(response);
    Assertions.assertNotNull(response.getBody());
    Assertions.assertEquals("tikluP", response.getBody().getData());
    Assertions.assertTrue(response.getBody().getIsSuccess());
    Assertions.assertEquals("", response.getBody().getErrorMessage());
    Assertions.assertEquals(200, response.getStatusCode().value());
  }

  @Test
  void testReverse_ShouldReturnHTTP400WhenInputInRequestIsNull() {
    // Given
    String input = null;
    StringReverseRequest stringReverseRequest = new StringReverseRequest();
    stringReverseRequest.setInput(input);

    // When
    ResponseEntity<StringReverseResponse<String>> response = stringController.reverse(stringReverseRequest);

    // Then
    Assertions.assertNotNull(response);
    Assertions.assertNotNull(response.getBody());
    Assertions.assertNull(response.getBody().getData());
    Assertions.assertFalse(response.getBody().getIsSuccess());
    Assertions.assertEquals("Request body is incorrect", response.getBody().getErrorMessage());
    Assertions.assertEquals(400, response.getStatusCode().value());
  }
}
