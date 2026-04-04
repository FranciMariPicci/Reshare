package org.generation.italy.reshare.model.services.implementations;

import org.generation.italy.reshare.dto.CityDto;
import org.generation.italy.reshare.model.repositories.abstractions.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<CityDto> getCities() {
        return cityRepository.findAll().stream().map(CityDto::new).toList();
    }
}