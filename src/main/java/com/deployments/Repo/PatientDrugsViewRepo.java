package com.deployments.Repo;

import com.deployments.Entities.Drugs;
import com.deployments.EntityViews.PatientDrugsViewInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientDrugsViewRepo extends JpaRepository<Drugs, String> {

    @Query(value="select p.patientId, r.rxId, r.rxExpired, rd.dosage, d.drugName from Rx r, RxDrugs rd, drugs d, Patients p where p.patientId = r.patientId and r.rxId = rd.rxId and rd.drugId = d.drugId and p.patientId = ?1", nativeQuery = true)
    List<PatientDrugsViewInterface> getAllPatientDetails(String patientId);

   /* @Query(value="update Rx set rxExpired = DATE_ADD(rxExpired, INTERVAL 1 month ) where patientId=?1", nativeQuery = true)
    Object setExtendPrescription(String patientId);*/

    @Query(value="select p.patientId, r.rxId, r.rxExpired, rd.dosage, d.drugName from Rx r, RxDrugs rd, drugs d, Patients p where p.patientId = ?1 and p.patientId = r.patientId  and r.active= 'yes'  and r.rxId = rd.rxId and rd.drugId = d.drugId", nativeQuery = true)
    List<PatientDrugsViewInterface> getActivePrescription(String patientId);
}
