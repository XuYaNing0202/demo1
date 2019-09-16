package com.example.demo.bean;


public class Area {

  private long id;
  private String areaName;
  private long parentId;
  private boolean open;

  @Override
  public String toString() {
    return "Area{" +
            "id=" + id +
            ", areaName='" + areaName + '\'' +
            ", parentId=" + parentId +
            ", open=" + open +
            '}';
  }

  public boolean isOpen() {
    return open;
  }

  public void setOpen(boolean open) {
    this.open = open;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getAreaName() {
    return areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }


  public long getParentId() {
    return parentId;
  }

  public void setParentId(long parentId) {
    this.parentId = parentId;
  }

}
