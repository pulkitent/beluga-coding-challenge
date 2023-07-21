package com.otto.beluga.adapter.incoming.web.validator;

import com.otto.beluga.adapter.incoming.web.request.StringReverseRequest;

import java.util.Objects;

public class StringValidator {
  private StringValidator() {
    // To avoid instantiating a utility class
  }

  public static Boolean isValid(StringReverseRequest stringReverseRequest) {
    if (Objects.isNull(stringReverseRequest)) {
      return false;
    }
    return !Objects.isNull(stringReverseRequest.getInput());
  }
}
