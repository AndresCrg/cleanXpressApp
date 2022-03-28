package com.uptc.cleanXpress.controllers;

import com.uptc.cleanXpress.dao.service.ServiceDao;
import com.uptc.cleanXpress.models.Rating;
import com.uptc.cleanXpress.models.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController {

    @Autowired
    private ServiceDao serviceDao;

    @RequestMapping(value = "/api/services", method = RequestMethod.GET)
    public List<Service> getServices(){ return serviceDao.getServices(); }

    @RequestMapping(value = "/api/services", method = RequestMethod.POST)
    public void registerService(@RequestBody Service service){
        System.out.println(service.getFrequency() + " " + service.getPriority() + " " + service.getDate());
        serviceDao.registerService(service);
    }

    @RequestMapping(value = "/api/getServices/{id}", method = RequestMethod.DELETE)
    public void deleteService(@PathVariable String id){serviceDao.removeService(id);}
}
