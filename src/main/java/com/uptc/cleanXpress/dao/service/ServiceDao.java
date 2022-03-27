package com.uptc.cleanXpress.dao.service;

import com.uptc.cleanXpress.models.Service;

import java.util.List;

public interface ServiceDao {

    List<Service> getServices();

    void removeService(String id);

    void registerService(Service service);

}
