package com.otto.beluga.domain.usecase;

import com.otto.beluga.port.incoming.IStringReverseUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class StringReverseUseCaseImpl implements IStringReverseUseCase {
  private static final Logger LOGGER = LoggerFactory.getLogger(StringReverseUseCaseImpl.class);

  @Override
  public String reverse(String input) {
    String reversedString = new StringBuilder(input).reverse().toString();
    LOGGER.info("reversed string: {}", reversedString);

    return reversedString;
  }
}
