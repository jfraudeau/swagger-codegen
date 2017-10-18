package io.swagger.api;


import java.math.BigDecimal;
import io.swagger.model.Client;
import org.threeten.bp.LocalDate;
import org.threeten.bp.OffsetDateTime;
import io.swagger.model.OuterComposite;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class FakeApiController implements FakeApi {

    private static final Logger log = LoggerFactory.getLogger(FakeApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public FakeApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Boolean> fakeOuterBooleanSerialize(@ApiParam(value = "Input boolean as post body"  )  @Valid @RequestBody Boolean body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Boolean>(objectMapper.readValue("{ }", Boolean.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Boolean>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<OuterComposite> fakeOuterCompositeSerialize(@ApiParam(value = "Input composite as post body"  )  @Valid @RequestBody OuterComposite body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<OuterComposite>(objectMapper.readValue("{  \"my_string\" : { },  \"my_number\" : { },  \"my_boolean\" : { }}", OuterComposite.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<OuterComposite>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<OuterComposite>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<BigDecimal> fakeOuterNumberSerialize(@ApiParam(value = "Input number as post body"  )  @Valid @RequestBody BigDecimal body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<BigDecimal>(objectMapper.readValue("{ }", BigDecimal.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<BigDecimal>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<BigDecimal>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<String> fakeOuterStringSerialize(@ApiParam(value = "Input string as post body"  )  @Valid @RequestBody String body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<String>(objectMapper.readValue("{ }", String.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<String>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Client> testClientModel(@ApiParam(value = "client model" ,required=true )  @Valid @RequestBody Client body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Client>(objectMapper.readValue("{  \"client\" : \"client\"}", Client.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Client>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Client>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> testEndpointParameters(@ApiParam(value = "None", required=true) @RequestPart(value="number", required=true)  BigDecimal number,@ApiParam(value = "None", required=true) @RequestPart(value="double", required=true)  Double _double,@ApiParam(value = "None", required=true) @RequestPart(value="pattern_without_delimiter", required=true)  String patternWithoutDelimiter,@ApiParam(value = "None", required=true) @RequestPart(value="byte", required=true)  byte[] _byte,@ApiParam(value = "None") @RequestPart(value="integer", required=false)  Integer integer,@ApiParam(value = "None") @RequestPart(value="int32", required=false)  Integer int32,@ApiParam(value = "None") @RequestPart(value="int64", required=false)  Long int64,@ApiParam(value = "None") @RequestPart(value="float", required=false)  Float _float,@ApiParam(value = "None") @RequestPart(value="string", required=false)  String string,@ApiParam(value = "None") @RequestPart(value="binary", required=false)  byte[] binary,@ApiParam(value = "None") @RequestPart(value="date", required=false)  LocalDate date,@ApiParam(value = "None") @RequestPart(value="dateTime", required=false)  OffsetDateTime dateTime,@ApiParam(value = "None") @RequestPart(value="password", required=false)  String password,@ApiParam(value = "None") @RequestPart(value="callback", required=false)  String paramCallback) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> testEnumParameters(@ApiParam(value = "Form parameter enum test (string array)", allowableValues=">, $") @RequestPart(value="enum_form_string_array", required=false)  List<String> enumFormStringArray,@ApiParam(value = "Form parameter enum test (string)", allowableValues="_abc, -efg, (xyz)", defaultValue="-efg") @RequestPart(value="enum_form_string", required=false)  String enumFormString,@ApiParam(value = "Header parameter enum test (string array)" , allowableValues=">, $") @RequestHeader(value="enum_header_string_array", required=false) Optional<List<String>> enumHeaderStringArray,@ApiParam(value = "Header parameter enum test (string)" , allowableValues="_abc, -efg, (xyz)", defaultValue="-efg") @RequestHeader(value="enum_header_string", required=false) Optional<String> enumHeaderString,@ApiParam(value = "Query parameter enum test (string array)", allowableValues = ">, $") @Valid @RequestParam(value = "enum_query_string_array", required = false) Optional<List<String>> enumQueryStringArray,@ApiParam(value = "Query parameter enum test (string)", allowableValues = "_abc, -efg, (xyz)", defaultValue = "-efg") @Valid @RequestParam(value = "enum_query_string", required = false, defaultValue="-efg") Optional<String> enumQueryString,@ApiParam(value = "Query parameter enum test (double)", allowableValues = "1, -2") @Valid @RequestParam(value = "enum_query_integer", required = false) Optional<Integer> enumQueryInteger,@ApiParam(value = "Query parameter enum test (double)", allowableValues="1.1, -1.2") @RequestPart(value="enum_query_double", required=false)  Double enumQueryDouble) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> testInlineAdditionalProperties(@ApiParam(value = "request body" ,required=true )  @Valid @RequestBody Object param) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> testJsonFormData(@ApiParam(value = "field1", required=true) @RequestPart(value="param", required=true)  String param,@ApiParam(value = "field2", required=true) @RequestPart(value="param2", required=true)  String param2) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
