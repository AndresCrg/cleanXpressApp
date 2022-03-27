package com.uptc.cleanXpress.controllers;

import com.uptc.cleanXpress.dao.service.ServiceDao;
import com.uptc.cleanXpress.models.Rating;
import com.uptc.cleanXpress.models.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController {

    private ServiceDao serviceDao;

    @RequestMapping(value = "/api/getServices", method = RequestMethod.GET)
    public List<Service> getServices(){ return serviceDao.getServices(); }

    @RequestMapping(value = "/api/registerService", method = RequestMethod.POST)
    public void registerService(@RequestBody Service service){ serviceDao.registerService(service);}

    @RequestMapping(value = "/api/getServices/{id}", method = RequestMethod.DELETE)
    public void deleteService(@PathVariable String id){serviceDao.removeService(id);}
}
