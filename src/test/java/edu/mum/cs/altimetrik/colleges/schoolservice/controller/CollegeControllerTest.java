package edu.mum.cs.altimetrik.colleges.schoolservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.mum.cs.altimetrik.colleges.schoolservice.CollegeServiceApplicationTests;
import edu.mum.cs.altimetrik.colleges.schoolservice.dto.College;
import edu.mum.cs.altimetrik.colleges.schoolservice.dto.SearchItem;
import edu.mum.cs.altimetrik.colleges.schoolservice.service.CollegeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CollegeControllerTest extends CollegeServiceApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Mock
    CollegeService collegeService;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void searchCollegeTest() throws Exception {
        List<College> colleges = new ArrayList<>();
        SearchItem item = new SearchItem();

        Mockito.when(collegeService.getColleges(Mockito.any(SearchItem.class))).thenReturn(colleges);
        Mockito.when(collegeService.isValidCollegeSearch(Mockito.any(SearchItem.class))).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/college/search").content(asJsonString(item)).content(asJsonString(item))
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
