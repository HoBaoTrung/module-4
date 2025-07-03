package com.codegym.phonemanagementajaxwebservice.controller;

import com.codegym.phonemanagementajaxwebservice.configuration.UTF8Control;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/i18n")
public class I18nController {

//    @Autowired
//    private MessageSource messageSource;

    @GetMapping(produces = "application/json; charset=UTF-8")
    public Map<String, String> getAllMessages(@RequestParam(name = "lang", defaultValue = "en") String lang) {
        Locale locale = new Locale(lang);
//        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        ResourceBundle bundle = ResourceBundle.getBundle(
                "messages",
                locale,
                new UTF8Control()
        );

        Map<String, String> messages = new HashMap<>();

        for (String key : bundle.keySet()) {
//            messages.put(key, messageSource.getMessage(key, null, locale));
            messages.put(key, bundle.getString(key));
        }

        return messages;
    }

}
