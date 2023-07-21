package com.otto.beluga.adapter.incoming.web.validator;

import com.otto.beluga.adapter.incoming.web.request.StringReverseRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringValidatorTest {

  @Test
  void testIsValid_ShouldReturnFalseWhenRequestObjectIsNull() {
    // Given
    StringReverseRequest stringReverseRequest = null;

    // When
    Boolean result = StringValidator.isValid(stringReverseRequest);

    // Then
    Assertions.assertFalse(result);
  }

  @Test
  void testIsValid_ShouldReturnFalseWhenInputInRequestObjectIsNull() {
    // Given
    StringReverseRequest stringReverseRequest = new StringReverseRequest();

    // When
    Boolean result = StringValidator.isValid(stringReverseRequest);

    // Then
    Assertions.assertFalse(result);
  }

  @Test
  void testIsValid_ShouldReturnTrueWhenRequestIsValid() {
    // Given
    StringReverseRequest stringReverseRequest = new StringReverseRequest();
    stringReverseRequest.setInput("pulkit");

    // When
    Boolean result = StringValidator.isValid(stringReverseRequest);

    // Then
    Assertions.assertTrue(result);
  }
}
