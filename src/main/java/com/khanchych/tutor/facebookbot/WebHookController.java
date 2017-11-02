package com.khanchych.tutor.facebookbot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class WebHookController {

    private final static String MODE_SUBSCRIBE = "subscribe";

    @Value("${facebook-bot.verify-token}")
    private String VERIFY_TOKEN;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> onSubscribe(
            @RequestParam("hub.mode") String mode,
            @RequestParam("hub.verify_token") String verify_token,
            @RequestParam("hub.challenge") String challenge) {
        String answer = null;

        if (MODE_SUBSCRIBE.equals(mode) && VERIFY_TOKEN.equals(verify_token)) {
            answer = challenge;
        }

        return ResponseEntity.ok().body(answer);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> onMessage(String body) {

        return ResponseEntity.ok().body(null);
    }
}

