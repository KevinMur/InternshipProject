package steps;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ericsson.romannumeralcalculator.romannumeral.RomanNumeral;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculatorSteps extends SpringBootBaseIT {

    private ResponseEntity<RomanNumeral> romanNumeralResponse;

    /**
     * @param operation
     *            the operation that is being carried out e.g add, subtract...
     * @param expression
     *            the roman numeral expression that si going to be validated
     * @throws UnsupportedEncodingException
     *             exception thrown by URL encoder in SpringBootBaseIT
     * @throws InterruptedException
     *             exception throw by sleep method
     * 
     *             The reason Thread.sleep is used in this tests is without it the TCP request sent by the tests will not be accepted by the docker
     *             container as the port on the docker container would not be open yet.
     */
    @When("^the user enters a \"([^\"]*)\" operation with the expression \"([^\"]*)\"$")
    public void the_user_enters_a_operation_with_the_expression(final String operation, final String expression)
            throws UnsupportedEncodingException, InterruptedException {
        Thread.sleep(4000);
        romanNumeralResponse = get(operation, expression);

    }

    @Then("^the user recieves a HTTP OK response$")
    public void the_user_recieves_a_HTTP_OK_response() {
        assertEquals(HttpStatus.OK, romanNumeralResponse.getStatusCode());
    }

    @And("^a valid Roman Numeral response is returned with the correct numeral value \"([^\"]*)\"$")
    public void a_valid_Roman_Numeral_response_is_returned_with_the_correct_numeral_value(final String expectedNumeralResult) {
        assertEquals(expectedNumeralResult, romanNumeralResponse.getBody().getNumeralValue());
    }
}