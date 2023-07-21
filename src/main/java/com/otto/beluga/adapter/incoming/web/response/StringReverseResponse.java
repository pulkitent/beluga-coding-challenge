package com.otto.beluga.adapter.incoming.web.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StringReverseResponse<T> {
  @JsonProperty("data")
  T data;

  @JsonProperty("errorMessage")
  String errorMessage;

  @JsonProperty("success")
  Boolean isSuccess;
}
