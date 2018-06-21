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
import com.romanNumeralCalculator.utils.RomanNumeralConverter
import com.romanNumeralCalculator.utils.RomanNumeralValidator

import spock.lang.Specification
import spock.lang.Unroll
import org.springframework.http.MediaType
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.mockito.BDDMockito.*

@WebMvcTest
class RomanNumeralControllerTest extends Specification{
 
	@MockBean
	RomanNumeralValidator validator
	
	@MockBean
	RomanNumeralConverter converter
	
	@Autowired
	private MockMvc mockMvc
	
	def numeralOne, numeralTwo, numeralOneValue, numeralTwoValue, status, numeralOneValidation, numeralTwoValidation, jsonResponse, result
	
	@Unroll
	def "Controller should return #status when roman numerals #numeralOne and #numeralTwo are passed"(){
		given:
			given(validator.validate(numeralOne)).willReturn(numeralOneValidation)
			given(validator.validate(numeralTwo)).willReturn(numeralTwoValidation)
			given(converter.convertNumeralToNumber(numeralOne)).willReturn(numeralOneValue)
			given(converter.convertNumeralToNumber(numeralTwo)).willReturn(numeralOneValue)
			given(converter.convertNumberToNumeral(numeralOneValue + numeralTwoValue)).willReturn(result)
		when: "controller recieves a request to carry out an addition"
			def response = mockMvc.perform(get("/add").
										  param("numeralOne", numeralOne).
										  param("numeralTwo", numeralTwo).
										  contentType(MediaType.APPLICATION_JSON))
			
		then: "status Ok should be returned"		
			response.andExpect(status).andExpect(content().json(jsonResponse))
		where:
			numeralOne	|	numeralTwo	|	numeralOneValue	|	numeralTwoValue|	status					| 	numeralOneValidation	|	numeralTwoValidation	| 	jsonResponse														| result
				"I"		| 		"I"		|			1		| 			1	   |	status().isOk()			|			true			|		true				|	"{'numeralValue':'II', 'numericValue': 2, 'requestsuccess':true}"	|	"II"
				"I"		| 		"A"		|			1		|			0	   |	status().isBadRequest()	|			true			|		false				|	"{'numeralValue':'', 'numericValue': 0, 'requestsuccess': false}"	|	""
				"A"		| 		"A"		|			0		|			0	   |	status().isBadRequest()	|			false			|		false				|	"{'numeralValue':'', 'numericValue': 0, 'requestsuccess': false}"	|	""
	}
}
