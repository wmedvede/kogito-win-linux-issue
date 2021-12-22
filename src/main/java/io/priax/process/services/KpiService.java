package io.priax.process.services;

import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.priax.process.Alert;
import io.priax.process.AlertKpiStatusComposition;
import io.priax.process.KpiStatus;

@ApplicationScoped 
public class KpiService {

    private static final Logger logger = LoggerFactory.getLogger(KpiService.class);

    public AlertKpiStatusComposition setAlertKpiStatus(Alert alert) throws Exception{
        logger.info("kpi status received :" + alert.getNewValue());
        AlertKpiStatusComposition response = new AlertKpiStatusComposition();
        if(alert.getKpiId() == 0){
            response.setKpiStatus(new KpiStatus());
            response.setAlert(alert);
            return response;
        }else{
            throw new Exception("Let me check in management-console");
        }
        
        
    }

    
}
