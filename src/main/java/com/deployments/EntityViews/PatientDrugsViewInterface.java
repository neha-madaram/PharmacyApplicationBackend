package com.deployments.EntityViews;

import javax.persistence.Column;
import java.sql.Date;

public interface PatientDrugsViewInterface {

   String getPATIENTID();

   String getRXID();

    Date getRXEXPIRED();

    int getDOSAGE();

    String getDRUGNAME();
}
