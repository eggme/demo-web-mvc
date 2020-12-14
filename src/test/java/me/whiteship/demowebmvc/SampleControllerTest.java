package me.whiteship.demowebmvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void helloTest() throws Exception {
        mockMvc.perform(get("/jun/hello")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
//        this.mockMvc.perform(get("/hi"))
//                .andDo(print())
//                .andExpect(status().isOk());

    }

    @Test
    public void helloThymeleaf() throws Exception{
        mockMvc.perform(get("/jun/seungjun"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string("hello seungjun"));

        mockMvc.perform(post("/jun/hi"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello seungjun"));

        mockMvc.perform(get("/jun/map?name=엄준식"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello 엄준식"));

        mockMvc.perform(get("/jun/seungjun"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello seungjun"));
    }

    @Test
    public void mediaTypeTest() throws Exception{
        String name = "Lee";
        mockMvc.perform(get("/jun/helloMediaType1")
                .header(HttpHeaders.FROM, "localhost")
                .param("name", name))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello "+name));

    }


}