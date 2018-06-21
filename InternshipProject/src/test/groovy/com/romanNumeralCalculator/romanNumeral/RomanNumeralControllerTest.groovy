package com.romanNumeralCalculator.romanNumeral

import static org.junit.Assert.*

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
import com.romanNumeralCalculator.romanNumeral.RomanNumeralController
import com.romanNumeralCalculator.utils.RomanNumeralValidator

import spock.lang.Specification
import spock.lang.Unroll
import org.springframework.http.MediaType
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.mockito.BDDMockito.*

@WebMvcTest
class RomanNumeralControllerTest extends Specification{
 
	@MockBean
	RomanNumeralValidator validator
	
	@Autowired
	private MockMvc mockMvc
	
	def numeralOne, numeralTwo, status, numeralOneValidation, numeralTwoValidation
	
	@Unroll
	def "Controller should return #status when roman numerals #numeralOne and #numeralTwo are passed"(){
		given:
			given(validator.validate(numeralOne)).willReturn(numeralOneValidation)
			given(validator.validate(numeralTwo)).willReturn(numeralTwoValidation)
		when: "controller recieves a request to carry out an addition"
			def response = mockMvc.perform(get("/add").
										  param("numeralOne", numeralOne).
										  param("numeralTwo", numeralTwo).
										  contentType(MediaType.APPLICATION_JSON))
			
		then: "status Ok should be returned"		
			response.andExpect(status)
		where:
			numeralOne	|	numeralTwo		|		status					| 	numeralOneValidation	|	numeralTwoValidation
				"I"		| 		"I"			|		status().isOk()			|			true			|		true
				"I"		| 		"A"			|		status().isBadRequest()	|			true			|		false
				"A"		| 		"A"			|		status().isBadRequest()	|			false			|		false
		
	}
}
