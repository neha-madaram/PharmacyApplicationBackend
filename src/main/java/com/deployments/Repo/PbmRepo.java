package com.deployments.Repo;

import com.deployments.Entities.Drugs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PbmRepo extends JpaRepository<Drugs, Integer> {


}
