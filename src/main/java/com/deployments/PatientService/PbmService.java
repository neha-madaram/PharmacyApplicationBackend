package com.deployments.PatientService;

import com.deployments.Entities.Drugs;
import com.deployments.Repo.PbmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class PbmService {

    @Autowired
    PbmRepo pbmRepo;

    @Autowired
    Drugs drugs;

    public String createDrugs()
    {
        drugs.setDrugId(1);
        drugs.setDrugName("Lipton");
        drugs.setAvailable(true);
        drugs.setPriceperUnit(10);
        pbmRepo.save(drugs);
        return "saved";
    }


}
