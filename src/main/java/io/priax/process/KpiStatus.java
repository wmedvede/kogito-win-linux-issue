package io.priax.process;

public class KpiStatus {

    private Long receivedAt;
    private Long detectedAt;
    private String newStatus;
    private String oldStatus;
    private long beingId;
    private long kpiId;
    private Integer kpiMaxDelay;
   
    public long getBeingId() {
        return beingId;
    }
    public Integer getKpiMaxDelay() {
        return kpiMaxDelay;
    }
    public void setKpiMaxDelay(Integer kpiMaxDelay) {
        this.kpiMaxDelay = kpiMaxDelay;
    }
    public long getKpiId() {
        return kpiId;
    }
    public void setKpiId(long kpiId) {
        this.kpiId = kpiId;
    }
    public Long getDetectedAt() {
        return detectedAt;
    }
    public void setDetectedAt(Long detectedAt) {
        this.detectedAt = detectedAt;
    }
    public Long getReceivedAt() {
        return receivedAt;
    }
    public void setReceivedAt(Long receivedAt) {
        this.receivedAt = receivedAt;
    }
    public String getOldStatus() {
        return oldStatus;
    }
    public void setOldStatus(String oldStatus) {
        this.oldStatus = oldStatus;
    }
    public String getNewStatus() {
        return newStatus;
    }
    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }
    public void setBeingId(long beingId) {
        this.beingId = beingId;
    }
    
    
}
