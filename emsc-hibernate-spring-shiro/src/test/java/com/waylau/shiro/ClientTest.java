package com.waylau.shiro;

import com.waylau.shiro.HmacSHA256Utils;
 

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-2-26
 * <p>Version: 1.0
 */
public class ClientTest {
 
    private RestTemplate restTemplate = new RestTemplate();
 
 
 
 
    //@Test
    public void testServiceHelloSuccess() {
        String username = "admin";
        String param11 = "param11";
        String param12 = "param12";
        String param2 = "param2";
        String key = "dadadswdewq2ewdwqdwadsadasd";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add(Constants.PARAM_USERNAME, username);
        params.add("param1", param11);
        params.add("param1", param12);
        params.add("param2", param2);
        params.add(Constants.PARAM_DIGEST, HmacSHA256Utils.digest(key, params));

        String url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080")
                .queryParams(params).build().toUriString();

        ResponseEntity responseEntity = restTemplate.getForEntity(url, String.class);
        Assert.assertEquals("hello" + param11 + param12 + param2, responseEntity.getBody());
    }

   //@Test
    public void testServiceHelloFail() {
        String username = "admin";
        String param11 = "param11";
        String param12 = "param12";
        String param2 = "param2";
        String key = "dadadswdewq2ewdwqdwadsadasd";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add(Constants.PARAM_USERNAME, username);
        params.add("param1", param11);
        params.add("param1", param12);
        params.add("param2", param2);
        params.add(Constants.PARAM_DIGEST, HmacSHA256Utils.digest(key, params));
        params.set("param2", param2 + "1");

        String url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080")
                .queryParams(params).build().toUriString();

        try {
            ResponseEntity responseEntity = restTemplate.getForEntity(url, String.class);
        } catch (HttpClientErrorException e) {
            Assert.assertEquals(HttpStatus.UNAUTHORIZED, e.getStatusCode());
            Assert.assertEquals("login error", e.getResponseBodyAsString());
        }
    }
 
}
