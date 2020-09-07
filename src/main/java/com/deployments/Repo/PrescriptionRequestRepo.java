package com.deployments.Repo;

import com.deployments.Entities.RxRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRequestRepo extends JpaRepository<RxRequest, String> {

}
