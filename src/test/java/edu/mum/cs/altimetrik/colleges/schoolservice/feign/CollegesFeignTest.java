package edu.mum.cs.altimetrik.colleges.schoolservice.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.mum.cs.altimetrik.colleges.schoolservice.CollegeServiceApplicationTests;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CollegesFeignTest extends CollegeServiceApplicationTests {
    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getColleges() throws Exception {

        //Mockito.when(countryService.isValidCountrySearch(Mockito.any(CountrySearchDto.class))).thenReturn(true);
        String govApiUrl = "https://api.data.gov/ed/collegescorecard/v1/schools.json?school.degrees_awarded.predominant=2,3&fields=id,school.name,2017.student.size&per_page=10&page=1&zip=02215&distance=10mi&api_key=dr6fglRaiMGkPXFF3FPhDSYgLK3BsATh0nFY0ePZ";
        mockMvc.perform(MockMvcRequestBuilders.get(govApiUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
        ;

    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
