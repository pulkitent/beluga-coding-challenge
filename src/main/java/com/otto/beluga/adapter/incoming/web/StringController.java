package com.otto.beluga.adapter.incoming.web;

import com.otto.beluga.adapter.incoming.web.request.StringReverseRequest;
import com.otto.beluga.adapter.incoming.web.response.StringReverseResponse;
import com.otto.beluga.adapter.incoming.web.validator.StringValidator;
import com.otto.beluga.port.incoming.IStringReverseUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.Boolean.FALSE;

@RestController
@RequestMapping("/apis/v1/strings")
@Tag(name = "String manipulation APIs")
public class StringController {
  private final IStringReverseUseCase stringReverseUseCase;

  private static final String BAD_REQUEST_ERROR_MESSAGE = "Request body is incorrect";
  private static final Logger LOGGER = LoggerFactory.getLogger(StringController.class);

  @Autowired
  public StringController(IStringReverseUseCase stringReverseUseCase) {
    this.stringReverseUseCase = stringReverseUseCase;
  }

  @PostMapping("/reverse")
  @ResponseStatus(HttpStatus.OK)
  @Operation(description = "Reverse a given string", method = "POST")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "Success scenario"),
      @ApiResponse(responseCode = "400", description = "Bad request scenario")
  })
  public ResponseEntity<StringReverseResponse<String>> reverse(@RequestBody StringReverseRequest stringReverseRequest) {
    LOGGER.info("reverse request received for: {}", stringReverseRequest.getInput());

    if (FALSE.equals(StringValidator.isValid(stringReverseRequest))) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(new StringReverseResponse<>(null, BAD_REQUEST_ERROR_MESSAGE, false));
    }

    String reversedString = stringReverseUseCase.reverse(stringReverseRequest.getInput());
    return ResponseEntity.status(HttpStatus.OK)
        .body(new StringReverseResponse<>(reversedString, "", true));
  }
}
