package com.kelly.consumer.controller;

import com.kelly.consumer.pojo.Depart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/depart")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

//    private static final String SERVICE_PRODUCER= "http://localhost:8081/depart/";
    private static final String SERVICE_PRODUCER = "http://kelly-provider-depart/depart/";

    @PostMapping("/")
    public boolean saveHandler(@RequestBody Depart depart){
        return restTemplate.postForObject(SERVICE_PRODUCER,depart,Boolean.class);
    }

    @DeleteMapping("/{id}")
    public void deleteHandler(@PathVariable("id") int id){
        String url = SERVICE_PRODUCER+id;
        restTemplate.delete(url);
    }

    @PutMapping("/")
    public void updateHandler(@RequestBody Depart depart){
        restTemplate.put(SERVICE_PRODUCER,depart);
    }

    @GetMapping("/{id}")
    public Depart getHandler(@PathVariable("id") int id){
        String url = SERVICE_PRODUCER+id;
        return restTemplate.getForObject(url,Depart.class);
    }

    @GetMapping("/")
    public List<Depart> listHandler(){
        return restTemplate.getForObject(SERVICE_PRODUCER, List.class);
    }


}
