package com.visservice.visservicetwo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CheckService {

    private final RestTemplate restTemplate;

    public CheckService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "newCall")
    public String readData(){
        return restTemplate.getForObject("http://localhost:8080/message",String.class);
    }

    public String newCall(){
        return "Fall back method executed";
    }
}
