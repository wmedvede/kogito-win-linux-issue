package io.priax.process;

import java.util.Date;

public class Alert {

    private String newValue;
    private int kpiId;
    private Date date;

    
    public String getNewValue() {
        return newValue;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public int getKpiId() {
        return kpiId;
    }
    public void setKpiId(int kpiId) {
        this.kpiId = kpiId;
    }
    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }
    
}
