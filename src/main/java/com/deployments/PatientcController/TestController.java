
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
@RequestMapping("/test")
@CrossOrigin(origins = "*")
public class TestController {

    @Autowired
    PbmService pbmService;

    private static Logger logger = LoggerFactory.getLogger(PbmService.class);

    @GetMapping("/ok")
    public String ok()
    {
        return "ok";
    }
}

