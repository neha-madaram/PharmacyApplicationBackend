package com.deployments.PatientService;

import com.deployments.Entities.*;
import com.deployments.EntityViews.PatientDrugsViewInterface;
import com.deployments.Exceptions.PatientIdNotFoundException;
import com.deployments.Exceptions.IdNotValidException;
import com.deployments.Repo.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.regex.*;


@Service
@Component
public class PbmService {
    Pattern p;
    Matcher m;
    private static Logger logger = LoggerFactory.getLogger(PbmService.class);


    @Autowired
    PatientDrugsViewRepo patientDrugsViewRepo;

    @Autowired
    PrescriptionRequestRepo prescriptionRequestRepo;

    @Autowired
    RxRepo rxRepo;

    @Autowired
    DrugsRepo drugsRepo;

    public List<PatientDrugsViewInterface> patientsDrugsView(String patientId) {
        p = Pattern.compile("PA+[0-9]{5}");
        m = p.matcher(patientId);
        if(!m.matches()){
           throw new IdNotValidException("Enter Correct Patient Details.\n Example: PA12323 ");
        }
        if(patientDrugsViewRepo.getAllPatientDetails(patientId).size()==0)
        {
            logger.info("throwing an exception");
            throw new PatientIdNotFoundException("patient id: "+patientId+" unavailable");
        }
        logger.info("response returning");
        return patientDrugsViewRepo.getAllPatientDetails(patientId);
    }

    //Can we write throw inside catch?????
    public RxRequest presciptionrequest(RxRequest rxRequest) {
        String patientId = rxRequest.getPrescriptionRequestID().getPatientId();
        String prescriberId = rxRequest.getPrescriptionRequestID().getPrescriberId();
        p = Pattern.compile("PR[0-9]{5}");
        m = p.matcher(prescriberId);
        if(!m.matches()){
            throw new IdNotValidException("Invalid Prescriber Id \n Example: PR12323");
        }
        p = Pattern.compile("PA[0-9]{5}");
        m = p.matcher(patientId);
        if(!m.matches()){
            throw new IdNotValidException("Invalid Patient Id \n Example: PA12323");
        }
        RxRequest r = new RxRequest();
        r.setUpdate(false);
        r.setPrescriptionRequestID(rxRequest.getPrescriptionRequestID());
        r.setComments(rxRequest.getComments());
        r.setPriority(rxRequest.getPriority());
        try {
            r= prescriptionRequestRepo.save(rxRequest);
        }catch(DataIntegrityViolationException e){
          throw new DataIntegrityViolationException("Unable to request for an prescription that is already existing");
        }
        logger.info("returning"+r);
        return r;

    }

    public String setExtendPrescription(String patientId) throws Exception {
        rxRepo.ExtendPrescription(patientId);
        //if(true) throw new IllegalArgumentException("abc");
        return "prescription extended";
    }

    public Drugs createDrugs(Drugs drugs) {
            return drugsRepo.save(drugs);
    }

    public String deleteDrug(String drugId) {
        try {

            drugsRepo.deleteById(drugId);
        }
        catch (Exception ex)
        {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Id provided not found", ex);
        }
        return "deleted";
    }

    public List<PatientDrugsViewInterface> getActivePrescription(String patientId) {
        return patientDrugsViewRepo.getActivePrescription(patientId);

    }
}