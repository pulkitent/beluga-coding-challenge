package com.otto.beluga.domain.usecase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StringReverseUseCaseImplTest {
  @InjectMocks
  private StringReverseUseCaseImpl stringReverseUseCase;

  @Test
  void testReverse_ShouldReturnAsReversedStringWhenBelugaIsGivenAsInput() {
    // Given
    String input = "Beluga";

    // When
    String result = stringReverseUseCase.reverse(input);

    // Then
    Assertions.assertEquals("aguleB", result);
  }
}
