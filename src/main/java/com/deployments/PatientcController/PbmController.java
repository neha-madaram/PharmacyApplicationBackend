package com.deployments.PatientcController;

import com.deployments.Entities.*;
import com.deployments.EntityViews.PatientDrugsViewInterface;
import com.deployments.Exceptions.InvalidArgumentExceptions;
import com.deployments.PatientService.PbmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "*")
public class PbmController {

    @Autowired
    PbmService pbmService;

    private static Logger logger = LoggerFactory.getLogger(PbmService.class);

    /* Gets patient's current and previous prescriptions */
    @GetMapping("/getPatientDrugs")
    public ResponseEntity<List<PatientDrugsViewInterface>> getPatientDrugs(@RequestParam String patientId)
    {
        logger.info("in patientsDrugView controller");
        logger.info("patientId "+patientId);
        return ResponseEntity.status(HttpStatus.OK).body(pbmService.patientsDrugsView(patientId));
    }

    /* This method saves a new prescription request */
    @PostMapping("/prescriptionRequest") //create
    public ResponseEntity<RxRequest> prescriptionRequest(@RequestBody RxRequest rxRequest) throws SQLException {
            logger.info("prescriptionRequest:");
            logger.info("rxRequest "+rxRequest);
            logger.info("create request for patient Id: "+ rxRequest.getId().getPatientId());
        logger.info("create request for prescriber Id: "+ rxRequest.getId().getPrescriberId());
            return ResponseEntity.status(HttpStatus.OK).body(pbmService.presciptionrequest(rxRequest));
    }

    /* Gets all */
    @GetMapping("/getActivePrescriptionDetails")
    public ResponseEntity<List<PatientDrugsViewInterface>> getActivePrescriptions(@RequestParam String patientId){
        logger.info("getActivePrescriptions:");
        logger.info("patient ID: "+patientId);
        return ResponseEntity.status(HttpStatus.OK).body(pbmService.getActivePrescription(patientId));
    }

    /* Update a patient RxId to plus one month --- still working */
    @PostMapping("/updatePrescriptionExpiry")
    public ResponseEntity<String> updatePrescriptionRequest(@RequestParam String patientId) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(pbmService.setExtendPrescription(patientId));
    }

    @PostMapping("/createDrugs") //create with validations //ResponseEntity
    public Drugs createDrugs(@Valid @RequestBody Drugs drugs, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors())
        {
            logger.info("invalid parameters provided");
            throw new InvalidArgumentExceptions("enter correct details"); //
        }
        return pbmService.createDrugs(drugs);

    }

    @DeleteMapping("/deleteDrug") //delete Rx
    public ResponseEntity<String> deleteDrug(@RequestBody String drugId)
    {

        return ResponseEntity.status(HttpStatus.OK).body( pbmService.deleteDrug(drugId));

    }
}
