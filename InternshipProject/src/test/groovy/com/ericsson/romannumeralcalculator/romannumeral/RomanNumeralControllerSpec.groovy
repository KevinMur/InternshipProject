package com.ericsson.romannumeralcalculator.romannumeral

import static org.mockito.BDDMockito.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc

import com.ericsson.romannumeralcalculator.exceptions.ValidationException

import spock.lang.Specification

@WebMvcTest(RomanNumeralController.class)
class RomanNumeralControllerSpec extends Specification{

    @MockBean
    private RomanNumeralCalculatorService calculator

    @Autowired
    private MockMvc mockMvc

    def "Controller should return ok status for addition AND valid response content"() {
        given: "calculator will return valid roman numeral object"
        def numeral = new RomanNumeral()
        numeral.setNumeralValue("II")
        given(calculator.add("I+I")).willReturn(numeral)

        when: "controller recieves a request to carry out an addition"
        def response = mockMvc.perform(get("/calculator/add").param("numeralExpression", "I+I").contentType(MediaType.APPLICATION_JSON))

        then: "status Ok should be returned with valid JSON content"
        response.andExpect(status().isOk()).andExpect(content().json("{'numeralValue' : 'II'}"))
    }

    def "Controller should return bad request status for addition"(){
        given: "calculator will throw exception"
        doThrow(ValidationException.class).when(calculator).add("I+6")

        when: "controller recieves a request to carry out an addition"
        def response = mockMvc.perform(get("/calculator/add").param("numeralExpression", "I+6").contentType(MediaType.APPLICATION_JSON))

        then: "status Bad Request should be returned"
        response.andExpect(status().isBadRequest())
    }

    def "Controller should return ok status for subtraction and valid response content"() {
        given: "calculator will return valid roman numeral object"
        def numeral = new RomanNumeral()
        numeral.setNumeralValue("IV")
        given(calculator.subtract("V-I")).willReturn(numeral)

        when: "controller recieves a request to carry out a subtraction"
        def response = mockMvc.perform(get("/calculator/subtract").param("numeralExpression", "V-I").contentType(MediaType.APPLICATION_JSON))

        then: "status Ok should be returned with valid JSON content"
        response.andExpect(status().isOk()).andExpect(content().json("{'numeralValue' : 'IV'}"))
    }

    def "Controller should return bad request status for subtraction"(){
        given: "calculator will throw exception"
        doThrow(ValidationException.class).when(calculator).subtract("X-6")

        when: "controller recieves a request to carry out an subtraction"
        def response = mockMvc.perform(get("/calculator/subtract").param("numeralExpression", "X-6").contentType(MediaType.APPLICATION_JSON))

        then: "status Bad Request should be returned"
        response.andExpect(status().isBadRequest())
    }

    def "Controller should return ok status for multiplication and valid response content"() {
        given: "calculator will return valid roman numeral object"
        def numeral = new RomanNumeral()
        numeral.setNumeralValue("X")
        given(calculator.multiply("V*II")).willReturn(numeral)

        when: "controller recieves a request to carry out a multiplication"
        def response = mockMvc.perform(get("/calculator/multiply").param("numeralExpression", "V*II").contentType(MediaType.APPLICATION_JSON))

        then: "status Ok should be returned with valid JSON content"
        response.andExpect(status().isOk()).andExpect(content().json("{'numeralValue' : 'X'}"))
    }

    def "Controller should return bad request status for multiplication"(){
        given: "calculator will throw exception"
        doThrow(ValidationException.class).when(calculator).multiply("X*6")

        when: "controller recieves a request to carry out a multiplication"
        def response = mockMvc.perform(get("/calculator/multiply").param("numeralExpression", "X*6").contentType(MediaType.APPLICATION_JSON))

        then: "status Bad Request should be returned"
        response.andExpect(status().isBadRequest())
    }

    def "Controller should return ok status for division and valid response content"() {
        given: "calculator will return valid roman numeral object"
        def numeral = new RomanNumeral()
        numeral.setNumeralValue("IV")
        given(calculator.divide("VIII/II")).willReturn(numeral)

        when: "controller recieves a request to carry out a division"
        def response = mockMvc.perform(get("/calculator/divide").param("numeralExpression", "VIII/II").contentType(MediaType.APPLICATION_JSON))

        then: "status Ok should be returned with valid JSON content"
        response.andExpect(status().isOk()).andExpect(content().json("{'numeralValue' : 'IV'}"))
    }

    def "Controller should return bad request status for division"(){
        given: "calculator will throw exception"
        doThrow(ValidationException.class).when(calculator).divide("X/6")

        when: "controller recieves a request to carry out an addition"
        def response = mockMvc.perform(get("/calculator/divide").param("numeralExpression", "X/6").contentType(MediaType.APPLICATION_JSON))

        then: "status Bad Request should be returned"
        response.andExpect(status().isBadRequest())
    }

    def "Controller should return bad request status for internal server error"(){
        given: "calculator will throw exception"
        doThrow(ArithmeticException.class).when(calculator).add("")

        when: "controller recieves a request to carry out an addition"
        def response = mockMvc.perform(get("/calculator/add").param("numeralExpression", "").contentType(MediaType.APPLICATION_JSON))

        then: "status Bad Request should be returned"
        response.andExpect(status().isInternalServerError())
    }
}
