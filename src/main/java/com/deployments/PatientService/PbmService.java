package com.deployments.PatientService;

import com.deployments.Entities.Drugs;
import com.deployments.Entities.Dummy;
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

    @Autowired
    Dummy dummy;

    public Drugs createDrugs()
    {
        drugs.setDrugId(1);
        drugs.setDrugName("Lipton");
        drugs.setAvailable(true);
        drugs.setPriceperUnit(10);
        return pbmRepo.save(drugs);

    }

    public String insertAllData()
    {
        drugs.setDrugId(2);
        drugs.setDrugName("thylnol");
        drugs.setAvailable(true);
        drugs.setPriceperUnit(5);
        pbmRepo.save(drugs);
        return "inserted";
    }


    public Dummy setDummy() {
        dummy.setName("Neha");
        dummy.setRollno(1);
        return dummy;
    }
}
