package com.deployments.Repo;

import com.deployments.Entities.Patients;
import com.deployments.Entities.Rx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface RxRepo extends JpaRepository<Rx, String> {
    @Modifying
    @Transactional
    @Query(value="update Rx set rxExpired = DATE_ADD(rxExpired, INTERVAL 1 month ) where patientId=?1", nativeQuery = true)
    void ExtendPrescription(String patientId);
/*sdfcv
    sdf
        sdfg*/
}
