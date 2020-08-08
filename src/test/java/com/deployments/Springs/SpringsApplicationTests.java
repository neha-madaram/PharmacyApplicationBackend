
package com.deployments.Springs;

import com.deployments.Entities.Drugs;
import com.deployments.PatientService.PbmService;
import com.deployments.Repo.PbmRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


import static org.hamcrest.Matchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringsApplicationTests {

	@Autowired
	private PbmService pbmService;

	@MockBean
	private PbmRepo pbmRepo;

	@Test
	void createDrugTest() {
		Drugs drugs = new Drugs();
		drugs.setDrugId(1);
		drugs.setDrugName("lipton");
		drugs.setPriceperUnit(10);
		drugs.setAvailable(true);
		when(pbmRepo.save(Mockito.any(Drugs.class))).thenReturn(drugs);
		assertEquals(drugs, pbmService.createDrugs());
	}

}

