package com.khanchych.tutor.facebookbot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WebHookController.class)
public class WebHookControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void onMessageSent() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/webhook")
                .param("hub.mode", "mode")
                .param("hub.verify_token", "token")
                .param("hub.challenge", "challenge")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk());
    }
}