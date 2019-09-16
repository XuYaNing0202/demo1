package com.example.demo.bean;


import java.util.Date;

public class TbCityData {

  private long id;
  private String institutionName;
  private String plannedQuantity;
  private String actualQuantity;
  private double exacutiveRate;
  private String newClient;
  private String oldClient;
  private String intentionClient;
  private long estimatedPremium;
  private Date createTime;
  private Long areaId;


  @Override
  public String toString() {
    return "TbCityData{" +
            "id=" + id +
            ", institutionName='" + institutionName + '\'' +
            ", plannedQuantity='" + plannedQuantity + '\'' +
            ", actualQuantity='" + actualQuantity + '\'' +
            ", exacutiveRate=" + exacutiveRate +
            ", newClient='" + newClient + '\'' +
            ", oldClient='" + oldClient + '\'' +
            ", intentionClient='" + intentionClient + '\'' +
            ", estimatedPremium=" + estimatedPremium +
            ", createTime=" + createTime +
            ", areaId=" + areaId +
            '}';
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getInstitutionName() {
    return institutionName;
  }

  public void setInstitutionName(String institutionName) {
    this.institutionName = institutionName;
  }

  public String getPlannedQuantity() {
    return plannedQuantity;
  }

  public void setPlannedQuantity(String plannedQuantity) {
    this.plannedQuantity = plannedQuantity;
  }

  public String getActualQuantity() {
    return actualQuantity;
  }

  public void setActualQuantity(String actualQuantity) {
    this.actualQuantity = actualQuantity;
  }

  public double getExacutiveRate() {
    return exacutiveRate;
  }

  public void setExacutiveRate(double exacutiveRate) {
    this.exacutiveRate = exacutiveRate;
  }

  public String getNewClient() {
    return newClient;
  }

  public void setNewClient(String newClient) {
    this.newClient = newClient;
  }

  public String getOldClient() {
    return oldClient;
  }

  public void setOldClient(String oldClient) {
    this.oldClient = oldClient;
  }

  public String getIntentionClient() {
    return intentionClient;
  }

  public void setIntentionClient(String intentionClient) {
    this.intentionClient = intentionClient;
  }

  public long getEstimatedPremium() {
    return estimatedPremium;
  }

  public void setEstimatedPremium(long estimatedPremium) {
    this.estimatedPremium = estimatedPremium;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Long getAreaId() {
    return areaId;
  }

  public void setAreaId(Long areaId) {
    this.areaId = areaId;
  }
}
