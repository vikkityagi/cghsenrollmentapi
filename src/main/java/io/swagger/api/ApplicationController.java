package io.swagger.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.model.Application;
import io.swagger.repository.ApplicationRepo;



@RestController
public class ApplicationController {

    @Autowired
    ApplicationRepo applicationRepo;

    @GetMapping(value="/alllist")
    public List<Application> all(){
        List<Application> applicationList  = (List<Application>) applicationRepo.findAll();
        System.out.println(applicationList);
        return applicationList;
    }


    @GetMapping(value="/alldata")
    public Application get(){
        Optional<Application> applicationList  = applicationRepo.findById(154l);
        System.out.println(applicationList);
        Application application = applicationList.get();
        return application;
    }
    
}
