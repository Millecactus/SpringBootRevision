package com.TomcatWhereAreU.demo.Service.impl;

import com.TomcatWhereAreU.demo.entity.Students;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class StudentServiceImplTest {


    @Autowired

    private WebApplicationContext webApplicationContext;
    private MockMvc mvc;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {
        mvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void shouldSaveStudents() throws Exception{
        Students studentToSave = new Students();
        studentToSave.setFirstname("testy");
        studentToSave.setLastname("test");
        studentToSave.setEmail("email@test.com");

        MvcResult result= mvc.perform(
                post("/appStudents/save")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(mapper.writeValueAsString(studentToSave))
        ).andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}