package com.deployments.PatientcController;

import com.deployments.PatientService.PbmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PbmController {

    @Autowired
    PbmService pbmService;


    @PutMapping("/createDrug")
    public String createDrug()
    {
        return pbmService.createDrugs();
    }

    @PutMapping("insertAllData")
    public String insertAllData()
    {
        return "inserted";
    }


}
