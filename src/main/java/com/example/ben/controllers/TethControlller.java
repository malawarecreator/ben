package com.example.ben.controllers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.http.*;

import org.springframework.web.client.RestTemplate;
@RestController
public class TethControlller {
    public String usdturl = "https://min-api.cryptocompare.com/data/price?fsym=USDT&tsyms=USD,EUR";
    @GetMapping("/usdt")
    public ResponseEntity<String> getusdt() {
        String response = "";
        RestTemplate usdtget = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        try {
            headers.setContentType(MediaType.APPLICATION_JSON);
            response = usdtget.getForObject(usdturl, String.class);
            status = HttpStatus.OK;
        } catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            System.out.println("smth happened");
            
        } finally {
            System.out.println("Tether request done");
        }
        return new ResponseEntity<>(response, headers, status);
    }
}
