package org.generation.italy.reshare.model.repositories.abstractions;

import org.generation.italy.reshare.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
    City findByName(String name);
}
