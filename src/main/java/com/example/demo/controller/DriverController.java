package com.example.demo.controller;

import com.example.demo.model.Driver;
import com.example.demo.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DriverController {
    @Autowired
    DriverRepository driverRepository;

    @GetMapping("/drivers")
    public Iterable<Driver> read() {
        return driverRepository.findAll();
    }

    @PostMapping("/drivers")
    public Driver create(@RequestBody Driver driver){
        return driverRepository.save(driver);

    }
    @DeleteMapping("/drivers/{id}")
    public Boolean delete(@PathVariable Long id){
        if (driverRepository.existsById(id)){
            driverRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }
    @PutMapping("/drivers")
    public Driver update(@RequestBody Driver newDriver){
        if (driverRepository.findById(newDriver.getId()).isPresent()){
            Driver oldDriver = driverRepository.findById(newDriver.getId()).get();
            oldDriver.setName(newDriver.getName());
            oldDriver.setPlaceNow(newDriver.getPlaceNow());
            return driverRepository.save(oldDriver);
        } else{
            return driverRepository.save(newDriver);
        }

    }
}
