package io.swagger.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.model.Application;
import io.swagger.model.BenRegistrationApplication;
import io.swagger.model.NodalApplicationDetail;
import io.swagger.repository.ApplicationRepo;
import io.swagger.repository.BenRegistrationApplicationRepo;
import io.swagger.repository.NodalApplicationDetailRepo;

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;
import java.util.List;  

@RestController
@CrossOrigin
@RequestMapping(value="/api/v1/")
public class TestController {

    @Autowired
    private BenRegistrationApplicationRepo benRepo;
    @Autowired
    private NodalApplicationDetailRepo nodalRepo;
    @Autowired
    private ApplicationRepo appRepo;
    
    @RequestMapping(value = "/v1",method = RequestMethod.POST)
    public ResponseEntity<BenRegistrationApplication> createBen(){

        System.out.println("call");
        LocalDateTime now = LocalDateTime.now(); 
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        String formatDateTime = now.format(format);

        BenRegistrationApplication benReg = new BenRegistrationApplication();
        benReg.setApplicationNumber("101123");
        benReg.setParichayId("vikram.singh85");
        benRepo.save(benReg);
        // appRepo.save(benReg);


        return new ResponseEntity<BenRegistrationApplication>(HttpStatus.OK);
    }

    @RequestMapping(value = "/v2",method = RequestMethod.POST)
    public ResponseEntity<NodalApplicationDetail> createNodal(){


        NodalApplicationDetail nodalApp = new NodalApplicationDetail();

        nodalApp.setStrength("12");
        nodalApp.setParichayId("vikram.singh85");
        // appRepo.save(nodalApp);
        nodalRepo.save(nodalApp);
        
        return new ResponseEntity<NodalApplicationDetail>(nodalApp,HttpStatus.OK);
    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ResponseEntity<List<Application>> list(){
        List<Application> app = (List<Application>) appRepo.findAll();
        return new ResponseEntity<List<Application>>(app ,HttpStatus.OK);
    }

}
