package com.khanchych.tutor.facebookbot;

import com.khanchych.tutor.facebookbot.messages.Entry;
import com.khanchych.tutor.facebookbot.messages.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class WebHookController {

    private static final Logger logger = LoggerFactory.getLogger(WebHookController.class);

    public final static String MODE_SUBSCRIBE = "subscribe";
    public static final String EVENT_RECEIVED = "EVENT_RECEIVED";
    public static final String OBJECT_TYPE_PAGE = "page";

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
    public ResponseEntity<?> onMessage(@RequestBody Event event) {
        if (OBJECT_TYPE_PAGE.equals(event.getObject())) {
            for(Entry entry: event.getEntry()) {
                logger.info(entry.getMessaging()[0].getMessage().getText());
            }
            return ResponseEntity.ok().body(EVENT_RECEIVED);
        }

        return ResponseEntity.notFound().build();

    }
}

