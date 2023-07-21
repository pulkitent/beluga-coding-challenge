package com.otto.beluga.adapter.incoming.web.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StringReverseRequest {
  @JsonProperty("input")
  String input;
}
