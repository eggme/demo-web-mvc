package me.whiteship.demowebmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class Sample2ControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void test() throws Exception{
        mockMvc.perform(options("/test")
        .param("name","body~")
        .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(header().stringValues(HttpHeaders.ALLOW, hasItems(containsString("GET"),
                                                                    containsString("HEAD"),
                                                                    containsString("POST"),
                                                                    containsString("OPTIONS")
        )));
    }


    @Test
    public void customAnnotationTest() throws Exception{
        mockMvc.perform(get("/hello"))
                .andDo(print())
                .andExpect(content().string("hello :D"));
    }


    @Test
    public void problemTest() throws Exception{
        mockMvc.perform(get("/events"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void problemWithIdTest() throws Exception{
        mockMvc.perform(get("/events/2"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void postProblemWithIdTest() throws Exception{
        mockMvc.perform(post("/events/3")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void deleteProblemWithIdTest() throws Exception{
        mockMvc.perform(delete("/events/4"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void putProblemWithIdTest() throws Exception{
        mockMvc.perform(put("/events/4")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

}