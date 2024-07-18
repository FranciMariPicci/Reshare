package org.generation.italy.reshare.model.services.implementations;

import org.generation.italy.reshare.exceptions.EntityNotFoundException;
import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.City;
import org.generation.italy.reshare.model.repositories.abstractions.AppUserRepository;
import org.generation.italy.reshare.model.repositories.abstractions.CityRepository;
import org.generation.italy.reshare.model.services.abstractions.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserServiceImp implements AppUserService {
    private AppUserRepository appUserRepo;
    private CityRepository cityRepo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    public AppUserServiceImp(AppUserRepository appUserRepo, CityRepository cityRepo) {
        this.appUserRepo = appUserRepo;
        this.cityRepo = cityRepo;
    }

    @Override
    public AppUser saveUser(AppUser u) {
        u.setPassword(encoder.encode(u.getPassword()));
        return appUserRepo.save(u);
    }

    @Override
    public AppUser getUserById(long id) throws EntityNotFoundException {
        Optional<AppUser> u = appUserRepo.findById(id);
        if(u.isEmpty()){
            throw new EntityNotFoundException(u.getClass(), id);
        }
        return u.get();
    }

    @Override
    public AppUser getUserByEmail(String email) {
        return appUserRepo.findByEmail(email);
    }

    @Override
    public City getCityByName(String name) {
        return cityRepo.findByName(name);
    }


}
