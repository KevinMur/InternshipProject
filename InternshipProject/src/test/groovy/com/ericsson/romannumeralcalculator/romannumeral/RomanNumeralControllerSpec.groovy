package com.ericsson.romannumeralcalculator.romannumeral

import static org.mockito.BDDMockito.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc

import com.ericsson.romannumeralcalculator.exceptions.ValidationException

import spock.lang.Specification

@WebMvcTest
class RomanNumeralControllerSpec extends Specification{

    @MockBean
    private RomanNumeralCalculatorService calculator

    @Autowired
    private MockMvc mockMvc

    def "Controller should return ok status"() {
        given: "calclator service returns result of addition.."
        def validNumeral = new RomanNumeral()
        validNumeral.setNumeralValue("II")
        calculator.calculate(_ as String, _ as String, _ as String) >>> validNumeral

        when: "controller recieves a request to carry out an addition"
        def response = mockMvc.perform(get("/calculator").param("numeralOne", "I").
                param("numeralTwo", "I").param("operation", "ADD").contentType(MediaType.APPLICATION_JSON))


        then: "status Ok should be returned"
        response.andExpect(status().isOk())
    }

    def "Controller should return bad request status "(){
        given: "calculator will throw exception"
        doThrow(ValidationException.class).when(calculator).calculate(_ as String, _ as String, _ as String)

        when: "controller recieves a request to carry out an addition"
        def response = mockMvc.perform(get("/calculator").param("numeralOne", _ as String).
                param("numeralTwo", _ as String).param("operation", _ as String).contentType(MediaType.APPLICATION_JSON))

        then: "status Bad Request should be returned"
        response.andExpect(status().isBadRequest())
    }
}
