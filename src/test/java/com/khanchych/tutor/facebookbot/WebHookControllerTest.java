package com.khanchych.tutor.facebookbot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WebHookController.class)
public class WebHookControllerTest {

    @Value("${facebook-bot.verify-token}")
    private String VERIFY_TOKEN;

    @Autowired
    private MockMvc mvc;

    private final static String CHALLENGE_ACCEPTED = "CHALLENGE_ACCEPTED";

    @Test
    public void onSubscribe() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/webhook")
                .param("hub.mode", WebHookController.MODE_SUBSCRIBE)
                .param("hub.verify_token", VERIFY_TOKEN)
                .param("hub.challenge", CHALLENGE_ACCEPTED)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(content().string(CHALLENGE_ACCEPTED))
                .andExpect(status().isOk());
    }
}