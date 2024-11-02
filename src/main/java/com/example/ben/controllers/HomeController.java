package com.example.ben.controllers;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
@RestController
public class HomeController {
    
    public String bcurl = "https://api.coindesk.com/v1/bpi/currentprice.json";
    @GetMapping("/")
    public ResponseEntity<String> gethome() {
        String response = "";
        RestTemplate bcget = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.OK;
        try {
            headers.setContentType(MediaType.APPLICATION_JSON);
            response = bcget.getForObject(bcurl, String.class);
            status = HttpStatus.OK;
            
        } catch (Exception e) {
            System.out.println("smth happened (idk what)");
            status = HttpStatus.BAD_REQUEST;
        } finally {
            
            System.out.println("btc request done");

        }
        return new ResponseEntity<>(response, headers, status);
    }
}
