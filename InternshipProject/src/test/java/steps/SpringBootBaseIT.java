package steps;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ericsson.romannumeralcalculator.romannumeral.RomanNumeral;

public class SpringBootBaseIT {

    private final String SERVER_URL = "http://localhost:8080";
    private final String CALCULATOR_ENDPOINT = "/calculator";

    private final RestTemplate restTemplate = new RestTemplate();

    private String calculatorEndpoint() {
        return SERVER_URL + CALCULATOR_ENDPOINT;
    }

    public ResponseEntity<RomanNumeral> get(final String operation, final String romanNumeralExpression) throws UnsupportedEncodingException {
        //        final UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(calculatorEndpoint() + "/" + operation).queryParam("numeralExpression",
        //                romanNumeralExpression);
        //
        //        final String uri = builder.build().encode().toUriString();
        //        return new RestTemplate().getForEntity(uri, RomanNumeral.class);
        //        if (romanNumeralExpression.contains("+")) {
        //            romanNumeralExpression = romanNumeralExpression.replace("+", "%2B");
        //        }
        return restTemplate.getForEntity(
                calculatorEndpoint() + "/" + operation + "?numeralExpression=" + URLEncoder.encode(romanNumeralExpression, "UTF-8"),
                RomanNumeral.class);
    }
}
