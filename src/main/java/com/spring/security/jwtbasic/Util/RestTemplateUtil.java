package com.spring.security.jwtbasic.Util;

import org.springframework.web.client.RestTemplate;

public class RestTemplateUtil {

    public static String getResponseFromUrl(RestTemplate restTemplate, String url){
        return restTemplate.getForEntity(url, String.class).getBody();
    }
}
