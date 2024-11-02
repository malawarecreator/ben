package com.example.ben.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController

public class EthController {
    public String ethurl = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=USD,EUR";
    @GetMapping("/eth")
    public ResponseEntity<String> geteth() {
        HttpHeaders ethheaders = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        RestTemplate ethget = new RestTemplate();
        String response = "";
        

        try {
            ethheaders.setContentType(MediaType.APPLICATION_JSON);
            response = ethget.getForObject(ethurl, String.class);
            status = HttpStatus.OK;

        } catch (Exception e) {
            System.out.println("Idk bro bad request?");
            status = HttpStatus.BAD_REQUEST;
        } finally {
            System.out.println("eth request done");
        }

        return new ResponseEntity<>(response, ethheaders, status);

    }
}
