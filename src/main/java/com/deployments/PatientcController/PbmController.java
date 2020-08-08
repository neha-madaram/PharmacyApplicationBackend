package com.deployments.PatientcController;

import com.deployments.Entities.Drugs;
import com.deployments.Entities.Dummy;
import com.deployments.PatientService.PbmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PbmController {

    @Autowired
    PbmService pbmService;

    @Autowired
    Dummy dummy;

    @GetMapping("/publican")
    public String publican()
    {
        return "publican";
    }

    @GetMapping("/createDrug")
    public Drugs createDrug()
    {
        return pbmService.createDrugs();
    }

    @PutMapping("/insertAllData")
    public String insertAllData()
    {
        return pbmService.insertAllData();
    }

    @GetMapping("/insert")
    public Dummy insert()
    {

        return pbmService.setDummy();
    }





}
