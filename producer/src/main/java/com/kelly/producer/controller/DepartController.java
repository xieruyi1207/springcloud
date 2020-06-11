package com.kelly.producer.controller;

import com.kelly.producer.pojo.Depart;
import com.kelly.producer.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.invoke.convert.ConversionServiceParameterValueMapper;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depart")
public class DepartController {
    @Autowired
    private DepartService service;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/")
    public boolean saveHandler(@RequestBody Depart depart){
        return service.saveDepart(depart);
    }

    @DeleteMapping("/{id}")
    public boolean delHandler(@PathVariable("id") Integer id){
        return service.removeDepartById(id);
    }

    @PutMapping("/")
    public boolean updateHandler(@RequestBody Depart depart){
        return service.modifyDepart(depart);
    }

    @GetMapping("/{id}")
    public Depart getHandler(@PathVariable("id") Integer id){
        return service.getDepartById(id);
    }

    @GetMapping("/")
    public List<Depart> listHandler(){
        return service.listAllDeparts();
    }

    @GetMapping("/discovery/")
    public List<String> listDiscovery(){
        List<String> services = client.getServices();
        for(String service:services){
            List<ServiceInstance> instances = client.getInstances(service);
            for(ServiceInstance instance : instances){
                String serviceId = instance.getServiceId();
                String host = instance.getHost();
                System.out.println(serviceId+","+host);
            }
        }
        return services;
    }

}
