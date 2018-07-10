package steps;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ericsson.romannumeralcalculator.romannumeral.RomanNumeral;

/**
 * @author ekvumer
 *
 *         Web Request This class is used by integration tests to send a get request to the application
 *
 */
public class WebRequest {

    private static final String SERVER_URL = "http://localhost:8080";
    private static final String CALCULATOR_ENDPOINT = "/calculator";

    private static RestTemplate restTemplate = new RestTemplate();

    private WebRequest() {
    }

    private static String calculatorEndpoint() {
        return SERVER_URL + CALCULATOR_ENDPOINT;
    }

    /**
     * @param operation
     *            The mathematical operation that this request will carry out
     * @param romanNumeralExpression
     *            The roman numeral expression that is going to be evaluated by this request
     * @return
     * @throws UnsupportedEncodingException
     *             Exception thrown if invalid encoding type is entered into URL Encoder
     */
    public static ResponseEntity<RomanNumeral> get(final String operation, final String romanNumeralExpression) throws UnsupportedEncodingException {
        return restTemplate.getForEntity(
                calculatorEndpoint() + "/" + operation + "?numeralExpression=" + URLEncoder.encode(romanNumeralExpression, "UTF-8"),
                RomanNumeral.class);
    }
}
