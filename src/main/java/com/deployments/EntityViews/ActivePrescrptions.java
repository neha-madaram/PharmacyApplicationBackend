package com.deployments.EntityViews;

import java.sql.Date;

public interface ActivePrescrptions {
    String getPATIENTID();

    String getRXID();

    Date getRXEXPIRED();

    int getDOSAGE();

    String getDRUGNAME();
}
