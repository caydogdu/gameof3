package com.gameof3.util;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

@Service
public class GameMessageSource {

    @Autowired
    ResourceBundleMessageSource messageSource;

    public String getKey(String key) {
        return messageSource.getMessage(key, null, Locale.ENGLISH);
    }

    public String getKey(String key, Object... args) {
        return messageSource.getMessage(key, args, Locale.ENGLISH);
    }

}
