package com.khanchych.tutor.facebookbot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(WebHookController.class)
public class WebHookControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void onMessageSent() throws Exception {
        mvc.perform(post("/webhook", "mode", "token", "challenge"))
                .andExpect(status().isOk())
                .andExpect(status().isOk());
    }

}