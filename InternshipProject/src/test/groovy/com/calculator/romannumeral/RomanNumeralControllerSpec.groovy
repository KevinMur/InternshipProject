package com.calculator.romannumeral

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import com.calculator.exceptions.ValidationException
import com.calculator.romannumeral.RomanNumeralController
import com.calculator.utils.OperationAdd
import com.calculator.utils.RomanNumeralConverter
import com.calculator.utils.RomanNumeralValidator

import spock.lang.Specification
import spock.lang.Unroll
import org.springframework.http.MediaType
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.mockito.BDDMockito.*

@WebMvcTest
class RomanNumeralControllerSpec extends Specification{
 
    @MockBean
    private CalculatorService calculator
	
    @Autowired
    private MockMvc mockMvc
	
    def "Controller should return a valid roman numeral object after a valid request as been made"() {
        given: "two valid numeral to be entered"
            def numeralOne = "I"
            def numeralTwo = "I"
         and: "a valid numeral object is going to be returned from the calculator service"
            def validNumeral = new RomanNumeral()
            validNumeral.setRequestSuccess(true)
            validNumeral.setNumeralValue("II")
             calculator.add(numeralOne, numeralTwo) >> validNumeral
        when: "controller recieves a request to carry out an addition"
            def response = mockMvc.perform(get("/add").param("numeralOne", numeralOne).
                                   param("numeralTwo", numeralTwo).contentType(MediaType.APPLICATION_JSON))
        then: "status Ok should be returned"
            response.andExpect(status().isOk())//.andExpect(content().json("{'numeralValue':'II', 'requestsuccess':true}"))
    }
    
    def "Controller should return an error due to a numeral entered failing validation"(){
        given: "a valid and invalid numeral to be entered"
            def numeralOne = "5I"
            def numeralTwo = "I"
        and: "a valid numeral object is going to be returned from the calculator service"
            def validNumeral = new RomanNumeral()
            validNumeral.setRequestSuccess(false)
            doThrow(ValidationException.class).when(calculator).add(numeralOne, numeralTwo)
        when: "controller recieves a request to carry out an addition"
            def response = mockMvc.perform(get("/add").param("numeralOne", numeralOne).
                               param("numeralTwo", numeralTwo).contentType(MediaType.APPLICATION_JSON))
        then: "status Ok should be returned"
            response.andExpect(status().isBadRequest())//.andExpect(content().json("{'numeralValue':'II', 'requestsuccess':true}"))
    }
}
