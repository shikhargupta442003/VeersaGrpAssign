package com.example.VeersaGrp.service;

import com.example.VeersaGrp.dto.ServiceDto;

public interface ServiceService {
    ServiceDto registerService(ServiceDto serviceDto);

    ServiceDto findService(Long serviceId);
}
